package com.q.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.q.model.TbUser;
import com.q.service.BalanceService;
/**
 * 登录的用户action
 * 方法：查询当前用户，修改当前用户信息，修改用户密码
 * @author 13255
 *
 */
public class LoginUserAction {
	private String name;
	private String sex;
	private String email;
	private String password;
	private String newPassword;
	//当前的登录用户
	private TbUser user;
	//注入的service
	private BalanceService balanceService;
	//用于得到登录用户的用户名
	private UserAction userAction;
	
	private TbUser userLogin = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("userLogin");
	/**
	 * 获取当前用户信息
	 * @return
	 */
	public String querUser(){
		user = balanceService.getUser(userLogin.getName());
		return "success";
	}
	/**
	 * 用户资料修改
	 */
	/*public String changeUserDate(){
		balanceService.getUser(user.getId(),name,sex,email);
		return "success";
	}*/
	/**
	 * 修改密码
	 */
	public String changePassword(){
		if(user.getPassword().equals(password)){
			balanceService.changePassword(user.getId(),newPassword);
			return "success";
		}
		return "fail";
	}
	/**
	 * 注入balanceService
	 * @param balanceService the balanceService to set
	 */
	@Resource
	public void setBalanceService(BalanceService balanceService) {
		this.balanceService = balanceService;
	}
	/**
	 * 下面是get&set方法
	 * @return
	 */
	public TbUser getUser() {
		return user;
	}
	public void setUser(TbUser user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
