package com.q.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.q.model.TbUser;
import com.q.service.BalanceService;
/**
 * ��¼���û�action
 * ��������ѯ��ǰ�û����޸ĵ�ǰ�û���Ϣ���޸��û�����
 * @author 13255
 *
 */
public class LoginUserAction {
	private String name;
	private String sex;
	private String email;
	private String password;
	private String newPassword;
	//��ǰ�ĵ�¼�û�
	private TbUser user;
	//ע���service
	private BalanceService balanceService;
	//���ڵõ���¼�û����û���
	private UserAction userAction;
	
	private TbUser userLogin = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("userLogin");
	/**
	 * ��ȡ��ǰ�û���Ϣ
	 * @return
	 */
	public String querUser(){
		user = balanceService.getUser(userLogin.getName());
		return "success";
	}
	/**
	 * �û������޸�
	 */
	/*public String changeUserDate(){
		balanceService.getUser(user.getId(),name,sex,email);
		return "success";
	}*/
	/**
	 * �޸�����
	 */
	public String changePassword(){
		if(user.getPassword().equals(password)){
			balanceService.changePassword(user.getId(),newPassword);
			return "success";
		}
		return "fail";
	}
	/**
	 * ע��balanceService
	 * @param balanceService the balanceService to set
	 */
	@Resource
	public void setBalanceService(BalanceService balanceService) {
		this.balanceService = balanceService;
	}
	/**
	 * ������get&set����
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
