package edu.nuaa.dao;

import java.util.List;

import edu.nuaa.vo.Company;
import edu.nuaa.vo.Job;



public interface IComDao {
	
	public boolean doCreate(Company com) throws Exception;//用公司名字判断数据库中是否存在该记录
	
	
	
	public boolean doDelete(Company com) throws Exception;
	
	

	public Company findByName(String comName) throws Exception;
	
	
	
	public Company findById(int comId) throws Exception;
	
	
	
	public List<Company> findByKeyword(String keyword) throws Exception;
	
	
	
	public boolean doComUpdate(Company com)throws Exception;
	
	
	
	public boolean doAddJob(int comId,Job job)throws Exception;
	
	
	
	public List<Integer> doFindJob(int comId)throws Exception;
	
	
	
	public boolean doDeleteJob(int comId,int jobId) throws Exception;
	
	
	
	
	
	
	
	
	

}
