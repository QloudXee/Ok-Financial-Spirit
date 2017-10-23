package com.q.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.q.model.Order;
import com.q.service.BalanceService;

public class UserBaillAction {

	//注入的service
	private BalanceService balanceService;
	//从jsp拿到id
	private Long id;
	//拿到的id，再查询的order
	private Order order;
	
	private String orderDescribe;
	
	private Integer type;
	//收入&支出("0"为收入，"1"为支出)
	private Integer money;
	
	//private Date date;
	/**
	 * 查询单个账单
	 * @return
	 */
	public String queryBill(){
		order = balanceService.queryOrder(id);
		return "success";
	}
	/**
	 * 修改账单
	 */
	public String changeBill(){
		balanceService.changeBill(id,orderDescribe,type,money);
		return "success";
	}
	/**
	 * 删除账单
	 */
	public String deleteBill(){
		balanceService.deleteBill(id);
		return "success";
	}
	/**
	 * 注入的service
	 */
	@Resource
	public void setBalanceService(BalanceService balanceService) {
		this.balanceService = balanceService;
	}
	/**
	 * 下面是get&set方法
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
