package com.novel.cms.service.impl;

import org.springframework.beans.factory.annotation.Value;
/**
 * @author sun
 * */
import org.springframework.stereotype.Service;

import com.novel.cms.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {

	@Value("${username}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	@Override
	public boolean login(String id, String password) {
		if(username.equals(id.trim()) && password.equals(password.trim())){
			return true;
		}else{
			return false;
		}
	}

}
