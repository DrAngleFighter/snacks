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
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL��� ������ "INSERT "
		String sql = "INSERT INTO tb_evaluate(uid, oid, createtime, content) VALUE(?, ?, ?, ?)";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, evaluate.getUid());
		ps.setString(2, evaluate.getOid());
		ps.setTimestamp(3, evaluate.getCreatetime());
		ps.setString(4, evaluate.getContent());
		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
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
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "DELETE FROM tb_evaluate WHERE eid = ?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, eid);
		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
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
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "UPDATE tb_evaluate SET uid = ?, oid = ?, createtime = ?, content = ? WHERE eid = ?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, evaluate.getUid());
		ps.setString(2, evaluate.getOid());
		ps.setTimestamp(3, evaluate.getCreatetime());
		ps.setString(4, evaluate.getContent());
		ps.setInt(5, evaluate.getEid());
		// 5. ִ��SQL������Ӱ�������
		row = ps.executeUpdate();
		// 6. �ͷ���Դ
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
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT * FROM tb_evaluate WHERE eid=?";
		// 3. ����ִ��SQL����
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ����ռλ����ֵ
		ps.setInt(1, eid);
		// 5. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 6. ���������������ȡ������������
		if(rs.next()) {
			evaluate = new Evaluate();
			evaluate.setEid(rs.getInt("eid"));
			evaluate.setUid(rs.getInt("uid"));
			evaluate.setOid(rs.getString("oid"));
			evaluate.setCreatetime(rs.getTimestamp("createtime"));
			evaluate.setContent(rs.getString("content"));
		}
		// 7. �ͷ���Դ
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
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT * FROM tb_evaluate";
		// 3. ����ִ��SQL������ӵ�������
		PreparedStatement ps = connection.prepareStatement(sql);
		// 4. ִ��SQL�����ؽ����
		ResultSet rs = ps.executeQuery();
		// 5. ѭ����ȥ�û�������ӵ�������
		while (rs.next()) {
			Evaluate evaluate = new Evaluate();
			evaluate.setEid(rs.getInt("eid"));
			evaluate.setUid(rs.getInt("uid"));
			evaluate.setOid(rs.getString("oid"));
			evaluate.setCreatetime(rs.getTimestamp("createtime"));
			evaluate.setContent(rs.getString("content"));
			evaluateList.add(evaluate);
		}
		// 6. �ͷ���Դ
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
		// 1. �������ݿ�
		Connection connection = DbFactory.openConnection();
		// 2. ��дSQL���
		String sql = "SELECT COUNT(*) FROM tb_evaluate";
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
