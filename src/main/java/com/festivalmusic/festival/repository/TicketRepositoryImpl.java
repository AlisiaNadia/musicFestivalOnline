package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Ticket;
import com.festivalmusic.festival.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public Ticket getTicketId(Long ticketInfoId) {

        Ticket ticket = (Ticket) entityManager.createQuery("select t from Ticket t " +
                "where t.ticketInfoId = '"+ ticketInfoId +"' and t.ticketId not in( select a.ticketId from AudienceUser a)").
                getResultList().stream().findFirst().orElse(null);
        return ticket;
    }

    @Override
    @Transactional
    public Long updateTicketNumber(Long id) {
        Query querry = entityManager.createQuery("update TicketInfo set amountLeft= amountLeft - 1 where ticketInfoId = :id");
        querry.setParameter("id", id);
        querry.executeUpdate();
        return id;
    }

    @Override
    public List<Ticket> getAllTicketsForUser(User userId) {

        List<Ticket> tickets = entityManager.createQuery("select t from Ticket t where " +
                "t.audienceUser.userId.userId = '" + userId.getUserId() + "'").getResultList();

        return tickets;
    }

    @Override
    @Transactional
    public Ticket save(Ticket ticket1) {

        entityManager.persist(ticket1);
        return ticket1;
    }
}
