package com.resto.orders;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRep extends JpaRepository<order, Long> {
	
	List<order> findByOrderAtBetween(LocalDateTime start, LocalDateTime end);

}
