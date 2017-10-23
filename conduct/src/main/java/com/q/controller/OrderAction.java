package com.q.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.q.model.Order;
import com.q.model.TbUser;
import com.q.service.BalanceService;
/**
 * 所有账单action
 * 包含新增，查询两个基本方法
 * @author 13255
 *
 */
public class OrderAction {
	
	private Integer orderId;
	//用于得到登录用户的用户名
	private UserAction userAction;
	//注入的service
	private BalanceService balanceService;
	//jsp传来的money
	private String jsp_money;
	//账单的描述
	private String describe;
	//用于添加创建账单的时间
	private Date date;
	//账单的类型
	private String type;
	//账单list集合
	private List<Order> list;
	//页码
	private int page;
	//总页数
	private int total;
	//收入账单list集合
	private List<Order> incomeList;
	//支出账单list集合
	private List<Order> expendList;
	
	private TbUser userLogin = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("userLogin");
			
	/**
	 * 账单收入
	 * @return
	 */
	public String addMoney(){
		Order tbImport = new Order();
		Integer money = Integer.valueOf(jsp_money);
		
		tbImport.setOrderDescribe(describe);
		//"type=0"为收入
		tbImport.setType(Integer.valueOf(type));
		tbImport.setMoney(money);
		tbImport.setDate(new Date());
		tbImport.setTbUser(balanceService.getUser(userLogin.getName()));
		tbImport.setStatues(1);
		
		System.out.println(money);
		if(balanceService.addMoney(userLogin.getName(), money, tbImport)){
			return "success";
		}
		return "fail";
	}
	/**
	 * 账单支出
	 * @return
	 */
	public String lessMoney(){
		Order tbImport = new Order();
		Integer money = Integer.valueOf(jsp_money);
		
		tbImport.setOrderDescribe(describe);
		//"type=1"为支出
		tbImport.setType(Integer.valueOf(type));
		tbImport.setMoney(money);
		tbImport.setDate(new Date());
		tbImport.setTbUser(balanceService.getUser(userLogin.getName()));
		tbImport.setStatues(1);
		
		System.out.println(money);
		if(balanceService.addMoney(userLogin.getName(), money, tbImport)){
			return "success";
		}
		return "fail";
	}
	/**
	 * 查询账单
	 */
	public String queryOrder(){
		page = 1;
		total = balanceService.getPage(userLogin.getName());
		list = balanceService.getOrder(userLogin.getName(),page);
		return "success";
	}
	/**
	 * 上一页
	 * @return
	 */
	public String upPage(){
		if(page>1){
			page--;
			list = balanceService.getOrder(userLogin.getName(), page);
			return "success";
		}
		return "fail";
	}
	/**
	 * 下一页
	 * @return
	 */
	public String downPage(){
		if(page<total){
			page++;
			list = balanceService.getOrder(userLogin.getName(), page);
			return "success";
		}
		return "fail";
	}
	/**
	 * 跳转页面
	 * @return
	 */
	public String toPage(){
		if(page>=1&&page<=total){
			list = balanceService.getOrder(userLogin.getName(), page);
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 查询收入账单
	 */
	public String queryIncomeOrder(){
		page = 1;
		total = balanceService.getPage(userLogin.getName(),0);
		incomeList = balanceService.getOrder(userLogin.getName(),page,0);
		return "success";
	}
	/**
	 * 上一页
	 * @return
	 */
	public String upPageIncome(){
		if(page>1){
			page--;
			incomeList = balanceService.getOrder(userLogin.getName(), page,0);
			return "success";
		}
		return "fail";
	}
	/**
	 * 下一页
	 * @return
	 */
	public String downPageIncome(){
		if(page<total){
			page++;
			incomeList = balanceService.getOrder(userLogin.getName(), page,0);
			return "success";
		}
		return "fail";
	}
	/**
	 * 跳转页面
	 * @return
	 */
	public String toPageIncome(){
		if(page>=1&&page<=total){
			incomeList = balanceService.getOrder(userLogin.getName(), page,0);
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 查询支出账单
	 */
	public String queryExpendOrder(){
		page = 1;
		total = balanceService.getPage(userLogin.getName(),1);
		expendList = balanceService.getOrder(userLogin.getName(),page,1);
		return "success";
	}
	/**
	 * 上一页
	 * @return
	 */
	public String upPageExpend(){
		if(page>1){
			page--;
			expendList = balanceService.getOrder(userLogin.getName(), page,1);
			return "success";
		}
		return "fail";
	}
	/**
	 * 下一页
	 * @return
	 */
	public String downPageExpend(){
		if(page<total){
			page++;
			expendList = balanceService.getOrder(userLogin.getName(), page,1);
			return "success";
		}
		return "fail";
	}
	/**
	 * 跳转页面
	 * @return
	 */
	public String toPageExpend(){
		if(page>=1&&page<=total){
			expendList = balanceService.getOrder(userLogin.getName(), page,1);
			return "success";
		}
		return "fail";
	}

	/**
	 * 注入的service
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
	public String getDescribe() {
		return describe;
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
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getJsp_money() {
		return jsp_money;
	}
	public void setJsp_money(String jsp_money) {
		this.jsp_money = jsp_money;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public List<Order> getIncomeList() {
		return incomeList;
	}
	public void setIncomeList(List<Order> incomeList) {
		this.incomeList = incomeList;
	}
	public List<Order> getExpendList() {
		return expendList;
	}
	public void setExpendList(List<Order> expendList) {
		this.expendList = expendList;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
