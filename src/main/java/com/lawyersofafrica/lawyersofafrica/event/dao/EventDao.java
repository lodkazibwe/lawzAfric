package com.lawyersofafrica.lawyersofafrica.event.dao;

import com.lawyersofafrica.lawyersofafrica.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDao extends JpaRepository<Event, Integer> {

    boolean existsByEventKey(String eventKey);

}
