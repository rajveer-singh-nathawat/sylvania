package com.org.sylvania.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.sylvania.entity.UserDataEntity;

@Repository
public interface UserDataRepository extends JpaRepository<UserDataEntity, Long> {
  @Query(value = "SELECT ude FROM UserDataEntity ude WHERE ude.userEntity.userId =:userId")
  Optional<UserDataEntity> findByUserId(@Param("userId") Long userId);
}
