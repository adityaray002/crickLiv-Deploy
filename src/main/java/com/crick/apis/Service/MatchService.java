package com.crick.apis.Service;

import com.crick.apis.Entities.Match;

import java.util.List;

public interface MatchService {
    //get all matches
    List<Match> getAllMatches();
    //get  live matches
    List<Match> getLiveMatches();
    //get cwc2023 point table
    List<List<String>> getPointTable();

}
