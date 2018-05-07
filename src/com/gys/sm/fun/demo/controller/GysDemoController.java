package com.gys.sm.fun.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gys.sm.fun.demo.bean.GysBean;
import com.gys.sm.fun.demo.service.impl.GysServiceImpl;
import com.gys.sm.item.util.DbcontextHolder;

@Controller
@RequestMapping("/gysDemo")
public class GysDemoController {
	/**
	 * 日志打印
	 */
	private static Logger logger = Logger.getLogger(GysDemoController.class);

	@Autowired
	private GysServiceImpl service;

	@ResponseBody
	@RequestMapping("/page")
	public List<GysBean> goPage() {
		DbcontextHolder.setDbType("dataSource1");//设置后 就OK
		List<GysBean> list = service.getGysList();
		return list;
	}
	@ResponseBody
	@RequestMapping("/page2")
	public List<GysBean> goPage2() {
		DbcontextHolder.setDbType("dataSource2");//设置后 就OK
		List<GysBean> list = service.getGysList();
		return list;
	}
	@ResponseBody
	@RequestMapping("/page3")
	public Map<String, Object> goPage3() {
		Map<String, Object> map=new HashMap<String, Object>();
		DbcontextHolder.setDbType("ds1");//设置后 就OK
		List<GysBean> list = service.getGysList();
		map.put("list1", list);
		DbcontextHolder.setDbType("ds2");//设置后 就OK
		list = service.getGysList();
		map.put("list2", list);
		return map;
	}
	
}
