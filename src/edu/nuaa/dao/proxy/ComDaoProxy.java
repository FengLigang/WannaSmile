package edu.nuaa.dao.proxy;

import java.util.List;

import edu.nuaa.dao.IComDao;
import edu.nuaa.dao.impl.ComDaoImpl;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.vo.Company;



public class ComDaoProxy implements IComDao{
	private DataBaseConnection dbc = null;
	private ComDaoImpl dao = null;
	
	public ComDaoProxy() throws Exception {
		this.dbc = new DataBaseConnection();
		this.dao = new ComDaoImpl(this.dbc.getConnection());
	}
	
	public boolean doCreate(Company com) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findByName(com.getComName()) == null) {
				flag = this.dao.doCreate(com);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}
	@Override
	public boolean doDelete(Company com) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(com.getComId()) != null) {
				flag = this.dao.doDelete(com);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}
	@Override
	public Company findByName(String comName) throws Exception {
		Company com = null;
		try {
			com = this.dao.findByName(comName);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return com;
	}
	public Company findById(int comId) throws Exception {
		Company com = null;
		try {
			com = this.dao.findById(comId);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return com;
	}
	
	public List<Company> findByKeyword(String keyword) throws Exception {
		List<Company> all = null;
		try {
			all = this.dao.findByKeyword(keyword);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}
	@Override
	public boolean doComUpdate(Company com) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(com.getComId()) != null) {
				flag = this.dao.doComUpdate(com);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	
	

	

}
