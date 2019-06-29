package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Brand;
import com.icss.snacks.util.DbFactory;

/**
 * Ʒ�����ݲ�
 * @author yww
 *
 */
public class BrandDao {
	public Integer Add(Brand brand) throws Exception{
		Integer row=0;
		Connection connection = DbFactory.openConnection();
		String sql = "insert into tb_brand(address,email,name,phone,state) value(?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, brand.getAddress());
		ps.setString(2, brand.getEmail());
		ps.setString(3, brand.getName());
		ps.setString(4, brand.getPhone());
		ps.setString(5, brand.getState());
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	public Integer Update(Brand brand) throws Exception{
		Integer row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "update tb_brand set address = ?,email=?,name=?,phone=?,state=? where brand_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, brand.getAddress());
		ps.setString(2, brand.getEmail());
		ps.setString(3, brand.getName());
		ps.setString(4, brand.getPhone());
		ps.setString(5, brand.getState());
		ps.setInt(6, brand.getBrand_id());
		
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	public Integer Delete(Integer brand_id) throws Exception{
		Integer row = 0;
		//1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "delete from tb_brand where brand_id=?";
		//3.����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.����ռλ����ֵ
		ps.setInt(1, brand_id);
		
		//5.ִ��sql������Ӱ������
		row = ps.executeUpdate();
		//6.�ͷ���Դ
		ps.close();
		return row;
	}
	public Brand findBrandByBrand_id(Integer brand_id) throws Exception{
		 /**
		  * ��ѯ�û�����
		  */
		 Brand brand = null;
		 //1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "select * from tb_brand where brand_id=?";
		//3.����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.����ռλ����ֵ
		ps.setInt(1, brand_id);
		//5.ִ��sql�����ؽ����
		ResultSet rs = ps.executeQuery();
		//6.���������������ȡ�������������
		if(rs.next()) {
			brand = new Brand();
			brand.setAddress(rs.getString("address"));
			brand.setPhone(rs.getString("phone"));
			brand.setEmail(rs.getString("email"));
			brand.setName(rs.getString("name"));
			brand.setState(rs.getString("state"));
		}
		//6.�ͷ���Դ
		rs.close();
		ps.close();
		return brand;
	 }
	public List<Brand> findAllBrandList() throws Exception{
		 List<Brand> brandList = new ArrayList<Brand>();
		//1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "select * from tb_brand";
		//3.����ִ��sql�Ķ���
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.ִ��sql�����ؽ����
		ResultSet rs = ps.executeQuery();
		//5.ѭ����ȡ�û�������ӵ�������
		while(rs.next()) {
			Brand brand = new Brand();
			brand.setAddress(rs.getString("address"));
			brand.setPhone(rs.getString("phone"));
			brand.setEmail(rs.getString("email"));
			brand.setName(rs.getString("name"));
			brand.setState(rs.getString("state"));
			
			
			brandList.add(brand);
		}
		//6.�ͷ���Դ
		rs.close();
		ps.close();
		return brandList;
	 }
	public Integer findBrandCount() throws Exception{
		Integer count = 0;
		//1.�������ݿ�
		Connection connection = DbFactory.openConnection();
		//2.��дsql���  ������
		String sql = "select count(*) from tb_brand";
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
//		Brand brand = new Brand();
//		BrandDao brandDao = new BrandDao();
		
//		brand.setAddress("1111");
//		brand.setPhone("11111");
//		brand.setEmail("11111");
//		brand.setName("111111");
//		brand.setState("1");
//		Integer row = brandDao.Add(brand);
//		System.out.println(row);
		

//		brand.setAddress("aiqing");
//		brand.setPhone("11111");
//		brand.setEmail("11111");
//		brand.setName("111111");
//		brand.setState("1");
//		brand.setBrand_id(11);
//		Integer row = brandDao.Update(brand);
//		System.out.println(row);
		
//		Integer row = brandDao.Delete(11);
//		System.out.println(row);
		
//		brand = brandDao.findBrandByBrand_id(1);
//		System.out.println(brand.getAddress());
		
//		List<Brand> lu = brandDao.findAllBrandList();
//		System.out.println(lu.size());
		
//		int x = brandDao.findBrandCount();
//		System.out.println(x);
	}

}

