package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Commodity;
import com.icss.snacks.util.DbFactory;

/**
 * 
 * @author zly
 *
 */
public class CommodityDao {

	/**
	 * 
	 * @param commodity
	 * @return row
	 * @throws Exception
	 */
	public Integer add(Commodity commodity) throws Exception {
		Integer row = 0;
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL��� ������ "INSERT "
		String sql = "INSERT INTO tb_commodity(category_id, brand_id, cname, promotional_price, original_price, description, img, createtime, param_id) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, commodity.getCategory_id());
		ps.setInt(2, commodity.getBrand_id());
		ps.setString(3, commodity.getCname());
		ps.setDouble(4, commodity.getPromotional_price());
		ps.setDouble(5, commodity.getOriginal_price());
		ps.setString(6, commodity.getDescription());
		ps.setString(7, commodity.getImg());
		ps.setTimestamp(8, commodity.getCreatetime());
		ps.setInt(9, commodity.getParam_id());
		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
		ps.close();
		return row;
	}
	
	/**
	 * 
	 * @param commodity_id
	 * @return row
	 * @throws Exception
	 */
	public Integer delete(Integer commodity_id) throws Exception {
		Integer row = 0;
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "DELETE FROM tb_commodity WHERE commodity_id = ?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, commodity_id);
		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
		ps.close();
		return row;		
	}
	
	
	/**
	 * 
	 * @param commodity
	 * @return row
	 * @throws Exception
	 */
	public Integer update(Commodity commodity) throws Exception {
		Integer row = 0;
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "UPDATE tb_commodity SET category_id = ?, brand_id = ?, cname = ?, promotional_price = ?, original_price = ?, description = ?, img = ?, createtime = ?, param_id = ? WHERE commodity_id = ?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, commodity.getCategory_id());
		ps.setInt(2, commodity.getBrand_id());
		ps.setString(3, commodity.getCname());
		ps.setDouble(4, commodity.getPromotional_price());
		ps.setDouble(5, commodity.getOriginal_price());
		ps.setString(6, commodity.getDescription());
		ps.setString(7, commodity.getImg());
		ps.setTimestamp(8, commodity.getCreatetime());
		ps.setInt(9, commodity.getParam_id());
		ps.setInt(10, commodity.getCommodity_id());

		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
		ps.close();
		return row;
	}
	
