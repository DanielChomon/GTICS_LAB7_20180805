package com.example.gtics_lab7_20180805.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "sites")
@Getter
@Setter
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteID")
    private int id;
    @Column(nullable = false)
    @Size(max = 40,message = "Solo se soportan 40 caractéres")
    @NotBlank
    private String sitename;
    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location location;

    private Date InstallationDate;
    private String Latitude;
    private String Longitude;
}
