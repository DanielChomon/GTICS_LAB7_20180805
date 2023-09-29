package com.example.gtics_lab7_20180805.repository;

import com.example.gtics_lab7_20180805.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    }
