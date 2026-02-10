package com.covea.simplecrudapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.covea.simplecrudapi.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	Optional<User> findByApikey(String apikey);
}
