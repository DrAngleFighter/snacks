package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.CommodityParam;
import com.icss.snacks.util.DbFactory;
/**
 * 商品参数表数据层
 * @author yww
 *
 */
public class CommodityParamDao {
	public int add(CommodityParam CommodityParam) throws Exception{
		int row=0;
		Connection connection = DbFactory.openConnection();
		String sql = "insert into tb_commodity_param(`type`,product_area,product_place,product_specification,expiration_date,`usage`,`storage _method`,`standard_ number`,`license_ number`, ingredients) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, CommodityParam.getType());
		ps.setString(2, CommodityParam.getProduct_area());
		ps.setString(3, CommodityParam.getProduct_place());
		ps.setString(4, CommodityParam.getProduct_specification());
		ps.setString(5, CommodityParam.getExpiration_date());
		ps.setString(6, CommodityParam.getUsage());
		ps.setString(7, CommodityParam.getStorage_method());
		ps.setString(8, CommodityParam.getStandard_number());
		ps.setString(9, CommodityParam.getLicense_number());
		ps.setString(10, CommodityParam.getIngredients());
		
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	public int Update(CommodityParam CommodityParam) throws Exception{
		int row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "update tb_commodity_param set type = ?,product_area=?,product_place=?,product_specification=?,expiration_date=?,`usage`=?,`storage _method`=?,`standard_ number`=?,`license_ number`=?, ingredients=? where param_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, CommodityParam.getType());
		ps.setString(2, CommodityParam.getProduct_area());
		ps.setString(3, CommodityParam.getProduct_place());
		ps.setString(4, CommodityParam.getProduct_specification());
		ps.setString(5, CommodityParam.getExpiration_date());
		ps.setString(6, CommodityParam.getUsage());
		ps.setString(7, CommodityParam.getStorage_method());
		ps.setString(8, CommodityParam.getStandard_number());
		ps.setString(9, CommodityParam.getLicense_number());
		ps.setString(10, CommodityParam.getIngredients());
		ps.setInt(11, CommodityParam.getParam_id());

		
		row = ps.executeUpdate();
		ps.close();
		return row;
	}
	public int Delete(int CommodityParam_id) throws Exception{
		int row = 0;
		//1.连接数据库
		Connection connection = DbFactory.openConnection();
		//2.编写sql语句  添加语句
		String sql = "delete from tb_commodity_param where param_id=?";
		//3.创建执行sql的对象
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.设置占位符的值
		ps.setInt(1, CommodityParam_id);
		
		//5.执行sql返回受影响行数
		row = ps.executeUpdate();
		//6.释放资源
		ps.close();
		return row;
	}
	public CommodityParam findCommodityParamByCommodityParam_id(int CommodityParam_id) throws Exception{
		 /**
		  * 查询用户详情
		  */
		 CommodityParam CommodityParam = null;
		 //1.连接数据库
		Connection connection = DbFactory.openConnection();
		//2.编写sql语句  添加语句
		String sql = "select * from tb_commodity_param where param_id=?";
		//3.创建执行sql的对象
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.设置占位符的值
		ps.setInt(1, CommodityParam_id);
		//5.执行sql，返回结果集
		ResultSet rs = ps.executeQuery();
		//6.将结果集中数据提取到对象的属性中
		if(rs.next()) {
			CommodityParam = new CommodityParam();
			CommodityParam.setType(rs.getString("type"));
			CommodityParam.setProduct_area(rs.getString("product_area"));
			CommodityParam.setProduct_place(rs.getString("product_place"));
			CommodityParam.setProduct_specification(rs.getString("product_specification"));
			CommodityParam.setExpiration_date(rs.getString("expiration_date"));
			CommodityParam.setUsage(rs.getString("usage"));
			CommodityParam.setStorage_method(rs.getString("storage _method"));
			CommodityParam.setStandard_number(rs.getString("standard_ number"));
			CommodityParam.setLicense_number(rs.getString("license_ number"));
			CommodityParam.setIngredients(rs.getString("ingredients"));
		}
		//6.释放资源
		rs.close();
		ps.close();
		return CommodityParam;
	 }
	public List<CommodityParam> findAllCommodityParamList() throws Exception{
		 List<CommodityParam> CommodityParamList = new ArrayList<CommodityParam>();
		//1.连接数据库
		Connection connection = DbFactory.openConnection();
		//2.编写sql语句  添加语句
		String sql = "select * from tb_commodity_param";
		//3.创建执行sql的对象
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.执行sql，返回结果集
		ResultSet rs = ps.executeQuery();
		//5.循环获取用户对象，添加到集合中
		while(rs.next()) {
			CommodityParam CommodityParam = new CommodityParam();
			CommodityParam = new CommodityParam();
			CommodityParam.setType(rs.getString("type"));
			CommodityParam.setProduct_area(rs.getString("product_area"));
			CommodityParam.setProduct_place(rs.getString("product_place"));
			CommodityParam.setProduct_specification(rs.getString("product_specification"));
			CommodityParam.setExpiration_date(rs.getString("expiration_date"));
			CommodityParam.setUsage(rs.getString("usage"));
			CommodityParam.setStorage_method(rs.getString("storage _method"));
			CommodityParam.setStandard_number(rs.getString("standard_ number"));
			CommodityParam.setLicense_number(rs.getString("license_ number"));
			CommodityParam.setIngredients(rs.getString("ingredients"));
			CommodityParamList.add(CommodityParam);
		}
		//6.释放资源
		rs.close();
		ps.close();
		return CommodityParamList;
	 }
	public int findCommodityParamCount() throws Exception{
		 int count = 0;
		//1.连接数据库
		Connection connection = DbFactory.openConnection();
		//2.编写sql语句  添加语句
		String sql = "select count(*) from tb_commodity_param";
		//3.创建执行sql的对象
		PreparedStatement ps = connection.prepareStatement(sql);
		//4.执行sql，返回结果集
		ResultSet rs = ps.executeQuery();
		//5.从集合中提取数据
		if(rs.next()) {
			count = rs.getInt(1);
		}
		//6.释放资源
		rs.close();
		ps.close();
		return count;
	 }
	public static void main(String[] args) throws Exception{
		CommodityParam CommodityParam = new CommodityParam();
		CommodityParamDao CommodityParamDao = new CommodityParamDao();
		CommodityParam.setType("type");
		CommodityParam.setProduct_area("product_area");
		CommodityParam.setProduct_place("product_place");
		CommodityParam.setProduct_specification("product_specification");
		CommodityParam.setExpiration_date("expiration");
		CommodityParam.setUsage("usage");
		CommodityParam.setStorage_method("storage_method");
		CommodityParam.setStandard_number("standard_number");
		CommodityParam.setLicense_number("license_number");
		CommodityParam.setIngredients("原材料");
		int row = CommodityParamDao.add(CommodityParam);
		System.out.println(row);
		
//
//		CommodityParam.setType("type");
//		CommodityParam.setProduct_area("product_area");
//		CommodityParam.setProduct_place("product_place");
//		CommodityParam.setProduct_specification("product_specification");
//		CommodityParam.setExpiration_date("expiration");
//		CommodityParam.setUsage("usage");
//		CommodityParam.setStorage_method("storage_method");
//		CommodityParam.setStandard_number("standard_number");
//		CommodityParam.setLicense_number("license_number");
//		CommodityParam.setParam_id(4);
//		int row = CommodityParamDao.Update(CommodityParam);
//		System.out.println(row);
		
//		int row = CommodityParamDao.Delete(1);
//		System.out.println(row);
		
//		CommodityParam = CommodityParamDao.findCommodityParamByCommodityParam_id(4);
//		System.out.println(CommodityParam.getLicense_number());
		
//		List<CommodityParam> lu = CommodityParamDao.findAllCommodityParamList();
//		System.out.println(lu.size());
		
//		int x = CommodityParamDao.findCommodityParamCount();
//		System.out.println(x);
	}


}

