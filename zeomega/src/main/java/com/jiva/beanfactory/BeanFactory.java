package com.jiva.beanfactory;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.auth.UsernamePasswordCredentials;

import com.jiva.dao.LoginData;
import com.jiva.dao.MemberData;

public class BeanFactory implements TestData {

	public void loginCredentials(LoginData data) {

		data.setUsername("vjayavarapu");
		data.setPassword("Password1!");
	}

	public void groupName(MemberData data) {

		data.setGroup("Blue Advantage 001");

	}

}
