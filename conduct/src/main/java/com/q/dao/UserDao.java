package com.q.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.q.model.TbUser;

/**
 * �û����ݲ�����
 * ����(user)
 * ɾ��(user)����״̬Ϊ0
 * �޸�(user)
 * ��ѯ(name/id)����������list Ҳ�е���user�������������ʹ�ò�ͬ��
 * @author Qloud
 * */
@Repository("userDao")
public class UserDao {

	private SessionFactory sessionFactory;
	
	@Resource(name="mySessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * �û�ע��
	 * @param user
	 * */
	public void regiest(TbUser user) {
		Session session = getSession(); 
		session.save(user);
	}
	
	/**
	 * ��ѯȫ���û�
	 * �˴�Ϊ��ѯȫ���������������ʮ���û�
	 * һ��ҳ�������ʾʮ���û�
	 * @param page
	 * @return List<TbUser>
	 * */
	public List<TbUser> getAll(int page) {
		Session session = getSession(); 
		String hql = "FROM TbUser u WHERE u.statues = 1 OR u.statues = 2";
		Query query = session.createQuery(hql);
		query.setFirstResult(page*10-10);
		query.setMaxResults(10);
		List<TbUser> userList = query.list();
		return userList;
	}
	
	/**
	 * ��ȡȫ���û���Ϣ
	 * @author Qloud
	 * @return List<TbUser>
	 * */
	public List<TbUser> getTotal() {
		Session session = getSession(); 
		String hql = "FROM TbUser WHERE statues = 1 OR statues = 2";
		List<TbUser> users = session.createQuery(hql).list();
		return users;
	}
	
	/**
	 * �����û�����ѯ�û�
	 * @param name
	 * @author Qloud
	 * @return List<TbUser>
	 * */
	public List<TbUser> queryUserByName(String name) {
		Session session = getSession(); 
		String hql = "FROM TbUser u WHERE (u.statues = 1 OR u.statues = 2) AND u.name = ?";
		List<TbUser> users = session.createQuery(hql).setParameter(0, name)
													 .list();
		return users;
	}

	/**
	 * ɾ���û�
	 * @param usere
	 * */
	public void deleteUser(TbUser user) {
		Session session = getSession(); 
		session.update(user);
	}

	/**
	 * �޸��û�
	 * @param user
	 * */
	public void alertUser(TbUser user) {
		Session session = getSession(); 
		session.update(user);
	}
	
	/**
	 * �û���¼
	 * �����ȡ�û���Ϣ
	 * @param name
	 * @author Qloud
	 * @return TbUser
	 * */
	public TbUser login(String name) {
		Session session = getSession();
		String hql = "FROM TbUser u WHERE u.name = ?";
		TbUser user = (TbUser) session.createQuery(hql).setParameter(0, name).uniqueResult();
		return user;
	}
	
	/**
	 * �����û�id��ѯ
	 * @param id
	 * @author Qloud
	 * @return tbUser
	 * */
	public TbUser getUserById(long id){
		Session session = getSession();
		String hql = "FROM TbUser u WHERE u.id = ?";
		TbUser tbUser = (TbUser) session.createQuery(hql)
										.setParameter(0, id)
										.uniqueResult();
		return tbUser;
	}

	/**
	 * ��Ϊ�������ˣ��û��������
	 * @param inputNum,userId 
	 * */
	public void addBalance(Integer nowbalance, Long userId) {
		Session session = getSession();
		String hql = "UPDATE TbUser u SET u.balance = ? WHERE id = ?";
		session.createQuery(hql).setParameter(0, nowbalance).setParameter(1, userId);
	}
	
	/**
	 * �����û�����ѯ�û���Ϣ
	 * @param name
	 * @return user
	 * */
	public TbUser getUserByName(String name){
		Session session = getSession();
		String hql = "FROM TbUser u WHERE u.name = ?";
		TbUser user = (TbUser) session.createQuery(hql).setParameter(0, name).uniqueResult();
		return user;
	}
	
	/**
	 * ��������
	 * @param useer
	 * */
	public void forget(TbUser user) {
		Session session = getSession();
		session.update(user);
	}

	/**
	 * �������еĹ���Ա
	 * @return List<TbUser>
	 * */
	public List<TbUser> checkAdmin() {
		Session session = getSession();
		String hql = "FROM TbUser u WHERE u.statues = 2";
		List<TbUser> admins = session.createQuery(hql).list();
		return admins;
	}

	/**
	 * ���ù���Ա
	 * @param user
	 * */
	public void setAdmin(TbUser user) {
		Session session = getSession();
		String hql = "UPDATE TbUser u SET u.statues = 2";
		session.update(user);
	}

}
