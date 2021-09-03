package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.TicketInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TicketInfoRepositoryImpl implements TicketInfoRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<TicketInfo> getAll() {

        List<TicketInfo> tickets = entityManager.createQuery
                ("select t from TicketInfo t where t.amountLeft > 0").getResultList();

       return tickets;
    }
}
