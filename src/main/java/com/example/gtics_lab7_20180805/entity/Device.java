package com.example.gtics_lab7_20180805.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "devices")
@Getter
@Setter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeviceID")
    private int id;
    private String DeviceName;
    private String DeviceType;
    private String Model;
    private String SerialNumber;
    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site site;
}
