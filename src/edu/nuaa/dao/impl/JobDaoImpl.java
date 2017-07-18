package edu.nuaa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nuaa.dao.JobDao;
import edu.nuaa.vo.Job;


public class JobDaoImpl implements JobDao {
	   private Connection conn =null;
	   private PreparedStatement ps=null;
	   public JobDaoImpl (Connection conn){
		   this.conn=conn;
	   }
	   
	@Override
	public boolean doCreate(Job job) throws Exception {
	   boolean flag=false;
	   String sql="INSERT INTO job(jobComId,jobId,jobPersonNumber,jobName,jobEdu,jobSex,jobSkill,jobSkillLab,jobExperience,jobType,jobMaxSal,jobMinSal)values(?,?,?,?,?,?,?,?,?,?,?,?)";
	   this.ps=this.conn.prepareStatement(sql);
	   this.ps.setInt(1,job.getJobComId());
	   this.ps.setInt(2,job.getJobId());
	   this.ps.setInt(3,job.getJobPersonNumber());
	   this.ps.setString(4,job.getJobName());
	   this.ps.setString(5,job.getJobEdu());
	   this.ps.setString(6,job.getJobSex());
	   this.ps.setString(7,job.getJobSkill());
	   this.ps.setString(8, job.getJobSkillLab());
	   this.ps.setString(9, job.getJobExperience());
	   this.ps.setString(10, job.getJobType());
	   this.ps.setDouble(11,job.getJobMaxSal());
	   this.ps.setDouble(12,job.getJobMinSal());
	   if(this.ps.executeUpdate()>0){
		   flag=true;
	   }
     this.ps.close();
     return flag;
}
	/*按照关键字查询
    public List<Job> findAll(String keyword) throws Exception {
		List<Job> all = new ArrayList<Job>();//定义一个集合，接受查询到的全部数据
		String sql = "SELECTjobComId,jobId,jobPersonNumber,jobName,jobEdu,jobSex,jobSkill,jobSkillLab,jobExperience,jobType,jobMaxSal,jobMinSal FROM job WHERE j LIKE ? OR job LIKE ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, %+keyword+%);
		this.ps.setString(2, %+keyWord+%);
		ResultSet rs = this.ps.executeQuery();//执行查询操作
		Job job = null;//定义Job对象
		while(rs.next()){
			Job = new Job();//每次循环都实例化一个Job对象
			Job.setJobno(rs.getInt(1));//设置Jobno
			Job.setEname(rs.getString(2));
			Job.setJob(rs.getString(3));
			Job.setHiredate(rs.getDate(4));
			Job.setSal(rs.getFloat(5));
			all.add(Job);//向集合中增加对象
		}
		this.ps.close();//关闭ps操作。
		return all;
	}
*/
	public Job findById(int jobId) throws Exception {
		Job job = null;
		String sql = "select jobComId,jobId,jobPersonNumber,jobName,jobEdu,jobSex,jobSkill,jobSkillLab,jobExperience,jobType,jobMaxSal,jobMinSal from job where jobId = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, jobId);
	
		ResultSet rs = this.ps.executeQuery();
		if (rs.next()) {
			job = new Job();
			job.setJobComId(rs.getInt(1));
			job.setJobId(rs.getInt(2));
			job.setJobPersonNumber(rs.getInt(3));
			job.setJobName(rs.getString(4));
			job.setJobEdu(rs.getString(5));
			job.setJobSex(rs.getString(6));
			job.setJobSkill(rs.getString(7));
			job.setJobSkillLab(rs.getString(8));
			job.setJobExperience(rs.getString(9));
			job.setJobType(rs.getString(10));
			job.setJobMaxSal(rs.getDouble(11));
			job.setJobMinSal(rs.getDouble(12));
		}
		rs.close();
		this.ps.close();
		return job;
	}

	@Override
	public boolean doDelete(Job job) throws Exception {
		 boolean flag=false;
		 int jobId= job.getJobId();
		   String sql="delete from job where jobId="+jobId;
	
		   this.ps = this.conn.prepareStatement(sql);
		  
		if (this.ps.executeUpdate()>0) {
			   flag=true;
		}
	     this.ps.close();
	     return flag;
	}


	@Override
	public boolean doChange(Job job) throws Exception {
		boolean flag=false;
		int changejobComId=job.getJobComId();
		int changejobId=job.getJobId();
		int changejobPersonNumber =job.getJobPersonNumber();
		String changejobName=job.getJobName();
		String changejobSex=job.getJobSex();
		String changejobEdu=job.getJobEdu();
		String changejobSkill=job.getJobSkill();
		String changejobExperience= job.getJobExperience();
		String changejobType=job.getJobType();
		String changejobSkillLab=job.getJobSkillLab();
		Double changejobMaxSal= job.getJobMaxSal();
		Double changejobMinSal=job.getJobMinSal();
		String sql="update job set jobComI=?,jobId=?,jobPersonNumber=?,jobName=?,jobEdu=?,jobSex=?,jobSkill=?,jobSkillLab=?,jobExperience=?,jobType=?,jobMaxSal=?,jobMinSal=? from job";
   this.ps=this.conn.prepareStatement(sql);
				this.ps.setInt(1, changejobComId);
				this.ps.setInt(2, changejobId);
				this.ps.setInt(3, changejobPersonNumber);
				this.ps.setString(4, changejobName);
				   this.ps.setString(5,changejobEdu);
				   this.ps.setString(6,changejobSex);
				   this.ps.setString(7,changejobSkill);
				   this.ps.setString(8, changejobSkillLab);
				   this.ps.setString(9, changejobExperience);
				   this.ps.setString(10, changejobType);
				   this.ps.setDouble(11,changejobMaxSal);
				   this.ps.setDouble(12,changejobMinSal);	
				   if(this.ps.executeUpdate() > 0){
						flag = true;
					}
					
					this.ps.close();	   
		return flag;
	}
}


