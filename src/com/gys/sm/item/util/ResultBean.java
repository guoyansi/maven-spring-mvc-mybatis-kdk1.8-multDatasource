package com.gys.sm.item.util;

import com.gys.sm.item.constant.ResultCont;

public class ResultBean {
	private Integer status;
	private String msg;
	private Object data;
	public ResultBean(){}
	public ResultBean(Integer status){
		this.status=status;
	}
	public ResultBean(Integer status,String msg){
		this.status=status;
		this.msg=msg;
	}
	public ResultBean(Integer status,String msg,Object data){
		this.status=status;
		this.msg=msg;
		this.data=data;
	}
	public static ResultBean success(String msg){
		return new ResultBean(ResultCont.success,msg);
	}
	public static ResultBean success(String msg,Object data){
		return new ResultBean(ResultCont.success,msg,data);
	}
	public static ResultBean error(String msg){
		return new ResultBean(ResultCont.error,msg);
	}
	public static ResultBean error(String msg,Object data){
		return new ResultBean(ResultCont.error,msg,data);
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
