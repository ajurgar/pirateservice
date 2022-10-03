package com.example.codeclan.pirateservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "raids")
public class Raid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String location;

    @Column(name = "bootay")
    private int  bootay;

    @JsonIgnoreProperties({"raids"})
    @ManyToMany
    @JoinTable(
            name = "pirates_raids",
            joinColumns = {@JoinColumn(
                    name = "raid_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "pirate_id",
                    nullable = false,
                    updatable = false
            )}

    )
    private List<Pirate> pirates;

    public Raid(String location, int bootay) {
        this.location = location;
        this.bootay = bootay;
        this.pirates = new ArrayList<>();
    }

    public Raid(){


    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBootay() {
        return bootay;
    }

    public void setBootay(int bootay) {
        this.bootay = bootay;
    }

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addPirate(Pirate pirate){
        this.pirates.add(pirate);
    }
}