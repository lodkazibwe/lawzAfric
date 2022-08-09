package com.lawyersofafrica.lawyersofafrica.profile.service.impl;

import com.lawyersofafrica.lawyersofafrica.event.model.Event;
import com.lawyersofafrica.lawyersofafrica.event.service.EventService;
import com.lawyersofafrica.lawyersofafrica.sysUser.service.UserService;
import com.lawyersofafrica.lawyersofafrica.ticket.model.Ticket;
import com.lawyersofafrica.lawyersofafrica.ticket.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class StartUp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired TicketService ticketService;
    @Autowired EventService eventService;
    @Autowired UserService userService;

    private final Logger logger = LoggerFactory.getLogger(StartUp.class);
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        logger.info("system Started...");
        logger.info("checking event...");
        boolean bool =eventService.existsByKey("PALUACC");
        if(bool){
            
            logger.info("system already initiated...");
        }else{
            /*SysUser sysUser =new SysUser();
            sysUser.setDateAdded(new Date());
            sysUser.setEmail("secretariat@lawyersofafrica.org");
            sysUser.setUserName("Admin");
            sysUser.setUserStatus("Active");
            sysUser.setAddedBy("sys");
            sysUser.setContact("255685078794");
            sysUser.setDateUpdated(new Date());
            sysUser.setUpdatedBy("sys");
            userService.addAdmin(sysUser);*/

            logger.info("adding event...");
            Event event =new Event();
            event.setStartDate(new Date());
            event.setDescription("Pan African Lawyers Union (PALU)\n" +
                    "20th Anniversary conference and celebration\n" +
                    "Addis Ababa, Ethiopia\n" +
                    "September 9th, 2022");
            event.setEndDate(new Date());
            event.setEventStatus("VERIFIED");
            event.setTitle("PALU");
            event.setEventKey("PALUACC");
            event.setTheme("The Africa We Want from Aspirations to Reality");
            Event newEvent =eventService.addEvent(event);

            //Event newEvent =eventService.getEvent("PALUACC");
            logger.info("adding tickets...");
            List<Ticket> ticketList =new ArrayList<>();
            ticketList.add(new Ticket(111, "PALU", "member in good standing", "N", 2000,0, 10, "V", 100,50,0, newEvent));
            ticketList.add(new Ticket(121, "FOUNDING", "Member", "N", 2000,0, 1000, "V", 0,0,0, newEvent));
            ticketList.add(new Ticket(131, "CURRENT", "Special Endowment Member Or Life Member", "N", 2000,0, 2000, "V", 0,0,0, newEvent));
            ticketList.add(new Ticket(141, "NEW SPECIAL", "PALU Endowment Member", "N", 2000,0, 3000, "V", 0,0,0, newEvent));
            ticketList.add(new Ticket(151, "NEW LIFETIME", "PALU Member", "N", 2000,0, 4000, "V", 0,0,0, newEvent));
            ticketList.add(new Ticket(161, "NON-MEMBER", "of PALU", "N", 2000,0, 5000, "V", 100,50,50, newEvent));
            ticketService.addTicket(ticketList);
            logger.info("tickets added...");
        }
        logger.info("system ready...");
    }
}
