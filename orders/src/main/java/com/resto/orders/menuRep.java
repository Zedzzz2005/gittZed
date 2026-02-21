package com.resto.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface menuRep extends JpaRepository<menu, Long>{

}
