package com.sctp.module3project2.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// Edited by Afif
@Entity
@Table(name = "vessel")
public class Vessel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @JsonManagedReference
    @OneToMany(mappedBy = "vessel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShippingRoute> shippingRoutes = new ArrayList<>();

    public List<ShippingRoute> getShippingRoutes() {
        return shippingRoutes;
    }

    public void setShippingRoutes(List<ShippingRoute> shippingRoutes) {
        this.shippingRoutes = shippingRoutes;
    }

    public Vessel() {
    }

    public Vessel(Long id, String name, String type, List<ShippingRoute> shippingRoutes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.shippingRoutes = shippingRoutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
