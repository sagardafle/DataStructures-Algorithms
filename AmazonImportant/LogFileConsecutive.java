import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat; 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.nio.*;


public class LogFileConsecutive {
    public static void main(String[] args) {
       Set<String> res = getLoggedInUsersForConsecutiveThreeDays();
       System.out.println(res);
    }
    
  public static Set<String> getLoggedInUsersForConsecutiveThreeDays() throws IOException {
		Map<String, Map<Date, Integer>> dataStruc = new HashMap<String, Map<Date, Integer>>();
		Path path = Paths.get("", "logfile.txt");
		Set<String> users = new HashSet<String>();
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
			for (String line : (Iterable<String>) lines::iterator) {
				StringTokenizer st = new StringTokenizer(line, "\t");
				Date currDate = new Date((String) st.nextElement());
				String user = (String) st.nextElement();
				if (dataStruc.containsKey(user)) {
					Map<Date, Integer> dateDays = dataStruc.get(user);
					Date lastDate = dateDays.keySet().iterator().next();
					int consecutiveDays = dateDays.get(lastDate);
					if (currDate.getTime() - lastDate.getTime() == (24 * 60 * 60 * 1000)) {
						consecutiveDays++;
						dateDays.remove(lastDate);
						dateDays.put(currDate, consecutiveDays);
						if (consecutiveDays >= 3) {
							users.add(user);
						}
					} else {
						dateDays.remove(lastDate);
						dateDays.put(currDate, 1);
					}
					dataStruc.put(user, dateDays);
				} else {
					Map<Date, Integer> dateDays = new HashMap<Date, Integer>();
					dateDays.put(currDate, 1);
					dataStruc.put(user, dateDays);
				}
			}
		}
		return users;
	}
}
