package com.lawyersofafrica.lawyersofafrica.event.service;

import com.lawyersofafrica.lawyersofafrica.event.model.Event;

public interface EventService {
    Event addEvent(Event event);
    boolean existsByKey(String eventKey);
    Event getEvent(String eventKey);

}
