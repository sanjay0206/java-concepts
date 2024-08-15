package com.corejava.threading.booking;

public class CustomerClient {
    public static void main(String[] args) {
        int availableSeats = 4;
        TicketCounter ticketCounter = new TicketCounter(availableSeats);

        TicketBookingThread task1 = new TicketBookingThread(ticketCounter, "John", 1);
        TicketBookingThread task2 = new TicketBookingThread(ticketCounter, "Martin", 4);

        // When two customer (threads) are trying to book ticket a same time
        task1.start();
        task2.start();
    }
}

/*
Booking successful! 1 seat reserved for John.
Booking failed for Martin. Only 3 seats available, but you requested 4.

Process finished with exit code 0
*/