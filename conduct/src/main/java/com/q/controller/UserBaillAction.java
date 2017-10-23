package com.q.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.q.model.Order;
import com.q.service.BalanceService;

public class UserBaillAction {

	//ע���service
	private BalanceService balanceService;
	//��jsp�õ�id
	private Long id;
	//�õ���id���ٲ�ѯ��order
	private Order order;
	
	private String orderDescribe;
	
	private Integer type;
	//����&֧��("0"Ϊ���룬"1"Ϊ֧��)
	private Integer money;
	
	//private Date date;
	/**
	 * ��ѯ�����˵�
	 * @return
	 */
	public String queryBill(){
		order = balanceService.queryOrder(id);
		return "success";
	}
	/**
	 * �޸��˵�
	 */
	public String changeBill(){
		balanceService.changeBill(id,orderDescribe,type,money);
		return "success";
	}
	/**
	 * ɾ���˵�
	 */
	public String deleteBill(){
		balanceService.deleteBill(id);
		return "success";
	}
	/**
	 * ע���service
	 */
	@Resource
	public void setBalanceService(BalanceService balanceService) {
		this.balanceService = balanceService;
	}
	/**
	 * ������get&set����
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getOrderDescribe() {
		return orderDescribe;
	}
	public void setOrderDescribe(String orderDescribe) {
		this.orderDescribe = orderDescribe;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	
}
