package com.bookingSystem.springdb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface availRepo extends JpaRepository<avaiEntity, Long> {

}
