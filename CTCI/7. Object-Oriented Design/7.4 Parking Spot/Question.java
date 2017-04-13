import java.util.Random;
public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot();
		Random ran = new Random();
                    

		Vehicle v = null;
		while (v == null || lot.parkVehicle(v)) {
			lot.print();
			int r = ran.nextInt(6) + 5;
			if (r < 2) {
				v = new Bus();
			} else if (r < 4) {
				v = new Motorcycle();
			} else {
				v = new Car();
			}
			System.out.print("\nParking a ");
			v.print();
			System.out.println("");
		}
		System.out.println("Parking Failed. Final state: ");
		lot.print();
	}

}