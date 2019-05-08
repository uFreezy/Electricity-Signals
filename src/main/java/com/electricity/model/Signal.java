package com.electricity.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sigg")
public class Signal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String description;

    private boolean isCompleted;

    private Date dateOnCompletion;

    @ManyToOne
    @JoinColumn(name = "sigg_id", nullable = false)
    private User owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Date getDateOnCompletion() {
        return dateOnCompletion;
    }

    public void setDateOnCompletion(Date dateOnCompletion) {
        this.dateOnCompletion = dateOnCompletion;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
