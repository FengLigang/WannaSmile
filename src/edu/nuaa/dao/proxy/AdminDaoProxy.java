package edu.nuaa.dao.proxy;

import java.util.List;

import edu.nuaa.dao.IAdmDao;
import edu.nuaa.dao.impl.AdminDaoImpl;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.vo.SkillTable;

public class AdminDaoProxy implements IAdmDao {
    private DataBaseConnection dbc=null;
    private IAdmDao dao=null;
    public AdminDaoProxy() throws Exception{
    	this.dbc=new DataBaseConnection();
    	this.dao=new AdminDaoImpl(this.dbc.getConnection());
    }
	@Override
	public boolean doCreate(SkillTable skilltable) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.doFindById(skilltable.getSkiId())==null){
				flag=this.dao.doCreate(skilltable);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDeleteById(int skiId) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.doFindById(skiId)!=null){
				flag=this.dao.doDeleteById(skiId);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doChangeName(int skiId, String skiName) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.doFindById(skiId)!=null){
				flag=this.dao.doChangeName(skiId, skiName);
				System.out.println("++++++++++++++");
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<SkillTable> doFindAll() throws Exception {
		List<SkillTable> all=null;
		try{
			all=this.dao.doFindAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}
	@Override
	public SkillTable doFindById(int skiId) throws Exception {
		SkillTable skilltable=null;
		try{
			skilltable=this.dao.doFindById(skiId);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return skilltable;
	}
	

}
