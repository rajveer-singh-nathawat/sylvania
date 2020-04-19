package com.org.sylvania.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthorityRepository, Long>{

	Object findByEmail(String email);

}
