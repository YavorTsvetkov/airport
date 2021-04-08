package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.AirportEntity;
import com.pluralsight.hibernatefundamentals.airport.PassengerEntity;
import com.pluralsight.hibernatefundamentals.airport.TicketEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m02.ex01");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        TicketEntity ticket1 = new TicketEntity("Ticket_number_1");
        TicketEntity ticket2 = new TicketEntity("Ticket_number_2");
        TicketEntity ticket3 = new TicketEntity("Ticket_number_3");
        TicketEntity ticket4 = new TicketEntity("Ticket_number_4");

        PassengerEntity john = new PassengerEntity("John");
        PassengerEntity frank = new PassengerEntity("Frank");

        john.addTicket(ticket1);
        john.addTicket(ticket3);
        frank.addTicket(ticket2);
        frank.addTicket(ticket4);

        AirportEntity sofiaAirport = new AirportEntity("Sofia Airport");
        sofiaAirport.addPassenger(john);
        sofiaAirport.addPassenger(frank);

        em.persist(sofiaAirport);
        em.persist(john);
        em.persist(frank);
        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);
        em.persist(ticket4);

        em.getTransaction().commit();
        emf.close();
    }
}
