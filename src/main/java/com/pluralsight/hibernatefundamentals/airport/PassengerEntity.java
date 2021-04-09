package com.pluralsight.hibernatefundamentals.airport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PASSENGERS")
public class PassengerEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "AIRPORT_ID")
    private AirportEntity airport;

    @OneToMany(mappedBy = "passenger")
    private List<TicketEntity> tickets;

    public PassengerEntity() {
    }

    public PassengerEntity(String name) {
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    public void addTicket(TicketEntity ticket) {
        this.tickets.add(ticket);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirportEntity getAirport() {
        return airport;
    }

    public void setAirport(AirportEntity airport) {
        this.airport = airport;
    }

    public List<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketEntity> tickets) {
        this.tickets = tickets;
    }
}
