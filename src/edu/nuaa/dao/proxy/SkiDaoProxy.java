package edu.nuaa.dao.proxy;

import edu.nuaa.dao.ISkiDao;
import edu.nuaa.vo.SkillTable;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.dao.impl.SkiDaoImpl;


public class SkiDaoProxy implements ISkiDao{

	private DataBaseConnection dbc = null;
	
	private ISkiDao dao = null;
	
	public SkiDaoProxy() throws Exception {
		this.dbc = new DataBaseConnection();
		this.dao = new SkiDaoImpl(this.dbc.getConnection());
		
	}
	
	@Override
	public boolean doCreate(SkillTable skilltable) throws Exception{
		
		boolean flag = false;
		
		try{
			if(this.dao.doFindById(skilltable.getSkiId()) == null) {
				flag = this.dao.doCreate(skilltable);
			}
		} catch (Exception e){
			throw e;
		} finally {
			this.dbc.close();
		}
		
		return flag;
	}
	
	@Override
	public boolean doDeleteById(int skiId) throws Exception{
		
		boolean flag = false;
		
		try{
			if(this.dao.doFindById(skiId) != null){
				flag = this.dao.doDeleteById(skiId);
			}
		} catch (Exception e){
			throw e;
		} finally {
			this.dbc.close();
		}
		
		return flag;
	}
	
	@Override
	public boolean doChangeName(int skiId, String skiName) throws Exception{
		
		boolean flag = false;
		try{
			if(this.dao.doFindById(skiId) != null){
				flag = this.dao.doChangeName(skiId, skiName);
				System.out.println("++++++++++++++++++++++");
			}
		} catch (Exception e){
			throw e;
		} finally {
			this.dbc.close();
		}
		
		return flag;
	}
	
	@Override
	public SkillTable doFindById(int skiId) throws Exception{
		
		SkillTable skilltable = null;
		
		try{
			skilltable = this.dao.doFindById(skiId);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbc.close();
		}
	
		return skilltable;
	}
}
