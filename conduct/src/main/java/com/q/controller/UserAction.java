package com.q.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.management.Query;

import com.opensymphony.xwork2.ModelDriven;
import com.q.dao.UserDao;
import com.q.model.TbUser;
import com.q.service.UserService;

public class UserAction{
	
	private UserService userService;
	
	private long id;
	private String name;
	private String password;
	private String repassword;
	private String email;
	private String sex;
	private Integer balance;
	
	private int page;
	private int total;
	
	List<TbUser> userList = null;
	
	//用户注册方法
	public String regiest(){
		TbUser tu = new TbUser();
		tu.setName(name);
		tu.setPassword(password);
		tu.setEmail(email);
		tu.setSex(sex);
		tu.setBalance(0);
		tu.setStatues(1);
		if(name!=null && password.equals(repassword) && password!=null){
			userService.regiest(tu);
		}else{
			return "fail";
		}
		return "success";
	}
	
	//查询所有用户
	public String getAll(){
		page = 1;
		userList = userService.queryAllUser(page);
		total = userService.getTotal();
		return "success";
	}
	
	//上一页
	public String previous(){
		if(page<=1){
			return "fail";
		}else if(page>1){
			page-=1;
			userList = userService.queryAllUser(page);
			return "success";
		}
		return null;
	}
	
	//下一页
	public String next(){
		if(page>=total){
			return "fail";
		}else if(page<total){
			page+=1;
			userList = userService.queryAllUser(page);
			return "success";
		}
		return null;
	}
	
	//跳转页面
	public String toPage(){
		if(page>=1 && page<=total){
			userList = userService.queryAllUser(page);
			return "success";
		}else if(page<total){
			return "fail";
		}
		return null;
	}
	
	/**
	 * 查询单个用户
	 * 根据用户名
	 * */
	public String query(){
		userList = userService.queryUserByName(name);
		if(name == null){
			return "fail";
		}else{
			if(userList != null){
				return "success";
			}else{
				return "fail";
			}
		}
	}
	
	//删除用户
	public String deleteUser(){
		TbUser user = new TbUser();
		user.setId(id);
		int page1 = page;
		userList = userService.deleteUser(user,page1);;
		return "success";
	}
	
	//修改用户
	public String alertUser(){
		if(password.equals(repassword)){
			TbUser user = new TbUser();
			user.setName(name);
			user.setBalance(balance);
			user.setId(id);
			user.setPassword(password);
			user.setEmail(email);
			user.setSex(sex);
			user.setStatues(1);
			userService.alertUser(user);
			return "success"; 
		}else{
			return "fail";
		}
	}
	
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public UserService getUserService() {
		return userService;
	}

	public List<TbUser> getUserList() {
		return userList;
	}

	public void setUserList(List<TbUser> userList) {
		this.userList = userList;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
}
