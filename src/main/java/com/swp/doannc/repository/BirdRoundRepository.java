package com.swp.doannc.repository;

import com.swp.doannc.model.BirdRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BirdRoundRepository extends JpaRepository<BirdRound, Long> {

    @Query(value = "select id from BirdRound where roundId = ?1")
    Long findByRoundId(Long roundId);
}
