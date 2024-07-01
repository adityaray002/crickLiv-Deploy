package com.crick.apis.Repositories;

import com.crick.apis.Entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepo extends JpaRepository<Match,Long> {

    Optional<Match> findByTeamHeading(String teamHeading);

}
