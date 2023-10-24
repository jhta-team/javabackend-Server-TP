package com.kkj.member.dto;

public class ModalState {
	private String msg;
	private String state;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ModalState(String state,String msg) {
		super();
		this.msg = msg;
		this.state = state;
	}
	
}
