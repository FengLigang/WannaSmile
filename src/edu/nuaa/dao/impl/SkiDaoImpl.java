package edu.nuaa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.nuaa.dao.ISkiDao;
import edu.nuaa.vo.SkillTable;

public class SkiDaoImpl implements ISkiDao {

	private Connection conn = null;			// 数据库连接对象
	private PreparedStatement ps = null;	// 数据库操作对象
	
	public SkiDaoImpl(Connection conn) {	// 通过构造方法来取得数据库连接
			this.conn = conn;
	}
	
	@Override
	public boolean doCreate(SkillTable skilltable) throws Exception{
		
		boolean flag = false;
			
		String sql = "insert into skill (skiId, skiName) values (?, ?)";
		this.ps = this.conn.prepareStatement(sql);// 实例化ps对象
		this.ps.setInt(1, skilltable.getSkiId());
		this.ps.setString(2, skilltable.getSkiName());
		
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		
		this.ps.close();
		return flag;
	}
		
	@Override
	public boolean doDeleteById(int skiId) throws Exception{
		
		boolean flag = false;
		
		String sql = "delete from skill where skiId = ?";
		this.ps = this.conn.prepareStatement(sql);//实例化ps对象
		this.ps.setInt(1, skiId);
		
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		
		this.ps.close();
		return flag;
	}
	
	@Override
	public boolean doChangeName(int id, String name) throws Exception{
		
		boolean flag = false;
		
		String sql = "update skill set skiName =? where skiId =?";
		this.ps =this.conn.prepareStatement(sql);
		this.ps.setString(1, name);
		this.ps.setInt(2, id);
		
		if(this.ps.executeUpdate() > 0){
			
			flag = true;
		}
		
		this.ps.close();
		return flag;
	}
	
	@Override
	public SkillTable doFindById(int skiId) throws Exception{
		
		SkillTable skilltable = null;
		
		String sql = "select skiId, skiName from skill where skiId = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, skiId);
		ResultSet rs = this.ps.executeQuery();
		
		if (rs.next()) {
			skilltable = new SkillTable();
			skilltable.setSkiId(rs.getInt(1));
			skilltable.setSkiName(rs.getString(2));
		}
		
		rs.close();
		this.ps.close();
		return skilltable;
	}
}