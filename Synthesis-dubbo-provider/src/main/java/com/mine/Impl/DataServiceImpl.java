package com.mine.Impl;

import org.springframework.stereotype.Service;

import com.mine.facde.DataService;

@Service
public class DataServiceImpl implements DataService {

	public String add() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis()+":   add";
	}

	public String get() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis()+":   get";
	}

	public String delete() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis()+":   delete";
	}

	public String update() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis()+":   update";
	}

}
