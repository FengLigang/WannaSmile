package edu.nuaa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nuaa.dao.IComDao;
import edu.nuaa.vo.Company;



public class ComDaoImpl implements IComDao {
	
	private Connection conn = null;// 数据库连接对象
	private PreparedStatement ps = null;// 数据库操作对象

	public ComDaoImpl(Connection conn) {// 通过构造方法来取得数据库连接
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Company com) throws Exception {
		boolean flag = false;
		String sql = "insert into com (comId,comTel,comName,comPsw,comAddr,comPerson,comEmail,comJob) values (?,?,?,?,?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);// 实例化ps对象
		this.ps.setInt(1, com.getComId());
		this.ps.setInt(2, com.getComTel());
		this.ps.setString(3, com.getComName());
		this.ps.setString(4, com.getComPsw());
		this.ps.setString(5, com.getComAddr());
		this.ps.setString(6, com.getComPerson());
		this.ps.setString(7, com.getComEmail());
		this.ps.setString(8, com.getComJob());
		if (this.ps.executeUpdate() > 0) 
		{
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	public boolean doDelete(Company com) throws Exception {
		boolean flag = false;
		String sql = "delete from com where comId = ? ";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, com.getComId());
		if(this.ps.executeUpdate() > 0)
		{
			flag = true;
		}
		this.ps.close();
		
		return flag;
	}

	@Override
	public Company findByName(String comName) throws Exception {
		Company com = null;
		String sql = "select comId,comTel,comName,comPsw,comAddr,comPerson,comEmail,comJob from com where comName = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, comName);
		ResultSet rs = this.ps.executeQuery();
		if (rs.next()) {
			com = new Company();
			com.setComId(rs.getInt(1));
			com.setComTel(rs.getInt(2));
			com.setComName(rs.getString(3));
			com.setComPsw(rs.getString(4));
			com.setComAddr(rs.getString(5));
			com.setComPerson(rs.getString(6));
			com.setComEmail(rs.getString(7));
			com.setComJob(rs.getString(8));
		}
		rs.close();
		this.ps.close();
		return com;
		
	}
	public Company findById(int comId) throws Exception {
		Company com = null;
		String sql = "select comId,comTel,comName,comPsw,comAddr,comPerson,comEmail,comJob from com where comId = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, comId);
		ResultSet rs = this.ps.executeQuery();
		if (rs.next()) {
			com = new Company();
			com.setComId(rs.getInt(1));
			com.setComTel(rs.getInt(2));
			com.setComName(rs.getString(3));
			com.setComPsw(rs.getString(4));
			com.setComAddr(rs.getString(5));
			com.setComPerson(rs.getString(6));
			com.setComEmail(rs.getString(7));
			com.setComJob(rs.getString(8));
		}
		rs.close();
		this.ps.close();
		return com;
	}
	public List<Company> findByKeyword(String keyword) throws Exception {
		List<Company> all = new ArrayList<Company>();
		String sql = "select comId,comTel,comName,comAddr,comPerson,comEmail,comJob from com where comId like ? or comJob like ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, Integer.parseInt(keyword));
		this.ps.setString(2,keyword);
		ResultSet rs = this.ps.executeQuery();
		Company com = null;
		while (rs.next()) {
			com = new Company();
			com.setComId(rs.getInt(1));
			com.setComTel(rs.getInt(2));
			com.setComName(rs.getString(3));
			com.setComAddr(rs.getString(4));
			com.setComPerson(rs.getString(5));
			com.setComEmail(rs.getString(6));
			com.setComJob(rs.getString(7));
			all.add(com);
		}
	    rs.close();
		this.ps.close();
		return all;
	}

	@Override
	public boolean doComUpdate(Company com) throws Exception {
		boolean flag = false;
		String sql = "Update com set comName= ? ,comTel = ? ,comPsw = ? ,comAddr = ?, comPerson = ?, comEmail = ? ,comJob = ? where comId = ?";
		this.ps = this.conn.prepareStatement(sql);// 实例化ps对象
		if(com.getComName()==null){
			this.ps.setString(1, " ");
		}
		else{
			this.ps.setString(1, com.getComName());
		}
		
		this.ps.setInt(2, com.getComTel());
		
		if(com.getComPsw()==null){
			this.ps.setString(3, " ");
		}
		else{
			this.ps.setString(3, com.getComPsw());
		}
		if(com.getComAddr()==null){
			this.ps.setString(4, " ");
		}
		else{
			this.ps.setString(4, com.getComAddr());
		}
		if(com.getComPerson()==null){
			this.ps.setString(5, " ");
		}
		else{
			this.ps.setString(5, com.getComPerson());
		}
		if(com.getComEmail()==null){
			this.ps.setString(6, " ");
		}
		else{
			this.ps.setString(6, com.getComEmail());
		}
		if(com.getComJob()==null){
			this.ps.setString(7, " ");
		}
		else{
			this.ps.setString(7, com.getComJob());
		}
		this.ps.setInt(8, com.getComId());
		if (this.ps.executeUpdate() > 0) 
		{
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	
	//public boolean doAddJob(int comId, String comJob) throws Exception {
		//boolean flag = false;
		// com = new Company();
		//com = findById(comId);
		
		
		//return flag;
	//}


	

}
