package com.q.controller;

import com.q.model.TbUser;

//ҳ��Э����ת
public class PageAction {
	
	private long id;
	private String name;
	private TbUser user;
	private Integer balance;
	
	//Э����ת���û��޸Ľ���
	public String toAlertUser(){
		user = new TbUser();
		user.setId(id);
		user.setName(name);
		user.setBalance(balance);
		return "success";
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TbUser getUser() {
		return user;
	}

	public void setUser(TbUser user) {
		this.user = user;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
}
