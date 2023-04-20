package com.pilot.service;

import com.pilot.entity.UserInfoEntity;

/**
 *
 * 
 * @author PhuQuoc
 * @since 19 thg 4, 2023
 */
public interface UserInfoService {

  //ResponseDataModel login(String username, String password);
  UserInfoEntity login(String username, String password);
}