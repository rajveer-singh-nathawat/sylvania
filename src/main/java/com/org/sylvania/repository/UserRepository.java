package com.org.sylvania.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.sylvania.dto.SignupDTO;
import com.org.sylvania.dto.TokenInfo;
import com.org.sylvania.dto.UserListDto;
import com.org.sylvania.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Object findByEmail(String email);

  Optional<UserEntity> findByUserNameOrEmailAndPassword(String userNameOrEmail,
      String userNameOrEmail2, String password);


  @Query(value = "SELECT new com.org.sylvania.dto.SignupDTO"
      + "(u.userName,u.password,u.active,ure.roles,u.userId)" + " FROM UserEntity u "
      + " JOIN UserRoleMappingEntity urm on urm.userEntity.userId=u.userId"
      + " JOIN UserRolesEntity ure on ure.userRolesId = urm.userRolesEntity.userRolesId"
      + " WHERE u.userName =:userNameOrEmail OR u.email =:userNameOrEmail")
  Optional<SignupDTO> findbySignupInfo(@Param("userNameOrEmail") String userNameOrEmail);

  @Query(value = "SELECT new com.org.sylvania.dto.TokenInfo"
      + "(u.userId,u.userName,ud.fullName,ure.roles)" + " FROM UserEntity u "
      + " JOIN UserRoleMappingEntity urm on urm.userEntity.userId=u.userId"
      + " JOIN UserRolesEntity ure on ure.userRolesId = urm.userRolesEntity.userRolesId"
      + " JOIN UserDataEntity ud on ud.userEntity.userId = u.userId"
      + " WHERE u.userName =:username")
  TokenInfo findTokenInfo(@Param("username") String username);

  @Query(value = "SELECT new com.org.sylvania.dto.UserListDto"
      + "(u.userId,ud.fullName,ud.designation)" + " FROM UserEntity u "
      + " JOIN UserDataEntity ud on ud.userEntity.userId = u.userId"
      + " WHERE ud.livingStatus =:livingStatus")
  List<UserListDto> findAllUserList(@Param("livingStatus") String livingStatus);
}


