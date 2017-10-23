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
 * �����˵�action
 * ������������ѯ������������
 * @author 13255
 *
 */
public class OrderAction {
	
	private Integer orderId;
	//���ڵõ���¼�û����û���
	private UserAction userAction;
	//ע���service
	private BalanceService balanceService;
	//jsp������money
	private String jsp_money;
	//�˵�������
	private String describe;
	//������Ӵ����˵���ʱ��
	private Date date;
	//�˵�������
	private String type;
	//�˵�list����
	private List<Order> list;
	//ҳ��
	private int page;
	//��ҳ��
	private int total;
	//�����˵�list����
	private List<Order> incomeList;
	//֧���˵�list����
	private List<Order> expendList;
	
	private TbUser userLogin = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("userLogin");
			
	/**
	 * �˵�����
	 * @return
	 */
	public String addMoney(){
		Order tbImport = new Order();
		Integer money = Integer.valueOf(jsp_money);
		
		tbImport.setOrderDescribe(describe);
		//"type=0"Ϊ����
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
	 * �˵�֧��
	 * @return
	 */
	public String lessMoney(){
		Order tbImport = new Order();
		Integer money = Integer.valueOf(jsp_money);
		
		tbImport.setOrderDescribe(describe);
		//"type=1"Ϊ֧��
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
	 * ��ѯ�˵�
	 */
	public String queryOrder(){
		page = 1;
		total = balanceService.getPage(userLogin.getName());
		list = balanceService.getOrder(userLogin.getName(),page);
		return "success";
	}
	/**
	 * ��һҳ
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
	 * ��һҳ
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
	 * ��תҳ��
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
	 * ��ѯ�����˵�
	 */
	public String queryIncomeOrder(){
		page = 1;
		total = balanceService.getPage(userLogin.getName(),0);
		incomeList = balanceService.getOrder(userLogin.getName(),page,0);
		return "success";
	}
	/**
	 * ��һҳ
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
	 * ��һҳ
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
	 * ��תҳ��
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
	 * ��ѯ֧���˵�
	 */
	public String queryExpendOrder(){
		page = 1;
		total = balanceService.getPage(userLogin.getName(),1);
		expendList = balanceService.getOrder(userLogin.getName(),page,1);
		return "success";
	}
	/**
	 * ��һҳ
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
	 * ��һҳ
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
	 * ��תҳ��
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
	 * ע���service
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
