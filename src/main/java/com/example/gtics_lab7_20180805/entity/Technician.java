package com.example.gtics_lab7_20180805.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "technicians")
@Getter
@Setter
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID")
    private int id;
    @Size(max = 100, min = 3)
    private String FirstName;
    @Size(max = 100, min = 3)
    private String LastName;

    @Size(max = 9, min = 9)
    private String Phone;
    @Column(nullable = false)
    @Positive
    private Integer Email;

}
