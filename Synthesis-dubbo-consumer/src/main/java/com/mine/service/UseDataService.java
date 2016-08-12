package com.mine.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mine.facde.DataService;

@Service
public class UseDataService {

	@Resource
	private DataService dataService;
	
	public void add (String user){
		System.out.println(dataService.add()+"   "+user);
	}
}
