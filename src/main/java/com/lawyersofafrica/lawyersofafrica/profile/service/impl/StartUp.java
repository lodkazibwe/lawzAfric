package com.lawyersofafrica.lawyersofafrica.profile.service.impl;

import com.lawyersofafrica.lawyersofafrica.event.model.Event;
import com.lawyersofafrica.lawyersofafrica.event.service.EventService;
import com.lawyersofafrica.lawyersofafrica.sysUser.model.SysUser;
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
        boolean bool =eventService.existsByKey("PALUA");
        if(!bool){

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

            /*logger.info("adding event...");
            Event event =new Event();
            event.setStartDate(new Date());
            event.setDescription("2022 Annual Conference And Triennial General Assembly");
            event.setEndDate(new Date());
            event.setEventStatus("VERIFIED");
            event.setTitle("PALU");
            event.setEventKey("PALUA");
            event.setTheme("The Africa We Want from Aspirations to Reality");
            Event newEvent =eventService.addEvent(event);*/
            Event newEvent =eventService.getEvent("PALUA");
            logger.info("adding tickets...");
            List<Ticket> ticketList =new ArrayList<>();
            /*ticketList.add(new Ticket(11, "PALU", " Member in Good Standing", "N", 2000,0, 10, "V", 300, newEvent));
            ticketList.add(new Ticket(12, "MEMBER", "of the Host Bar Tanganyika Law Society", "N", 2000,0, 1000, "V", 250, newEvent));
            ticketList.add(new Ticket(13, "EXISTING", "Special Endowment Members And Life Member", "N", 2000,0, 2000, "V", 200, newEvent));
            ticketList.add(new Ticket(14, "SPECIAL", "Endowment Member", "N", 2000,0, 3000, "V", 10000, newEvent));
            ticketList.add(new Ticket(15, "LIFETIME", "Membership and Admission to AGM & TGA", "N", 2000,0, 4000, "V", 1000, newEvent));
            ticketList.add(new Ticket(16, "NON-MEMBER", "of PALU", "N", 2000,0, 5000, "V", 450, newEvent));
            ticketList.add(new Ticket(17, "VIRTUAL", "Participating", "N", 2000,0, 6000, "V", 100, newEvent));*/
            ticketList.add(new Ticket(77777, "YOUNG LAWYERS", "0-5 years of practice", "N", 2000,0, 7000, "V", 150, newEvent));
            ticketService.addTicket(ticketList);
            logger.info("tickets added...");
        }
        logger.info("system ready...");
    }
}
