package com.q.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.metamodel.source.hbm.SetAttributeSourceImpl;
import org.springframework.stereotype.Repository;

import com.q.model.TbUser;

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
	
	//用户注册
	public void regiest(TbUser user) {
		Session session = getSession(); 
		session.save(user);
	}
	
	/**
	 * 查询全部用户
	 * 此处为查询全部符合条件的最多十个用户
	 * 一个页面最多显示十个用户
	 * @param page
	 * @author Qloud
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
	 * 获取全部用户信息
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
	 * 根据用户名查询用户
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

	//删除用户
	public void deleteUser(TbUser user) {
		Session session = getSession(); 
		session.update(user);
	}

	//修改用户
	public void alertUser(TbUser user) {
		Session session = getSession(); 
		session.update(user);
	}
	
	/**
	 * 用户登录
	 * 这里获取用户信息
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
	 * 根据用户id查询
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
	 * 因为新增进账，用户余额增加
	 * @param inputNum,userId 
	 * */
	public void addBalance(Integer nowbalance, Long userId) {
		Session session = getSession();
		String hql = "UPDATE TbUser u SET u.balance = ? WHERE id = ?";
		session.createQuery(hql).setParameter(0, nowbalance).setParameter(1, userId);
	}
	
	/**
	 * @return 
	 * */
	public TbUser getUserByName(String name){
		Session session = getSession();
		String hql = "FROM TbUser u WHERE u.name = ?";
		TbUser user = (TbUser) session.createQuery(hql).setParameter(0, name).uniqueResult();
		return user;
	}

	public void forget(TbUser user) {
		Session session = getSession();
		session.update(user);
	}

}
