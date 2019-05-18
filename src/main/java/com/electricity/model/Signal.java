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

    private Date dateOnSubmition;

    private boolean isCompleted;

    private Date dateOnCompletion;

    @ManyToOne
    @JoinColumn(name = "sigg_id", nullable = false)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "slv_id", nullable = true)
    private User solver;

    public Signal() {
    }

    public Signal(String address, String description, Date dateOnSubmition, boolean isCompleted, Date dateOnCompletion, User owner) {
        this.address = address;
        this.description = description;
        this.dateOnSubmition = dateOnSubmition;
        this.isCompleted = isCompleted;
        this.dateOnCompletion = dateOnCompletion;
        this.owner = owner;
    }

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

    public Date getDateOnSubmition() {
        return dateOnSubmition;
    }

    public void setDateOnSubmition(Date dateOnSubmition) {
        this.dateOnSubmition = dateOnSubmition;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
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

    public User getSolver() {
        return solver;
    }

    public void setSolver(User solver) {
        this.solver = solver;
    }
}
