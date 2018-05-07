package com.gys.sm.fun.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gys.sm.fun.demo.bean.GysBean;
import com.gys.sm.fun.demo.dao.IGysDemoDao;

@Service
public class GysServiceImpl{
	
	@Autowired
	private IGysDemoDao dao;
	public List<GysBean> getGysList(){
		return dao.getGysList();
	}
}
