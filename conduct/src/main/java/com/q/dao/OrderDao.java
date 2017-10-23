package com.q.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.q.model.Order;
import com.q.model.TbUser;

@Repository("OrdertDao")
public class OrderDao {
	private SessionFactory sessionFactory;
	private Session session;
		
		@Resource(name="mySessionFactory")
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		public Session getSession(){
			return sessionFactory.getCurrentSession();
		}
		/**
		 * 获取用户账户
		 * @param name
		 * @param money
		 * @return
		 */
		public TbUser queryAccount(String name){
			session = getSession();
			String hql = "select tu from TbUser tu where name=?";
			Query query = session.createQuery(hql);
			query.setString(0, name);
			System.out.println(query.list());
			return (TbUser)query.list().get(0);
		}
		/**
		 * 通过id获取用户
		 * @param id
		 * @return
		 */
		public TbUser queryAccount(Long id){
			session = getSession();
			String hql = "select tu from TbUser tu where id=?";
			Query query = session.createQuery(hql);
			query.setLong(0, id);
			System.out.println(query.list());
			return (TbUser)query.list().get(0);
		}
		/**
		 * 修改用户信息
		 */
		public void updateUser(Long id,String name,String sex,String email){
			TbUser user = queryAccount(id);
			user.setName(name);
			user.setSex(sex);
			user.setEmail(email);
			session.update(user);
		}
		/**
		 * 修改密码
		 */
		public void changePassword(Long id,String newPassword){
			TbUser user = queryAccount(id);
			user.setPassword(newPassword);
			session.update(user);
		}
		/**
		 * 添加用户账单
		 * @param tbImport
		 */
		public void addOrder(Order order){
			session.save(order);
		}
		/**
		 * 修改账户余额(加钱)
		 */
		public boolean addMoney(String name, int money){
			TbUser tbUser = queryAccount(name);
			if(money>0){
				tbUser.setBalance(tbUser.getBalance()+money);
				session.update(tbUser);
				return true;
			}
			return false;
		}
		/**
		 * 修改账户余额(减钱)
		 */
		public boolean lessMoney(String name, int money){
			TbUser tbUser = queryAccount(name);
			if(money>0&&tbUser.getBalance()>money){
				tbUser.setBalance(tbUser.getBalance()-money);
				session.update(tbUser);
				return true;
			}
			return false;
		}
		/**
		 * 查询用户所有账单的总页数
		 */
		public int queryPage(String name){
			session = getSession();
			String hql = "SELECT o FROM Order o,TbUser t WHERE t.id=o.tbUser.id and name=? and o.statues=1";
			Query query = session.createQuery(hql);
			query.setString(0, name);
			return query.list().size()/10;
		}
		/**
		 * 分页查询账单
		 * @param name
		 * @param number
		 * @return
		 */
		public List<Order> queryOrder(String name,int number){
			session = getSession();
			String hql = "SELECT o FROM Order o,TbUser t WHERE t.id=o.tbUser.id and name=? and o.statues=1";
			Query query = session.createQuery(hql);
			query.setString(0, name);
			return query.setFirstResult((number-1)*10)
					.setMaxResults(10)
					.list();
		}
		/**
		 * 查询用户所有收入&支出账单的总页数
		 */
		public int queryPage(String name,int type){
			session = getSession();
			String hql = "SELECT o FROM Order o,TbUser t WHERE t.id=o.tbUser.id and name=? and o.statues=1 and type=?";
			Query query = session.createQuery(hql);
			query.setString(0, name);
			query.setInteger(1, type);
			return query.list().size()/10;
		}
		/**
		 * 分页查询收入&支出账单
		 * @param name
		 * @param number
		 * @return
		 */
		public List<Order> queryOrder(String name,int number,int type){
			session = getSession();
			String hql = "SELECT o FROM Order o,TbUser t WHERE t.id=o.tbUser.id and name=? and o.statues=1 and type=?";
			Query query = session.createQuery(hql);
			query.setString(0, name);
			query.setInteger(1, type);
			return query.setFirstResult((number-1)*10)
					.setMaxResults(10)
					.list();
		}
		/**
		 * 查询用户所有收入&支出账单
		 */
		public List<Order> queryAllOrder(String name,int type){
			session = getSession();
			String hql = "SELECT o FROM Order o,TbUser t WHERE t.id=o.tbUser.id and name=? and o.statues=1 and type=?";
			Query query = session.createQuery(hql);
			query.setString(0, name);
			query.setInteger(1, type);
			return query.list();
		}
		/**
		 * 通过id拿到单个账单
		 * @param id
		 * @return
		 */
		public Order queryOrder(Long id) {
			session = getSession();
			String hql = "select o from Order o where id=? and statues=1";
			Query query = session.createQuery(hql);
			query.setLong(0, id);
			System.out.println(query.list());
			return (Order)query.list().get(0);
		}
		/**
		 * 修改单个账单
		 * @param id
		 * @param orderDescribe
		 * @param type
		 * @param money
		 */
		public void changeBill(Long id, String orderDescribe, Integer type, Integer money) {
			Order order = queryOrder(id);
			order.setOrderDescribe(orderDescribe);
			order.setType(type);
			order.setMoney(money);
			session.update(order);
			
		}

		public void deleteBill(Long id) {
			Order order = queryOrder(id);
			order.setStatues(0);
			session.update(order);
			
		}
}
