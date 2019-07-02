package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Address;
import com.icss.snacks.util.DbFactory;

/**
 * ��ַ���ݲ�
 * @author yww
 *
 */
public class AddressDao {
	
	public Integer Add(Address address) throws Exception{
		Integer row=0;
		Connection connection = DbFactory.openConnection();
		String sql = "insert into tb_address(uid,full_address,phone,zip_code,name,state) value(?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, address.getUid());
		ps.setString(2, address.getFull_address());
		ps.setString(3, address.getPhone());
		ps.setString(4, address.getZip_code());
		ps.setString(5, address.getName());
		ps.setInt(6, address.getState());
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	
	
	public Integer Update(Address address) throws Exception{
		Integer row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "update tb_address set uid = ?,full_address=?,phone=?,zip_code=?,name=?,state=? where address_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, address.getUid());
		ps.setString(2, address.getFull_address());
		ps.setString(3, address.getPhone());
		ps.setString(4, address.getZip_code());
		ps.setString(5, address.getName());
		ps.setInt(6, address.getState());
		ps.setInt(7, address.getAddress_id());
		
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	
	
	public Integer Delete(Integer address_id) throws Exception{
		Integer row = 0;
		//1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "delete from tb_address where address_id=?";
		//3.����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.����ռλ����ֵ
		ps.setInt(1, address_id);
		
		//5.ִ��sql������Ӱ������
		row = ps.executeUpdate();
		//6.�ͷ���Դ
		ps.close();
		return row;
	}
	
	
	public Address findAddressByAddress_id(Integer address_id) throws Exception{
		 /**
		  * ��ѯ�û�����
		  */
		 Address address = null;
		 //1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "select * from tb_address where address_id=?";
		//3.����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.����ռλ����ֵ
		ps.setInt(1, address_id);
		//5.ִ��sql�����ؽ����
		ResultSet rs = ps.executeQuery();
		//6.���������������ȡ�������������
		if(rs.next()) {
			address = new Address();
			address.setUid(rs.getInt("uid"));
			address.setFull_address(rs.getString("full_address"));
			address.setPhone(rs.getString("phone"));
			address.setZip_code(rs.getString("zip_code"));
			address.setName(rs.getString("name"));
			address.setState(rs.getInt("state"));
		}
		//6.�ͷ���Դ
		rs.close();
		ps.close();
		return address;
	 }
	
	
	public List<Address> findAllAddressList() throws Exception{
		 List<Address> addressList = new ArrayList<Address>();
		//1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "select * from tb_address";
		//3.����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.ִ��sql�����ؽ����
		ResultSet rs = ps.executeQuery();
		//5.ѭ����ȡ�û�������ӵ�������
		while(rs.next()) {
			Address address = new Address();
			address.setUid(rs.getInt("uid"));
			address.setFull_address(rs.getString("full_address"));
			address.setPhone(rs.getString("phone"));
			address.setZip_code(rs.getString("zip_code"));
			address.setName(rs.getString("name"));
			address.setState(rs.getInt("state"));
			
			
			addressList.add(address);
		}
		//6.�ͷ���Դ
		rs.close();
		ps.close();
		return addressList;
	 }
	
	
	public Integer findAddressCount() throws Exception{
		 Integer count = 0;
		//1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "select count(*) from tb_address";
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
	
	
	public List<Address> findAddressByUid(Integer uid) throws Exception{
		List<Address> list = new ArrayList<Address>();
		//1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "select * from tb_address where uid=?";
		//3.����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.����ռλ����ֵ
		ps.setInt(1, uid);
		//5.ִ��sql�����ؽ����
		ResultSet rs = ps.executeQuery();
		//6.���������������ȡ�������������
		while(rs.next()) {
			Address address = new Address();
			address.setUid(rs.getInt("uid"));
			address.setFull_address(rs.getString("full_address"));
			address.setPhone(rs.getString("phone"));
			address.setZip_code(rs.getString("zip_code"));
			address.setName(rs.getString("name"));
			address.setState(rs.getInt("state"));
			list.add(address);
		}
		//6.�ͷ���Դ
		rs.close();
		ps.close();
		return list;
	 }
	
	
	public static void main(String[] args) throws Exception{
//		Address address = new Address();
//		AddressDao addressDao = new AddressDao();
//		address.setUid(1);
//		address.setFull_address("11111");
//		address.setPhone("11111");
//		address.setZip_code("1111");
//		address.setName("11111");
//		address.setState(1);
//		Integer row = addressDao.Add(address);
//		System.out.println(row);
		
//		address.setUid(1);
//		address.setFull_address("11111");
//		address.setPhone("11111");
//		address.setZip_code("1111");
//		address.setName("11111");
//		address.setState(1);
//		address.setAddress_id(4);
//		Integer row = addressDao.Update(address);
//		System.out.println(row);
		
//		Integer row = addressDao.Delete(1);
//		System.out.println(row);
		
//		address = addressDao.findAddressByAddress_id(1);
//		System.out.println(address.getUid());
		
//		List<Address> lu = addressDao.findAllAddressList();
//		System.out.println(lu.size());
		
//		Integer x = addressDao.findAddressCount();
//		System.out.println(x);
	}
}

