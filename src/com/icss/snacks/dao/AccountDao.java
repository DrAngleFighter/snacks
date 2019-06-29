package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Account;
import com.icss.snacks.util.DbFactory;

/**
 * �˻����ݲ�
 * @author yww
 *
 */
public class AccountDao {
	
	public Integer Add(Account account) throws Exception{
		Integer row=0;
		Connection connection = DbFactory.openConnection();
		String sql = "insert into tb_account(uid,money) value(?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, account.getUid());
		ps.setDouble(2, account.getMoney());
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	public Integer Update(Account account) throws Exception{
		Integer row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "update tb_account set uid = ?,money=? where account_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setDouble(2, account.getMoney());
		ps.setInt(1, account.getUid());
		ps.setInt(3, account.getAccount_id());
		
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	public Integer Delete(Integer account_id) throws Exception{
		Integer row = 0;
		//1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "delete from tb_account where account_id=?";
		//3.����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.����ռλ����ֵ
		ps.setInt(1, account_id);
		
		//5.ִ��sql������Ӱ������
		row = ps.executeUpdate();
		//6.�ͷ���Դ
		ps.close();
		return row;
	}
	public Account findAccountByAccount_id(Integer account_id) throws Exception{
		 /**
		  * ��ѯ�û�����
		  */
		 Account account = null;
		 //1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "select * from tb_account where account_id=?";
		//3.����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.����ռλ����ֵ
		ps.setInt(1, account_id);
		//5.ִ��sql�����ؽ����
		ResultSet rs = ps.executeQuery();
		//6.���������������ȡ�������������
		if(rs.next()) {
			account = new Account();
			account.setAccount_id(rs.getInt("account_id"));
			account.setMoney(rs.getDouble("money"));
			account.setUid(rs.getInt("uid"));
		}
		//6.�ͷ���Դ
		rs.close();
		ps.close();
		return account;
	 }
	public List<Account> findAllAccountList() throws Exception{
		 List<Account> accountList = new ArrayList<Account>();
		//1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "select * from tb_account";
		//3.����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.ִ��sql�����ؽ����
		ResultSet rs = ps.executeQuery();
		//5.ѭ����ȡ�û�������ӵ�������
		while(rs.next()) {
			Account account = new Account();
			account.setAccount_id(rs.getInt("account_id"));
			account.setMoney(rs.getDouble("money"));
			account.setUid(rs.getInt("uid"));
			
			accountList.add(account);
		}
		//6.�ͷ���Դ
		rs.close();
		ps.close();
		return accountList;
	 }
	public Integer findAccountCount() throws Exception{
		 Integer count = 0;
		//1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "select count(*) from tb_account";
		//3.����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.ִ��sql�����ؽ����
		ResultSet rs = ps.executeQuery();
		//5.�Ӽ�������ȡ����
		if(rs.next()) {
			count = rs.getInt(1);
		}
		//6.�ͷ���Դ
		rs.close();
		ps.close();
		 return count;
	 }
	public static void main(String[] args) throws Exception{
//		Account account = new Account();
		AccountDao accountDao = new AccountDao();
//		account.setUid(2);
//		account.setMoney(1020);
//		Integer row = accountDao.Add(account);
//		System.out.println(row);
		
//		account.setAccount_id(1);
//		account.setUid(1);
//		account.setMoney(200);
//		Integer row = accountDao.Update(account);
//		System.out.println(row);
		
//		Integer row = accountDao.Delete(1);
//		System.out.println(row);
		
//		account = accountDao.findAccountByAccount_id(1);
//		System.out.println(account.getAccount_id());
		
//		List<Account> lu = accountDao.findAllAccountList();
//		System.out.println(lu.size());
		
		Integer x = accountDao.findAccountCount();
		System.out.println(x);
	}
}


