package com.ibm.poc.db.repositories;

import java.util.Optional;

import com.ibm.poc.db.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByLoginId(String loginId);
	Optional<User> findByLoginIdAndPassword(String loginId, String password);
}
