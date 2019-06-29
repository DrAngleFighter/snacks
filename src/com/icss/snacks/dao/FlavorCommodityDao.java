package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.FlavorCommodity;
import com.icss.snacks.util.DbFactory;

/**
 * 
 * @author phr
 *
 */
public class FlavorCommodityDao {

	public int addfc(FlavorCommodity flavor_commodity) throws Exception{
		int row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "insert into tb_flavor_commodity(fid,commodity_id,stock) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setInt(1, flavor_commodity.getFid());
        ps.setInt(2, flavor_commodity.getCommodity_id());
        ps.setInt(3, flavor_commodity.getStock());
        row = ps.executeUpdate();
        ps.close();
		return row;}
		
	public int deletefc(FlavorCommodity flavor_commodity) throws Exception{
		int row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "delete from tb_flavor_commodity where id=?";
	    PreparedStatement ps = connection.prepareStatement(sql)	;
	    ps.setInt(1, flavor_commodity.getId());
	    row = ps.executeUpdate();
	    ps.close();		
	    return row;
		}
		
	public int updatefc(FlavorCommodity flavor_commodity) throws Exception{
		int row = 0;
		Connection connection = DbFactory.openConnection();
		String sql = "update tb_flavor_commodity set fid=?,commodity_id=?,stock=? where id=?";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setInt(1, flavor_commodity.getFid());
        ps.setInt(2, flavor_commodity.getCommodity_id());
        ps.setInt(3, flavor_commodity.getStock());
        ps.setInt(4, flavor_commodity.getId());
        row = ps.executeUpdate();
        ps.close();
		return row;
	}
		
	public FlavorCommodity findflavor_commodityById(int oid) throws Exception{
		FlavorCommodity flavor_commodity = null;
		Connection connection = DbFactory.openConnection();
		String sql = "select * from tb_flavor_commodity where oid=?";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ps.setInt(1, oid);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
        	flavor_commodity = new FlavorCommodity();
        	flavor_commodity.setId(rs.getInt("id"));
        	flavor_commodity.setFid(rs.getInt("fid"));
        	flavor_commodity.setCommodity_id(rs.getInt("commodity_id"));
        	flavor_commodity.setStock(rs.getInt("stock"));

        }
        ps.close();		
        rs.close();	
        return flavor_commodity;
		}
		

	public List<FlavorCommodity> findAllList() throws Exception{
		List<FlavorCommodity> flavor_commodityList =new ArrayList<FlavorCommodity>();
		Connection connection = DbFactory.openConnection();
		String sql = "select * from tb_flavor_commodity";
        PreparedStatement ps = connection.prepareStatement(sql)	;
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
        	FlavorCommodity flavor_commodity = new FlavorCommodity();
        	flavor_commodity.setId(rs.getInt("id"));
        	flavor_commodity.setFid(rs.getInt("fid"));
        	flavor_commodity.setCommodity_id(rs.getInt("commodity_id"));
        	flavor_commodity.setStock(rs.getInt("stock"));
        	flavor_commodityList.add(flavor_commodity);
        }
        ps.close();		
        rs.close();		
		return flavor_commodityList;
	}
	

	
}
