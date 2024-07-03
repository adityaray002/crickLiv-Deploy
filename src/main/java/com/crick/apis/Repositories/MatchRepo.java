package com.crick.apis.Repositories;

import com.crick.apis.Entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepo extends JpaRepository<Match,Long> {

    Optional<Match> findByMatchId(Long matchId);

    @Query("SELECT m FROM Match m WHERE m.matchLink = :matchLink")
    Optional<List<Match>> findByMatchLink(@Param("matchLink") String matchLink);

}
