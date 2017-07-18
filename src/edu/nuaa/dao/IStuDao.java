package edu.nuaa.dao;
import edu.nuaa.vo.Student;

public interface IStuDao {
	public boolean doCreate(Student stu) throws Exception;
		
	public boolean doDelete(Student stu) throws Exception;
	
	public boolean doChange(Student stu) throws Exception;
	
	public Student doFindById(int STU_ID) throws Exception;
}
