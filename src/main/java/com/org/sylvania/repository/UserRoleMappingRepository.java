package com.org.sylvania.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.sylvania.entity.UserRoleMappingEntity;

@Repository
public interface UserRoleMappingRepository extends JpaRepository<UserRoleMappingEntity, Long>{

}
