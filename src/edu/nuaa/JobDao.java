package edu.nuaa.dao;


import java.util.List;

import edu.nuaa.vo.Job;

public interface JobDao {
  public boolean doCreate(Job job) throws Exception;
  
//  public List<Job> findAll(String keyword) throws Exception;
  
  
  public Job findById(int jobId) throws Exception;

  public boolean doChange(Job job)throws Exception;
  
  public boolean doDelete(Job job)throws Exception;
  
  //修改
  //设置技能标签
  //查看所属公
  //人才查找
}


