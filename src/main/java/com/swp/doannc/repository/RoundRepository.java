package com.swp.doannc.repository;

import com.swp.doannc.model.Round;
import com.swp.doannc.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoundRepository extends JpaRepository<Round, Long> {

    @Query(value = "SELECT id FROM Round WHERE tournamentId = ?1 and capacity = (select MAX(capacity) from Round where tournamentId = ?1)")
    Long findRoundByTournamentIdAndCapacity(Long id);

    @Query(value = "SELECT id, name FROM Round WHERE tournamentId = ?1 ")
    List<Round> findAllRoundOfTournament(long id);
}
