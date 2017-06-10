/*https://careercup.com/question?id=5178781644881920*/
import java.util.*;
public class Traveller {

    private List < Ticket > tickets;
    private Flight root = null;

    /**
     * @param args
     */
    public static void main(String[] args) {
        List < Ticket > routes = new ArrayList < Ticket > ();
        Traveller traveller = new Traveller();
        Ticket route1 = new Ticket("ADD", "JFK");
        routes.add(route1);
        Ticket route8 = new Ticket("JFK", "BWI");
        routes.add(route8);
        Ticket route2 = new Ticket("IAD", "ATL");
        routes.add(route2);
        Ticket route3 = new Ticket("JFK", "IAD");
        routes.add(route3);
        Ticket route4 = new Ticket("ATL", "LAX");
        routes.add(route4);
        Ticket route5 = new Ticket("ORD", "ADD");
        routes.add(route5);
        Ticket route6 = new Ticket("LAX", "DCA");
        routes.add(route6);
        Ticket route7 = new Ticket("DCA", "JFK");
        routes.add(route7);

        traveller.setTickets(routes);
        traveller.mapTraveller();
    }

    public Traveller() {
        this.tickets = new ArrayList < Ticket > ();
    }

    public void setTickets(List < Ticket > tickets) {
        this.tickets = tickets;
    }

    public void addFlight(Ticket ticket) {
        Flight flight = new Flight(ticket);
        if (root == null) {
            root = flight;
            return;
        }

        if (flight.ticket.stop == root.ticket.start) {
            root.previousFlight = flight;
            flight.nextFlight = root;
            root = flight;
            return;
        }

        Flight current = root;
        Flight left = null;
        Flight right = null;
        while (current != null) {
            if (flight.ticket.start == current.ticket.stop) {
                left = current;
            } else if (flight.ticket.stop == current.ticket.start) {
                right = current;
            }

            if (current.nextFlight == null) {
                break;
            }

            current = current.nextFlight;

        }

        if (left != null && right != null) {
            Flight temp1 = left.nextFlight;
            Flight temp2 = right.nextFlight;

            left.nextFlight = flight;
            flight.nextFlight = right;
            right.nextFlight = temp1;
            if (temp1 != null) {
                temp1.nextFlight = temp2;
            }
        } else if (left != null) {
            Flight temp = left.nextFlight;
            left.nextFlight = flight;
            flight.nextFlight = temp;
        } else {
            current.nextFlight = flight;
        }

    }

    public void mapTraveller() {
        for (Ticket ticket: this.tickets) {
            this.addFlight(ticket);
        }

        if (root != null) {
            Flight current = root;
            while (current != null) {
                System.out.println(current.ticket.start + " -> " + current.ticket.stop);
                current = current.nextFlight;
            }
        }
    }
}

class Ticket {
    String start;
    String stop;

    Ticket(String start, String stop) {
        this.start = start;
        this.stop = stop;
    }
}

class Flight {
    Flight previousFlight;
    Flight nextFlight;
    Ticket ticket;

    Flight(Ticket ticket) {
        this.ticket = ticket;
    }
}