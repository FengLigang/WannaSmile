package edu.nuaa.dao.proxy;

import java.util.List;

import edu.nuaa.dao.IAnnDao;
import edu.nuaa.dao.impl.AnnDaoImpl;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.vo.Announce;

public class AnnDaoProxy implements IAnnDao {
	
	private DataBaseConnection dbc = null;
	
	private IAnnDao dao = null;
	
	public AnnDaoProxy(){
		try{
			this.dbc = new DataBaseConnection();
			}catch(Exception e){
				e.printStackTrace();
			}
			dao = new AnnDaoImpl(this.dbc.getConnection()); 
		}

	@Override
	public boolean doCreate(Announce ann) throws Exception {
		boolean flag = false;
		try{
		flag = this.dao.doCreate(ann);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int annId) throws Exception {
		boolean flag = false;
		try{
		flag = this.dao.doDelete(annId);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public Announce doFindByid(int annId) throws Exception {
		Announce ann= null;
		try{
			ann=this.dao.doFindByid(annId);
			}catch(Exception e){
				throw e;
			}finally{
				this.dbc.close();
			}
		return ann;
	}

	public List<Announce> findByKeyword(String keyword) throws Exception {
		List<Announce> all = null;
		try{
			all = this.dao.findByKeyword(keyword);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return all;
	}
	
	@Override
	public boolean doChange(Announce ann) throws Exception {
		boolean flag = false;
		try{
		flag = this.dao.doChange(ann);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	

	
}