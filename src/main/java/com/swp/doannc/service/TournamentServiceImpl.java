package com.swp.doannc.service;

import com.swp.doannc.dto.*;
import com.swp.doannc.mapper.RoundMapper;
import com.swp.doannc.mapper.TournamentMapper;
import com.swp.doannc.model.*;
import com.swp.doannc.repository.*;
import com.swp.doannc.util.GeneralMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements TournamentService {

    private static final String CREATE_TOURNAMENT_SUCCESSFUL = "create_tournament_successful";
    private static final String ADD_BIRD_POINT_SUCCESSFUL = "add_bird_point_successful";

    private static final String JOIN_TOURNAMENT_SUCCESSFUL = "join_tournament_successful";
    private final TournamentRepository tournamentRepository;
    private final ScoreRepository scoreRepository;
    private final BirdRoundRepository birdRoundRepository;
    private final RoundRepository roundRepository;
    private final BirdRepository birdRepository;
    private final GeneralMessageAccessor generalMessageAccessor;

    @Override
    public CreateTournamentResponse createTournament(CreateTournamentRequest createTournamentRequest) {
        Tournament tournament = TournamentMapper.INSTANCE.convertToTournament(createTournamentRequest);
        tournament.setRuleId(createTournamentRequest.getRuleId());

        tournamentRepository.save(tournament);

        final String message = generalMessageAccessor.getMessage(null, CREATE_TOURNAMENT_SUCCESSFUL, createTournamentRequest.getName());

        return new CreateTournamentResponse(message);
    }
    @Override
    public AddBirdPointResponse addBirdPoint(AddBirdPointRequest addBirdPointRequest){

        Score score = RoundMapper.INSTANCE.convertToScore(addBirdPointRequest);
        scoreRepository.save(score);

        // TODO:
        BirdRound birdRound = new BirdRound();
        Long bId = birdRoundRepository.getReferenceById(addBirdPointRequest.getRefId()).getBirdId();
        final String bName = birdRepository.getReferenceById(bId).getName();

        final String message = generalMessageAccessor.getMessage(null, ADD_BIRD_POINT_SUCCESSFUL, bName);

        return new AddBirdPointResponse(message);
    }



    @Override
    public JoinTournamentResponse joinTournament(JoinTournamentRequest joinTournamentRequest) {
        BirdRound birdRound = new BirdRound();
        birdRound.setBirdId(joinTournamentRequest.getBirdId());
        birdRound.setRoundId(roundRepository.findRoundByTournamentIdAndCapacity(joinTournamentRequest.getTournamentId()));

        birdRoundRepository.save(birdRound);

        final Bird bird = birdRepository.getReferenceById(joinTournamentRequest.getBirdId());
        final String bName = bird.getName();
        final String message = generalMessageAccessor.getMessage(null, JOIN_TOURNAMENT_SUCCESSFUL, bName);

        return new JoinTournamentResponse(message);
    }

    @Override
    public List<Tournament> getAllTournament(){
        return tournamentRepository.findAll();
    }


    @Override
    public  List<Round> getAllRoundOfTournament(Long id){
        return roundRepository.findAllRoundOfTournament(id);
    }

    @Override
    public Round getRoundOfTournament(Long id){
        return roundRepository.getReferenceById(id);
    }

    @Override
    public List<Bird> getBirdOfRound(Long id){
        return birdRepository.findByRoundId(id);
    }

}
