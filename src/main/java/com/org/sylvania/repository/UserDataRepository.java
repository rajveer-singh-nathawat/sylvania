package com.org.sylvania.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.sylvania.entity.UserDataEntity;

@Repository
public interface UserDataRepository extends JpaRepository<UserDataEntity, Long>{

	Optional<UserDataEntity> findByUserNameOrEmailAndPassword(String userNameOrEmail, String userNameOrEmail2, String password);

}
