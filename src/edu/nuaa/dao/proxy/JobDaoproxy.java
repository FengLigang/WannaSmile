package edu.nuaa.dao.proxy;

import java.util.List;

import edu.nuaa.dao.JobDao;
import edu.nuaa.dao.impl.JobDaoImpl;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.vo.Job;


public class JobDaoproxy implements JobDao {

	private DataBaseConnection dbc = null;
	private JobDao dao = null;

	public JobDaoproxy() throws Exception {
		this.dbc = new DataBaseConnection();
		this.dao = new JobDaoImpl(this.dbc.getConnection());
	}
	
	
	@Override
	public boolean doCreate(Job job) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(job.getJobId()) == null) {
				flag = this.dao.doCreate(job);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}
/*
	@Override
	public List<Job> findAll(String keyword) throws Exception {
		List<Job> all = null;
		try {
			all = this.dao.findAll(keyword);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}
*/
	@Override
	public Job findById(int jobId) throws Exception {
		Job job = null;
		try {
			job = this.dao.findById(jobId);
		
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return job;
	}


	public boolean doChange(Job job) throws Exception {
		boolean flag = false;
		try {
			if(this.dao.findById(job.getJobId())!=null){
				flag=  this.dao.doChange(job);
			}
			} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}


	@Override
	public boolean doDelete(Job job) throws Exception {
		// TODO Auto-generated method stub
	 boolean flag = false;
		try {
			if (this.dao.findById(job.getJobId())!= null) {
				flag = this.dao.doDelete(job);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

}
