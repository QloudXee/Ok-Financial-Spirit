package com.q.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.q.model.TbUser;
import com.q.service.UserService;

/**
 * ������
 * �û�ע�ᡢ��ѯ���޸ġ�ɾ������¼���˳������ܡ��û��б���ҳ��ע��ʱ��֤�û��Ƿ����
 * @author Qluod
 * */
@Controller
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
	
	private InputStream inputStream;
	
	//private Map<String, Object> map = ActionContext.getContext().getSession();

	List<TbUser> userList = null;
	
	//�û�ע�᷽��
	public String regiest(){
		TbUser tu = new TbUser();
		tu.setName(name);
		tu.setPassword(password);
		tu.setEmail(email);
		tu.setSex(sex);
		tu.setBalance(0);
		tu.setStatues(1);
		if(name!=null && password.equals(repassword) && password!=null){
			List<TbUser> users = userService.getAllUser();
			for(TbUser userTemp : users){
				if(userTemp.getName().equals(tu.getName())){
					return "fail";
				}else{
					userService.regiest(tu);
					return "success";
				}
			}
		}else{
			return "fail";
		}
		return null;
	}
	
	//��ѯ�����û�
	public String getAll(){
		page = 1;
		userList = userService.queryAllUser(page);
		total = userService.getTotal();
		return "success";
	}
	
	//��һҳ
	public String previous(){
		if(page<=1){
			return "fail";
		}else if(page>1){
			page--;
			userList = userService.queryAllUser(page);
			return "success";
		}
		return null;
	}
	
	//��һҳ
	public String next(){
		if(page>=total){
			return "fail";
		}else if(page<total){
			page++;
			userList = userService.queryAllUser(page);
			return "success";
		}
		return null;
	}
	
	//��תҳ��
	public String toPage(){
		if(page>=1 && page<=total){
			userList = userService.queryAllUser(page);
			return "success";
		}else if(page<total){
			return "fail";
		}
		return null;
	}
	
	//�����û�����ѯ�����û�
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
	
	//ɾ���û�
	public String deleteUser(){
		TbUser user = new TbUser();
		user.setId(id);
		userList = userService.deleteUser(user,page);
		return "success";
	}
	
	//�޸��û�
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
			TbUser user2 = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("userLogin");
			if(user2.getStatues() == 2){
				return "admin"; 
			}else if(user2.getStatues() == 1){
				return "success";
			}else{
				return "fail";
			}
		}else{
			return "fail";
		}
	}
	
	//�û���¼
	public String userLogin(){
		TbUser userlogin = userService.getUserByName(name);
		if(userlogin != null && userlogin.getStatues() != 0 && userlogin.getPassword().equals(password)){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("userLogin", userlogin);
			if(userlogin.getStatues() == 1){
				return "success";
			}else if(userlogin.getStatues() == 2){
				return "admin";
			}else{
				return "success";
			}
		}else if(userlogin.getStatues() == 0){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("loginMsg", "�û��ѱ�ɾ��");
			return "login";
		}else{
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("loginMsg", "�û���¼ʧ��");
			return "login";
		}
	}
	
	//��������
	public String forget() throws IOException{
		int temp = userService.forget(name,email,password);
		if(temp == 1){
			return "success";
		}else{
			return "fail";
		}
	}
	
	//�û��˳�
	public String logout(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "success";
	}
	
	//�û���ȷ��
	public String check() throws IOException{
		TbUser user = userService.getUserByName(name);
		JSONObject jsonObject = new JSONObject();
		if(user.getName().equals(name)){
			//String msg = "�û����Ѵ���";
			jsonObject.put("msg", "�û����Ѵ���");
			inputStream = new ByteArrayInputStream(jsonObject.toJSONString().getBytes("utf-8"));
		}
		return "success";
	}
	
	//��¼ʱ����֤
	public String loginCheck(){
		return "success";
	}
	
	//��֤����Ա�Ƿ񳬹�5��
	public String checkAdmin() throws UnsupportedEncodingException{
		TbUser user = userService.getUserById(id);
		int num = userService.checkAdmin();
		JSONObject jsonObject = new JSONObject();
		if(num>4){
			jsonObject.put("msg", "����Ա����5λ");
			inputStream = new ByteArrayInputStream(jsonObject.toJSONString().getBytes("utf-8"));
			return "success";
		}else if(user.getStatues() == 2){
			jsonObject.put("msg", "���û����ǹ���Ա");
			inputStream = new ByteArrayInputStream(jsonObject.toJSONString().getBytes("utf-8"));
			return "success";
		}else{
			userService.setAdmin(id);
			jsonObject.put("msg", "���óɹ�");
			inputStream = new ByteArrayInputStream(jsonObject.toJSONString().getBytes("utf-8"));
			return "success";
		}
	}
	
/*	//���ù���Ա
	public String setAdmin(){
		userService.setAdmin(id);
		return "success";
	}*/
	
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

	public InputStream getInputStream() {
		return inputStream;
	}
}
