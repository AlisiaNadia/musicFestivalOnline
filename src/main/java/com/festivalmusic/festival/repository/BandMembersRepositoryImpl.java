package com.festivalmusic.festival.repository;

import com.festivalmusic.festival.model.Band;
import com.festivalmusic.festival.model.BandMembers;
import com.festivalmusic.festival.model.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BandMembersRepositoryImpl implements BandMembersRepository{

    @Autowired
    EntityManager entityManager;


    @Override
    @Transactional
    public BandMembers save(BandMembers bandMember) {
        entityManager.persist(bandMember);
        return bandMember;
    }
}
