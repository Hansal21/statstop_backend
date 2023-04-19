package com.statstop.statstop.repository;

import com.statstop.statstop.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
    Player findByPlayerId(Integer playerId);
}
