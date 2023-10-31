package com.kkj.subscribe.dto;

public class UpdateSubscribeDto {
	private String id;
	private String subscribeEnd;
	
	
	public UpdateSubscribeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateSubscribeDto(String id, String subscribeEnd) {
		super();
		this.id = id;
		this.subscribeEnd = subscribeEnd;
	}
	@Override
	public String toString() {
		return "UpdateSubscribeDto [id=" + id + ", subscribeEnd=" + subscribeEnd + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubscribeEnd() {
		return subscribeEnd;
	}
	public void setSubscribeEnd(String subscribeEnd) {
		this.subscribeEnd = subscribeEnd;
	}
	
}
