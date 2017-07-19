package edu.nuaa.dao;
import java.util.List;

import edu.nuaa.vo.Resume;
import edu.nuaa.vo.Student;

public interface IStuDao {
	public boolean doCreate(Student stu) throws Exception;
		
	public boolean doDelete(Student stu) throws Exception;
	
	public boolean doChange(Student stu) throws Exception;
	
	public Student doFindById(int STU_ID) throws Exception;
	
	public List<Student> doFindAll() throws Exception;
	
	public boolean doSaveFocusJob(int stuId,int jobId) throws Exception;
	
	public List<Integer> doWatchFocusJob(int stuId) throws Exception;
	
	public boolean doSetSkiLab(int stuId) throws Exception;
	
	public Resume doGetResume(int stuId) throws Exception;

}