	/**
	 * 
	 * @param commodity_id
	 * @return commodity
	 * @throws Exception
	 */
	public Commodity findByCommodityid(Integer commodity_id) throws Exception {
		Commodity commodity = null;
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT * FROM tb_commodity WHERE commodity_id=?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, commodity_id);
		// 5. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 6. ���������������ȡ������������
		if(rs.next()) {
			commodity = new Commodity();
			commodity.setCommodity_id(rs.getInt("commodity_id"));
			commodity.setCategory_id(rs.getInt("category_id"));
			commodity.setBrand_id(rs.getInt("brand_id"));
			commodity.setCname(rs.getString("cname"));
			commodity.setPromotional_price(rs.getDouble("promotional_price"));
			commodity.setOriginal_price(rs.getDouble("original_price"));
			commodity.setDescription(rs.getString("description"));
			commodity.setImg(rs.getString("img"));
			commodity.setCreatetime(rs.getTimestamp("createtime"));
			commodity.setParam_id(rs.getInt("param_id"));
		}
		// 7. �ͷ���Դ
		rs.close();
		ps.close();
		return commodity;
	}
	
	
	/**
	 * 
	 * @return commodityList
	 * @throws Exception
	 */
	public List<Commodity> findAllCommodityList() throws Exception {
		List<Commodity> commodityList = new ArrayList<Commodity>();
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT * FROM tb_commodity";
		// 3. ����ִ��SQL������ӵ�������
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 5. ѭ����ȥ�û�������ӵ�������
		while (rs.next()) {
			Commodity commodity = new Commodity();
			commodity.setCommodity_id(rs.getInt("commodity_id"));
			commodity.setCategory_id(rs.getInt("category_id"));
			commodity.setBrand_id(rs.getInt("brand_id"));
			commodity.setCname(rs.getString("cname"));
			commodity.setPromotional_price(rs.getDouble("promotional_price"));
			commodity.setOriginal_price(rs.getDouble("original_price"));
			commodity.setDescription(rs.getString("description"));
			commodity.setImg(rs.getString("img"));
			commodity.setCreatetime(rs.getTimestamp("createtime"));
			commodity.setParam_id(rs.getInt("param_id"));
			commodityList.add(commodity);
		}
		// 6. �ͷ���Դ
		rs.close();
		ps.close();
		return commodityList;
	}
	
	
	public Integer findCommodityCount() throws Exception {
		Integer count = 0;
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT COUNT(*) FROM tb_commodity";
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
	
	public List<Commodity> findLatestCommodityList() throws Exception {
		List<Commodity> commodityList = new ArrayList<Commodity>();
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT * FROM tb_commodity ORDER BY createtime DESC LIMIT 0, 12";
		// 3. ����ִ��SQL������ӵ�������
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 5. ѭ����ȥ�û�������ӵ�������
		while (rs.next()) {
			Commodity commodity = new Commodity();
			commodity.setCommodity_id(rs.getInt("commodity_id"));
			commodity.setCategory_id(rs.getInt("category_id"));
			commodity.setBrand_id(rs.getInt("brand_id"));
			commodity.setCname(rs.getString("cname"));
			commodity.setPromotional_price(rs.getDouble("promotional_price"));
			commodity.setOriginal_price(rs.getDouble("original_price"));
			commodity.setDescription(rs.getString("description"));
			commodity.setImg(rs.getString("img"));
			commodity.setCreatetime(rs.getTimestamp("createtime"));
			commodityList.add(commodity);
		}
		// 6. �ͷ���Դ
		rs.close();
		ps.close();
		return commodityList;
	}
	
	
	public List<Commodity> findAllCommodityListByPage(Integer currentPage, Integer pageSize) throws Exception {
		List<Commodity> commodityList = new ArrayList<Commodity>();
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT c.*, b. NAME brand_name,	ca. NAME category_name FROM tb_commodity c "
		 		+ "INNER JOIN tb_brand b ON b.brand_id = c.brand_id "
		 		+"INNER JOIN tb_category ca ON ca.category_id = c.category_id limit ?,?";
		// 3. ����ִ��SQL������ӵ�������
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, (currentPage - 1) * pageSize);
		ps.setInt(2, pageSize);
		// 4. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 5. ѭ����ȥ�û�������ӵ�������
		while (rs.next()) {
			Commodity commodity = new Commodity();
			commodity.setCommodity_id(rs.getInt("commodity_id"));
			commodity.setCategory_id(rs.getInt("category_id"));
			commodity.setBrand_id(rs.getInt("brand_id"));
			commodity.setCname(rs.getString("cname"));
			commodity.setPromotional_price(rs.getDouble("promotional_price"));
			commodity.setOriginal_price(rs.getDouble("original_price"));
			commodity.setDescription(rs.getString("description"));
			commodity.setImg(rs.getString("img"));
			commodity.setCreatetime(rs.getTimestamp("createtime"));
			commodity.setBrand_name(rs.getString("brand_name"));
			commodity.setCategory_name(rs.getString("category_name"));
			commodityList.add(commodity);
		}
		// 6. �ͷ���Դ
		rs.close();
		ps.close();
		return commodityList;
	}
	
	
	public static void main (String[] args) throws Exception {
//		Cart cart = new Cart();
//		cart.setFid(12);
//		cart.setCommodity_id(15);
//		cart.setQuantity(134);
//		cart.setUid(1);
//		System.out.println(new CartDao().add(cart));
//		
//		Commodity commodity = new Commodity();
//		commodity.setBrand_id(7);
//		commodity.setCategory_id(3);
//		commodity.setCreatetime(new Timestamp(System.currentTimeMillis()));
//		commodity.setDescription("sdf");
//		commodity.setImg("img");
//		commodity.setOriginal_price(12.0);
//		commodity.setPromotional_price(11.0);
//		commodity.setCname("unknown");
//		CommodityDao commodityDao = new CommodityDao();
//		System.out.println(commodityDao.add(commodity));
//		System.out.println(commodityDao.delete(21));
//		commodity.setCommodity_id(22);
//		commodity.setImg("other");
//		System.out.println(commodityDao.update(commodity));
//		System.out.println(commodityDao.findAllCommodityList());
//		System.out.println(commodityDao.findByCommodityid(1));
//		System.out.println(commodityDao.findLatestCommodityList());
		
	}
}
