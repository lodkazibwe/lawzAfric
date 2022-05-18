package com.lawyersofafrica.lawyersofafrica.event.service.impl;

import com.lawyersofafrica.lawyersofafrica.event.dao.EventDao;
import com.lawyersofafrica.lawyersofafrica.event.model.Event;
import com.lawyersofafrica.lawyersofafrica.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    @Autowired EventDao eventDao;
    @Override
    public Event addEvent(Event event) {
        return eventDao.save(event);
    }

    @Override
    public boolean existsByKey(String eventKey) {
        return eventDao.existsByEventKey(eventKey);
    }

    @Override
    public Event getEvent(String eventKey) {
        return null;
    }
}
