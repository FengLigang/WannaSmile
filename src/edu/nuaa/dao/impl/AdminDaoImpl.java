package edu.nuaa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nuaa.dao.IAdmDao;
import edu.nuaa.vo.SkillTable;

public class AdminDaoImpl implements IAdmDao{
      private Connection conn=null;
      private PreparedStatement ps=null;
      public AdminDaoImpl(Connection conn){
    	  this.conn=conn;
      }
	@Override
	public boolean doCreate(SkillTable skilltable) throws Exception {
		boolean flag=false;
		String sql="insert into skill(skiId,skiName) values (?,?)";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setInt(1,skilltable.getSkiId());
		this.ps.setString(2,skilltable.getSkiName());
		if(this.ps.executeUpdate()>0){
			flag=true;
		}
		this.ps.close();
		return flag;
	}
	@Override
	public boolean doDeleteById(int skiId) throws Exception {
		boolean flag=false;
		String sql="delete from skill where skiId=?";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setInt(1,skiId);
		if(this.ps.executeUpdate()>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean doChangeName(int skiId, String skiName) throws Exception {
		boolean flag=false;
		String sql="update skill set skiName=? where skiId=?";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setString(1,skiName);
		this.ps.setInt(2,skiId);
		if(this.ps.executeUpdate()>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public List<SkillTable> doFindAll() throws Exception {
		String sql="select skiId,skiName from skill";
		this.ps=this.conn.prepareStatement(sql);
		ResultSet rs=this.ps.executeQuery();
		List<SkillTable> all=new ArrayList<SkillTable>();
		SkillTable ski=null;
		while(rs.next()){
			ski=new SkillTable();
			ski.setSkiId(rs.getInt(1));
			ski.setSkiName(rs.getString(2));
			all.add(ski);
		}
		return all;
	}
	@Override
	public SkillTable doFindById(int skiId) throws Exception {
		SkillTable skilltable=null;
		String sql="select skiId,skiName from skill where skiId=?";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setInt(1,skiId);
		ResultSet rs=this.ps.executeQuery();
		if(rs.next()){
			skilltable=new SkillTable();
			skilltable.setSkiId(rs.getInt(1));
			skilltable.setSkiName(rs.getString(2));
		}
		rs.close();
		this.ps.close();
		return skilltable;
	}

      
}
