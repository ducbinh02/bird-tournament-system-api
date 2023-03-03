package com.swp.doannc.controller;

import com.swp.doannc.dto.*;
import com.swp.doannc.model.Bird;
import com.swp.doannc.model.Round;
import com.swp.doannc.model.Tournament;
import com.swp.doannc.service.TournamentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/tournament")
public class TournamentController {

    final TournamentService tournamentService;

    @PostMapping
    ResponseEntity<CreateTournamentResponse> createTournament(@Valid @RequestBody CreateTournamentRequest createTournamentRequest) {
        return ResponseEntity.ok(tournamentService.createTournament(createTournamentRequest));
    }

    @GetMapping("/all")
    ResponseEntity<List<Tournament>> getAllTournament(){
        return ResponseEntity.ok(tournamentService.getAllTournament());
    }

    @GetMapping("/round/all")
    ResponseEntity<List<Round>> getAllRoundOfTournament(@Valid @RequestParam Long id){
        return ResponseEntity.ok(tournamentService.getAllRoundOfTournament(id));
    }

    @GetMapping("/round")
    ResponseEntity<Round> getRoundOfTournament(@Valid @RequestParam Long id){
        return ResponseEntity.ok(tournamentService.getRoundOfTournament(id));
    }

    @GetMapping("/round/bird/all")
    ResponseEntity<List<Bird>> getBirdOfRound(@Valid @RequestParam Long id){
        return ResponseEntity.ok(tournamentService.getBirdOfRound(id));
    }

    @PutMapping("/round/bird/point")
    ResponseEntity<AddBirdPointResponse> getBirdOfRound(@Valid @RequestBody AddBirdPointRequest addBirdPointRequest){
        return ResponseEntity.ok(tournamentService.addBirdPoint(addBirdPointRequest));
    }

    @PutMapping("/register")
    ResponseEntity<JoinTournamentResponse> joinTournament(@Valid @RequestBody JoinTournamentRequest joinTournamentRequest){
        return ResponseEntity.ok(tournamentService.joinTournament(joinTournamentRequest));
    }

}
