package com.corejava.threading.busreservation;

import java.util.Scanner;

public class CustomerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total no. of available seats: ");
        int availableSeats = sc.nextInt();
        TicketCounter ticketCounter = new TicketCounter(availableSeats);

        TicketBookingThread t1 = new TicketBookingThread(ticketCounter, "John", 2);
        TicketBookingThread t2 = new TicketBookingThread(ticketCounter, "Martin", 3);

        // When two customer (threads) are trying to book ticket a same time
        t1.start();
        t2.start();
    }
}

/*
Enter the total no. of available seats: 4
Hi John! 2 seats are booked successfully..
Hi Martin! Could not book 3 seats because 2 seats are available right now.
*/