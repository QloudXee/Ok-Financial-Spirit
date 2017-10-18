package com.q.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.q.dao.UserDao;
import com.q.model.TbUser;

/**
 * �û�ҵ���
 * �û�ע��,�û�����,�û�ɾ��,��ѯ�����û�,����id��ѯ�û�
 * @author Qloud
 * */
@Service("userService")
public class UserService {
	
	private UserDao userDao;
	
	//�û�ע��
	public void regiest(TbUser user){
		userDao.regiest(user);
	}
	
	//�û�����
	public void alertUser(TbUser user){
		userDao.alertUser(user);
	}
	
	//�û�ɾ��
	public List<TbUser> deleteUser(TbUser user, int page){
		TbUser user1 = userDao.getUserById(user.getId());
		user1.setStatues(0);
		userDao.deleteUser(user1);
		List<TbUser> userList = userDao.getAll(page);
		return userList;
	}
	
	//��ѯ�����û�
	public List<TbUser> queryAllUser(int page){
		List<TbUser> userList = userDao.getAll(page);
		return userList;
	}
	
	//�����û�����ѯ�û�
	public List<TbUser> queryUserByName(String name){
		List<TbUser> userList = userDao.queryUserByName(name);
		return userList;
	}
	
	/**
	 * ��ȡ��ҳ��
	 * dao��ȡ�����û���Ϣ
	 * ��������û�list��size��ȡ��ҳ����һҳʮ���û�
	 * @author Qloud
	 * @return int
	 * */
	public int getTotal() {
		List<TbUser> users = userDao.getTotal();
		int total = 0;
		int temp = users.size();
		while(temp/10>0){
			total++;
			temp-=10;
		}
		if(temp>0){
			total++;
		}
		return total;
	}

	/**
	 * �û���¼
	 * dao�����û���Ϣ
	 * ����Ч�������Ƿ�һ��
	 * @author Qluod
	 * @return int
	 * */
	public int login(String name, String password) {
		TbUser user = userDao.login(name);
		int i = 0;
		if(user == null){
			i = 0;
			return i;
		}else if(user.getPassword().equals(password)){
			i = 1;
			return i;
		}else{
			i = 2;
			return i;
		}
	}
	
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

}