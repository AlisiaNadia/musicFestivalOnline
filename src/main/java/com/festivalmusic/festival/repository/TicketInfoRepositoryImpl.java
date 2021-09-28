package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.TicketInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public class TicketInfoRepositoryImpl implements TicketInfoRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<TicketInfo> getAll() {

//        List<TicketInfo> tickets = entityManager.createQuery
//                ("select t from TicketInfo t where t.amountLeft > 0").getResultList();
        List<TicketInfo> tickets = entityManager.createQuery
                ("select t from TicketInfo t").getResultList();

       return tickets;
    }

    @Override
    public Map<String, Integer> getTheMostLikelyTicketToBeSoldOut() {

        List<Object[]> tickets = entityManager.createQuery("select type, (SUM(amountLeft)*100)/SUM(amount) as amountPercentage FROM TicketInfo GROUP BY type").getResultList();

        Map<String, Integer> ticketsWithSellPercentage = new HashMap<String, Integer>();
        for(Object[] ob : tickets) {
            ticketsWithSellPercentage.put((String)ob[0],Math.toIntExact((Long) ob[1]));
        }

        return ticketsWithSellPercentage;
    }

    @Override
    public Map<Long, Integer> getTheMostLikelyStageToBeSoldOut() {
        List<Object[]> stagesList = entityManager.createQuery("select stageId.stageId, (SUM(amountLeft)*100)/SUM(amount) as amountPercentage FROM TicketInfo GROUP BY stageId.stageId").getResultList();

        Map<Long, Integer> stages = new HashMap<Long, Integer>();
        for(Object[] ob : stagesList) {
            stages.put((Long)ob[0],Math.toIntExact((Long) ob[1]));
           }

        return stages;
    }

    @Override
    public Map<String, Integer> getTheMostPopularGenre() {
        List<Object[]> genresList = entityManager.createQuery("select stageId.genre, (SUM(amountLeft)*100)/SUM(amount) as amountPercentage FROM TicketInfo GROUP BY stageId.genre").getResultList();

        Map<String, Integer> genres = new HashMap<String, Integer>();
        for(Object[] ob : genresList) {
            genres.put((String)ob[0],Math.toIntExact((Long) ob[1]));
        }

        return genres;
    }

    @Override
    @Transactional
    public TicketInfo save(TicketInfo ticket) {

        entityManager.persist(ticket);
        return ticket;
    }
}
