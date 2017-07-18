package edu.nuaa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nuaa.dao.IAnnDao;
import edu.nuaa.vo.Announce;


public class AnnDaoImpl implements IAnnDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	
	public AnnDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	/**
	 * 插入的话好像需要有新的东西，旧的东西被覆盖了
	 * */
	public boolean doCreate(Announce ann) throws Exception {
		boolean flag = false;
		String sql = "insert into ann (annId,annTitle,annContent,annTime) values (?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);// 实例化ps对象
		this.ps.setInt(1, ann.getAnnId());
		this.ps.setString(2, ann.getAnnTitle());
		this.ps.setString(3, ann.getAnnContent());
		this.ps.setDate(4, new java.sql.Date(ann.getAnnTime().getTime()));
		if (this.ps.executeUpdate() > 0) {
			flag = true;
		}
		this.ps.close();
		return flag;
	}
		
	@Override
	/**
	 * 删除的话仅仅通过id
	 * */
	public boolean doDelete(int annId) throws Exception {
		boolean flag = false;
		String sql = "delete from ann where annId = ?";
		this.ps = this.conn.prepareStatement(sql);// 实例化ps对象
		this.ps.setInt(1, annId);
		////有点问题啊这里
		if (this.ps.executeUpdate() > 0) {
			flag = true;
		}
		this.ps.close();
		return flag;
	}
	@Override
	/**
	 * 这里是通过查找id来找数据
	 * */
	public Announce doFindByid(int annId) throws Exception {
		Announce ann = null;
		String sql = "select annId,annTitle,annContent,annTime from ann where annId = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, annId);
		java.sql.ResultSet rs =  this.ps.executeQuery();
		if (rs.next()) {
			ann = new Announce();
			ann.setAnnId(rs.getInt(1));
			ann.setAnnTitle(rs.getString(2));
			ann.setAnnContent(rs.getString(3));
			ann.setAnnTime(rs.getDate(4));
		}
		rs.close();
		this.ps.close();
		return ann;
	}
	@Override
	/**
	 * 根据id查找
	 * 这里只能改annTitle,
	 * 
	 * annContent*/
public List<Announce> findByKeyword(String keyword) throws Exception {
		
		List<Announce> all = new ArrayList<Announce>();
		String sql = "select annId,annTitle,annContent,annTime from ann where annId  where annTitle like ? or annContent like ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, "%" + keyword + "%");
		this.ps.setString(2, "%" + keyword + "%");
		ResultSet rs = this.ps.executeQuery();
		Announce ann = null;
		while (rs.next()) {
			ann = new Announce();
			ann = new Announce();
			ann.setAnnId(rs.getInt(1));
			ann.setAnnTitle(rs.getString(2));
			ann.setAnnContent(rs.getString(3));
			ann.setAnnTime(rs.getDate(4));
			all.add(ann);
		}
		rs.close();
		this.ps.close();
		return all;
	}
	
	
	public boolean doChange(Announce ann) throws Exception {
		boolean flag = false;
		String sql = "update ann set annTitle=?,annContent=? where annId=?";
		this.ps = this.conn.prepareStatement(sql);// 实例化ps对象
		this.ps.setInt(3, ann.getAnnId());
		this.ps.setString(1, ann.getAnnTitle());
		this.ps.setString(2, ann.getAnnContent());
		
		if (this.ps.executeUpdate() > 0) {
			flag = true;
		}
		this.ps.close();
		return flag;
	}
	

	
}
