package com.cipek.ctdt.repository;

import org.springframework.stereotype.Repository;

import com.cipek.ctdt.model.player.Player;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	

}
