package com.corejava.threading.booking;

public class TicketCounter {
    private int availableSeats;

    public TicketCounter(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void bookTicket(String pName, int numberOfSeats) {
        if (numberOfSeats <= 0) {
            System.out.println("Invalid number of seats requested.");
            return;
        }

        if (availableSeats >= numberOfSeats) {
            availableSeats -= numberOfSeats;
            System.out.println("Booking successful! " + numberOfSeats + " seat" + (numberOfSeats == 1 ? "" : "s") + " reserved for " + pName + ".");
        } else {
            System.out.println("Booking failed for " + pName + ". Only " + availableSeats + " seat" + (availableSeats == 1 ? "" : "s") + " available, but you requested " + numberOfSeats + ".");
        }
    }
}
