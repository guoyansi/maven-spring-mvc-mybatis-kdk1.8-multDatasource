package com.gys.sm.item.ex;

import com.gys.sm.item.bean.BaseResult;

public class MyException extends RuntimeException{
	private BaseResult result;
	
	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
	}
	public MyException(BaseResult result){
		this.result=result;
	}

	public BaseResult getResult() {
		return result;
	}
	
}
