package com.swp.doannc.repository;

import com.swp.doannc.model.Tournament;
import com.swp.doannc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    
}
