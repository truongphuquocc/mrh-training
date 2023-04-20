/**
 * 
 */
package com.pilot.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.pilot.entity.UserInfoEntity;

/**
 * @author PhuQuoc
 * @since 19 thg 4, 2023
 */
public interface UserRepository
    extends JpaRepository<UserInfoEntity, Long>, JpaSpecificationExecutor<UserInfoEntity> {
  UserInfoEntity findByUsernameAndPassword(String userName, String password);
}
