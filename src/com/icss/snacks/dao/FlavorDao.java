package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Flavor;
import com.icss.snacks.util.DbFactory;

/**
 * 
 * @author zly
 *
 */
public class FlavorDao {

	/**
	 * 
	 * @param flavor
	 * @return row
	 * @throws Exception
	 */
	public Integer add(Flavor flavor) throws Exception {
		Integer row = 0;
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL��� ������ "INSERT "
		String sql = "INSERT INTO tb_flavor(fname) VALUE(?)";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setString(1, flavor.getFname());
		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
		ps.close();
		return row;
	}
	
	/**
	 * 
	 * @param fid
	 * @return row
	 * @throws Exception
	 */
	public Integer delete(Integer fid) throws Exception {
		Integer row = 0;
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "DELETE FROM tb_flavor WHERE fid = ?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, fid);
		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
		ps.close();
		return row;		
	}
	
	
	/**
	 * 
	 * @param flavor
	 * @return row
	 * @throws Exception
	 */
	public Integer update(Flavor flavor) throws Exception {
		Integer row = 0;
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "UPDATE tb_flavor SET fname = ? WHERE fid = ?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setString(1, flavor.getFname());
		ps.setInt(2, flavor.getFid());
		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
		ps.close();
		return row;
	}
	
	
	/**
	 * 
	 * @param fid
	 * @return flavor
	 * @throws Exception
	 */
	public Flavor findByFlavorid(Integer fid) throws Exception {
		Flavor flavor = null;
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT * FROM tb_flavor WHERE fid=?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, fid);
		// 5. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 6. ���������������ȡ������������
		if(rs.next()) {
			flavor = new Flavor();
			flavor.setFid(rs.getInt("fid"));
			flavor.setFname(rs.getString("fname"));
		}
		// 7. �ͷ���Դ
		rs.close();
		ps.close();
		return flavor;
	}
	
	/**
	 * 
	 * @return flavorList
	 * @throws Exception
	 */
	public List<Flavor> findAll() throws Exception {
		List<Flavor> flavorList = new ArrayList<Flavor>();
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT * FROM tb_flavor";
		// 3. ����ִ��SQL������ӵ�������
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 5. ѭ����ȥ�û�������ӵ�������
		while (rs.next()) {
			Flavor flavor = new Flavor();
			flavor.setFid(rs.getInt("fid"));
			flavor.setFname(rs.getString("fname"));
			flavorList.add(flavor);
		}
		// 6. �ͷ���Դ
		rs.close();
		ps.close();
		return flavorList;
	}
	
	/**
	 * 
	 * @return count
	 * @throws Exception
	 */
	public Integer findCount() throws Exception {
		Integer count = 0;
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT COUNT(*) FROM tb_flavor";
		// 3. ����ִ��SQL������ӵ�������
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 5. ѭ����ȥ�û�������ӵ�������
		if (rs.next()) {
			count = rs.getInt(1);
		}
		// 6. �ͷ���Դ
		rs.close();
		ps.close();
		return count;
	}
	

	public List<Flavor> findFlavorListByCid(int cid) throws Exception {
		List<Flavor> flavorList = new ArrayList<Flavor>();
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT * FROM tb_flavor INNER JOIN tb_flavor_commodity ON tb_flavor.fid = tb_flavor_commodity.fid AND tb_flavor_commodity.commodity_id=?";
		// 3. ����ִ��SQL������ӵ�������
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, cid);
		// 4. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 5. ѭ����ȥ�û�������ӵ�������
		while (rs.next()) {
			Flavor flavor = new Flavor();
			flavor.setFid(rs.getInt("fid"));
			flavor.setFname(rs.getString("fname"));
			flavorList.add(flavor);
		}
		// 6. �ͷ���Դ
		rs.close();
		ps.close();
		return flavorList;
	}
	
public static void main (String[] args) throws Exception {
		
		Flavor flavor = new Flavor();
		flavor.setFname("��");
		
		
		FlavorDao flavorDao = new FlavorDao();
//		System.out.println(flavorDao.add(flavor));
//		System.out.println(flavorDao.delete(16));
//		flavor = flavorDao.findByFlavorid(2);
//		System.out.println(flavor);
		flavor.setFid(15);
		flavor.setFname("update");
//		System.out.println(flavor);
		System.out.println(flavorDao.update(flavor));
//		System.out.println(flavorDao.findAll());
//		System.out.println(flavorDao.findByFlavorid(2));
//		System.out.println(flavorDao.findCount());
		
	}
	
}
