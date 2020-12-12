package com.cipek.ctdt.repository;

import org.springframework.stereotype.Repository;

import com.cipek.ctdt.model.player.Player;

@Repository
public interface PlayerRepository extends BaseRepository<Player, Long> {
	
	

}
