package com.pluralsight.hibernatefundamentals.airport;

import javax.persistence.*;

@Entity
@Table(name = "TICKETS")
public class TicketEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "NUMBER")
    private String number;

    @ManyToOne
    @JoinColumn(name = "PASSENGER_ID")
    private PassengerEntity passenger;

    public TicketEntity() {
    }

    public TicketEntity(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PassengerEntity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEntity passenger) {
        this.passenger = passenger;
    }
}
