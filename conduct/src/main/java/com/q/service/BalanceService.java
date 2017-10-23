package com.q.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.q.dao.OrderDao;
import com.q.model.Order;
import com.q.model.TbUser;
/**
 * �˻����ҵ����
 * @author 13255
 *
 */
@Service
public class BalanceService {
	private OrderDao order;
	/**
	 * ��Ǯ
	 */
	public boolean addMoney(String name, int money,Order tbImport){
		if(order.addMoney(name, money)){
			order.addOrder(tbImport);
			return true;
		}
		return false;
	}
	/**
	 * ��Ǯ
	 */
	public boolean lessMoney(String name, int money,Order output){
		if(order.lessMoney(name, money)){
			order.addOrder(output);
			return true;
		}
		return false;
	}
	/**
	 * ��ȡ�˻�
	 * @param name
	 * @return
	 */
	public TbUser getUser(String name){
		return order.queryAccount(name);
	}
	/**
	 * ͨ��id�õ�user
	 * @param id
	 * @return
	 */
	public void getUser(Long id,String name,String sex,String email){
		order.updateUser(id,name,sex,email);
	}
	/**
	 * ��ȡ�˵�
	 * @param name
	 * @return
	 */
	public List<Order> getOrder(String name,int number){
		return order.queryOrder(name,number);
	}
	/**
	 * ��ȡ��ҳ��
	 * @param name
	 * @return
	 */
	public int getPage(String name){
		return order.queryPage(name)+1;
	}
	/**
	 * ��ȡ����&֧���˵�
	 * @param name
	 * @return
	 */
	public List<Order> getOrder(String name,int number,int type){
		return order.queryOrder(name,number,type);
	}
	/**
	 * ��ȡ����&֧����ҳ��
	 * @param name
	 * @return
	 */
	public int getPage(String name,int type){
		return order.queryPage(name,type)+1;
	}
	/**
	 * �޸�����
	 * @param id
	 * @param newPassword
	 */
	public void changePassword(Long id,String newPassword){
		order.changePassword(id,newPassword);
	}
	/**
	 * ��ѯ��������&֧���ܽ��
	 * @param username
	 * @param type
	 * @return
	 */
	public Integer getAllMoney(String username,int type) {
		List<Order> list = order.queryAllOrder(username, type);
		int balance = 0;
		for (Order od : list) {
			balance = balance+od.getMoney();
		}
		return balance;
	}
	/**
	 * ��ѯ��������&֧���ܽ��
	 * @param username
	 * @param i
	 * @param date
	 * @return
	 */
	public Integer getMoney(String username, int type, String date) {
		List<Order> list = order.queryAllOrder(username, type);
		int balance = 0;
		for (Order od : list) {
			if(od.getDate().toString().substring(0, 9).equals(date)){
				balance = balance+od.getMoney();
			}
		}
		return balance;
	}
	/**
	 * ��ѯ�����˵�
	 * @param id
	 * @return
	 */
	public Order queryOrder(Long id) {
		return order.queryOrder(id);
	}
	/**
	 * �޸ĵ����˵�
	 * @param id
	 * @param orderDescribe
	 * @param type
	 * @param money
	 */
	public void changeBill(Long id, String orderDescribe, Integer type, Integer money) {
		order.changeBill(id,orderDescribe,type,money);
		
	}
	/*
	 * ɾ�������˵�
	 */
	public void deleteBill(Long id) {
		order.deleteBill(id);
	}
	/**
	 * @param order the order to set
	 */
	@Resource
	public void setOrder(OrderDao order) {
		this.order = order;
	}

	
}
