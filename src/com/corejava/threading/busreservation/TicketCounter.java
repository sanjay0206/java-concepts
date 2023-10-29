package com.corejava.threading.busreservation;

public class TicketCounter {
    private int availableSeats;

    public TicketCounter(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void bookTicket(String pname, int numberOfSeats) {
        if ((availableSeats >= numberOfSeats) && (numberOfSeats > 0)) {
            System.out.printf("Hi %s! %d seat%s %s booked successfully.. %n",
                    pname,
                    numberOfSeats,
                    (numberOfSeats == 1) ? "" : "s",
                    (numberOfSeats == 1) ? "is" : "are");
            availableSeats = availableSeats - numberOfSeats;
        } else {
            System.out.printf("Hi %s! Could not book %d seat%s because %s seat%s %s available right now.%n",
                    pname,
                    numberOfSeats,
                    (numberOfSeats == 1) ? "" : "s",
                    (availableSeats == 0) ? "no" : availableSeats,
                    (availableSeats == 1) ? "" : "s",
                    (availableSeats == 1) ? "is" : "are");
        }
    }
}
