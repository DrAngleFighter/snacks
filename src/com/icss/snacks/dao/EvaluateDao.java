package com.icss.snacks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.icss.snacks.entity.Evaluate;
import com.icss.snacks.util.DbFactory;

/**
 * 
 * @author zly
 *
 */
public class EvaluateDao {

	/**
	 * 
	 * @param evaluate
	 * @return row
	 * @throws Exception
	 */
	public Integer add(Evaluate evaluate) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句 添加语句 "INSERT "
		String sql = "INSERT INTO tb_evaluate(uid, oid, createtime, content) VALUE(?, ?, ?, ?)";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, evaluate.getUid());
		ps.setString(2, evaluate.getOid());
		ps.setTimestamp(3, evaluate.getCreatetime());
		ps.setString(4, evaluate.getContent());
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;
	}
	
	/**
	 * 
	 * @param eid
	 * @return row
	 * @throws Exception
	 */
	public Integer delete(Integer eid) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "DELETE FROM tb_evaluate WHERE eid = ?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, eid);
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;		
	}
	
	/**
	 * 
	 * @param evaluate
	 * @return row
	 * @throws Exception
	 */
	public Integer update(Evaluate evaluate) throws Exception {
		Integer row = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "UPDATE tb_evaluate SET uid = ?, oid = ?, createtime = ?, content = ? WHERE eid = ?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, evaluate.getUid());
		ps.setString(2, evaluate.getOid());
		ps.setTimestamp(3, evaluate.getCreatetime());
		ps.setString(4, evaluate.getContent());
		ps.setInt(5, evaluate.getEid());
		// 5. 执行SQL返回受影响的行数
		row = ps.executeUpdate();
		// 6. 释放资源
		ps.close();
		return row;
	}
	
	
	/**
	 * 
	 * @param evaluate_id
	 * @return evaluate
	 * @throws Exception
	 */
	public Evaluate findByEvaluateid(Integer eid) throws Exception {
		Evaluate evaluate = null;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_evaluate WHERE eid=?";
		// 3. 创建执行SQL对象
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 设置占位符的值
		ps.setInt(1, eid);
		// 5. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 6. 将结果集中数据提取到对象属性中
		if(rs.next()) {
			evaluate = new Evaluate();
			evaluate.setEid(rs.getInt("eid"));
			evaluate.setUid(rs.getInt("uid"));
			evaluate.setOid(rs.getString("oid"));
			evaluate.setCreatetime(rs.getTimestamp("createtime"));
			evaluate.setContent(rs.getString("content"));
		}
		// 7. 释放资源
		rs.close();
		ps.close();
		return evaluate;
	}
	
	
	/**
	 * 
	 * @return evaluateList
	 * @throws Exception
	 */
	public List<Evaluate> findAll() throws Exception {
		List<Evaluate> evaluateList = new ArrayList<Evaluate>();
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT * FROM tb_evaluate";
		// 3. 创建执行SQL对象，添加到集合中
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 5. 循环后去用户对象，添加到集合中
		while (rs.next()) {
			Evaluate evaluate = new Evaluate();
			evaluate.setEid(rs.getInt("eid"));
			evaluate.setUid(rs.getInt("uid"));
			evaluate.setOid(rs.getString("oid"));
			evaluate.setCreatetime(rs.getTimestamp("createtime"));
			evaluate.setContent(rs.getString("content"));
			evaluateList.add(evaluate);
		}
		// 6. 释放资源
		rs.close();
		ps.close();
		return evaluateList;
	}
	
	
	/**
	 * 
	 * @return count
	 * @throws Exception
	 */
	public Integer findCount() throws Exception {
		Integer count = 0;
		// 1. 连接数据库
		Connection connection = DbFactory.openConnection();
		// 2. 编写SQL语句
		String sql = "SELECT COUNT(*) FROM tb_evaluate";
		// 3. 创建执行SQL对象，添加到集合中
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. 执行SQL，返回结果集
		ResultSet rs = ps.executeQuery();
		// 5. 循环后去用户对象，添加到集合中
		if (rs.next()) {
			count = rs.getInt(1);
		}
		// 6. 释放资源
		rs.close();
		ps.close();
		return count;
	}
	
	
	public static void main (String[] args) throws Exception {
		
		Evaluate evaluate = new Evaluate();
		evaluate.setContent("test");
		evaluate.setCreatetime(new Timestamp(System.currentTimeMillis()));
		evaluate.setOid("9a4aaf2e-d6a0-456b-b367-60750c52cf23");
		evaluate.setUid(1);
		
		EvaluateDao evaluateDao = new EvaluateDao();
//		System.out.println(evaluateDao.add(evaluate));
//		System.out.println(evaluateDao.delete(1));
//		evaluate = evaluateDao.findByEvaluateid(2);
//		System.out.println(evaluate);
//		evaluate.setEid(2);
//		evaluate.setContent("update");
//		System.out.println(evaluate);
//		System.out.println(evaluateDao.update(evaluate));
		System.out.println(evaluateDao.findAll());
		System.out.println(evaluateDao.findByEvaluateid(2));
		System.out.println(evaluateDao.findCount());
		
	}
}
