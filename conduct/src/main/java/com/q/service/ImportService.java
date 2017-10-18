package com.q.service;

import java.util.List;

import javax.annotation.Resource;

import com.q.dao.ImportDao;
import com.q.dao.UserDao;
import com.q.model.TbImport;
import com.q.model.TbUser;

public class ImportService {
	
	private ImportDao importDao;
	private UserDao userDao;
	
	//���ݶ���id��ѯ
	public TbImport queryImportById(long id){
		TbImport tbImport = importDao.queryImportById(id);
		return tbImport;
	}
	
	//�����û���ѯ
	public List<TbImport> queryImportByUser(long id){
		List<TbImport> importList = importDao.queryImportByUser(id);
		return importList;
	}
	
	//�������ˣ�������
	public void addImport(TbImport tbImport){
		//���ݿ�����������Ϣ
		importDao.addImport(tbImport);
		//�û��������
		long id = tbImport.getTbUser().getId();
		TbUser tbUser = userDao.getUserById(id);
		int balance = tbUser.getBalance() + tbImport.getInputNum();
		userDao.addBalance(balance,id);
	}
	
	//ɾ������
	public void deleteImport(){
		
	} 
	
	//�޸Ķ���
	public void alertImport(){
		
	}

	@Resource(name="importDao")
	public void setImportDao(ImportDao importDao) {
		this.importDao = importDao;
	}

	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
