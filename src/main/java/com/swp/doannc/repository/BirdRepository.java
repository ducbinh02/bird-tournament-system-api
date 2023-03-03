package com.swp.doannc.repository;

import com.swp.doannc.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BirdRepository extends JpaRepository<Bird, Long> {

    @Query(value = "select b.id, b.name from BirdRound br join Bird b on br.birdId = b.id where br.roundId = ?1")
    List<Bird> findByRoundId(Long roundId);
}
