package com.q.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.q.model.TbImport;

@Repository("importDao")
public class ImportDao {
	
	private SessionFactory sessionFactory;
	
	@Resource(name="mySessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	/**
	 * ����id��ѯ����
	 * tbImport
	 * */
	public TbImport queryImportById(long id) {
		Session session = getSession();
		String hql = "FROM TbImport ti WHERE ti.statues = 1 AND id = ?";
		TbImport tbImport = (TbImport) session.createQuery(hql)
											  .setParameter(0, id)
											  .uniqueResult();
		return tbImport;
	}

	/**
	 * �����û�id��ѯ
	 * @return List<TbImport>
	 * */
	public List<TbImport> queryImportByUser(long id) {
		Session session = getSession();
		String hql = "FROM TbImport ti WHERE ti.userId = ? AND ti.statues = 1";
		List<TbImport> importList = session.createQuery(hql).list();
		return importList;
	}

	/**
	 * ��������
	 * */
	public void addImport(TbImport tbImport) {
		Session session = getSession();
		session.save(tbImport);
	}
}
