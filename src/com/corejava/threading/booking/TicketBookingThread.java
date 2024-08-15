package com.corejava.threading.booking;

public class TicketBookingThread extends Thread {
    private final TicketCounter ticketCounter;
    private final String passengerName;
    private final int noOfSeatsToBook;

    public TicketBookingThread(TicketCounter ticketCounter, String passengerName, int noOfSeatsToBook) {
        this.ticketCounter = ticketCounter;
        this.passengerName = passengerName;
        this.noOfSeatsToBook = noOfSeatsToBook;
    }

    public void run() {
        ticketCounter.bookTicket(passengerName, noOfSeatsToBook);
    }
}
