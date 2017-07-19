package edu.nuaa.dao.proxy;

import java.util.List;

import edu.nuaa.dao.IResumeDao;
import edu.nuaa.dao.impl.ResumeDaoImpl;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.vo.Resume;

public class ResumeDaoProxy implements IResumeDao{

	private DataBaseConnection dbc = null;
	private IResumeDao dao = null;
	
	public ResumeDaoProxy() throws Exception{
		this.dbc = new DataBaseConnection();
		this.dao = new ResumeDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Resume resume) throws Exception {
		boolean flag = false;
		try{
			 if(this.dao.findById(resume.getStuId()) == null){
				 flag = this.dao.doCreate(resume);
			 }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(Resume resume) throws Exception {
		boolean flag = false;
		try{
			if(this.dao.findById(resume.getStuId()) != null){
				//不为空即数据库中有该数据
				flag = this.dao.doDelete(resume);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean changeAll(Resume resume) throws Exception {
		boolean flag = false;
		try{
			if(this.dao.findById(resume.getStuId()) != null){
				//不为空即数据库中有该数据
				flag = this.dao.changeAll(resume);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Resume> findByKeyword(String keyword) throws Exception {
		List<Resume> all = null;
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
	public Resume findById(int stuId) throws Exception {
		Resume resume = null;
		try{
			resume = this.dao.findById(stuId);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return resume;
	}
	@Override
	public boolean setSkillLab(Resume resume) throws Exception {
		
		return false;
	}

}
