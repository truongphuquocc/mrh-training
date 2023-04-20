package com.pilot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pilot.dao.repository.UserRepository;
import com.pilot.entity.UserInfoEntity;
import com.pilot.model.ResponseDataModel;
import com.pilot.service.UserInfoService;
/**
 *
 * 
 * @author PhuQuoc
 * @since 19 thg 4, 2023
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
  
    @Autowired
    UserRepository userRepository;
  
	@Override
	public UserInfoEntity login(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
}