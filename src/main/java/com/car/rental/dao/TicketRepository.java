package com.car.rental.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.rental.entity.TicketDetails;
import com.car.rental.entity.User;

public interface TicketRepository extends JpaRepository<TicketDetails, Integer> {

	List<TicketDetails> findByUser(User user);
}
