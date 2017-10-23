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
		 * ��ȡ�û��˻�
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
		 * ͨ��id��ȡ�û�
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
		 * �޸��û���Ϣ
		 */
		public void updateUser(Long id,String name,String sex,String email){
			TbUser user = queryAccount(id);
			user.setName(name);
			user.setSex(sex);
			user.setEmail(email);
			session.update(user);
		}
		/**
		 * �޸�����
		 */
		public void changePassword(Long id,String newPassword){
			TbUser user = queryAccount(id);
			user.setPassword(newPassword);
			session.update(user);
		}
		/**
		 * ����û��˵�
		 * @param tbImport
		 */
		public void addOrder(Order order){
			session.save(order);
		}
		/**
		 * �޸��˻����(��Ǯ)
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
		 * �޸��˻����(��Ǯ)
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
		 * ��ѯ�û������˵�����ҳ��
		 */
		public int queryPage(String name){
			session = getSession();
			String hql = "SELECT o FROM Order o,TbUser t WHERE t.id=o.tbUser.id and name=? and o.statues=1";
			Query query = session.createQuery(hql);
			query.setString(0, name);
			return query.list().size()/10;
		}
		/**
		 * ��ҳ��ѯ�˵�
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
		 * ��ѯ�û���������&֧���˵�����ҳ��
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
		 * ��ҳ��ѯ����&֧���˵�
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
		 * ��ѯ�û���������&֧���˵�
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
		 * ͨ��id�õ������˵�
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
		 * �޸ĵ����˵�
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
