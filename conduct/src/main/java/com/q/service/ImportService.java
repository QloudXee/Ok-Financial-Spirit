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
	
	//根据订单id查询
	public TbImport queryImportById(long id){
		TbImport tbImport = importDao.queryImportById(id);
		return tbImport;
	}
	
	//根据用户查询
	public List<TbImport> queryImportByUser(long id){
		List<TbImport> importList = importDao.queryImportByUser(id);
		return importList;
	}
	
	//新增进账，并处理
	public void addImport(TbImport tbImport){
		//数据库新增进账信息
		importDao.addImport(tbImport);
		//用户增加余额
		long id = tbImport.getTbUser().getId();
		TbUser tbUser = userDao.getUserById(id);
		int balance = tbUser.getBalance() + tbImport.getInputNum();
		userDao.addBalance(balance,id);
	}
	
	//删除订单
	public void deleteImport(){
		
	} 
	
	//修改订单
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
