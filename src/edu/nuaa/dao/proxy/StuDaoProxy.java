package edu.nuaa.dao.proxy;

import java.util.List;

import edu.nuaa.dao.IStuDao;
import edu.nuaa.dao.impl.StuDaoImpl;
import edu.nuaa.dbc.DataBaseConnection;
import edu.nuaa.vo.Resume;
import edu.nuaa.vo.Student;

public class StuDaoProxy implements IStuDao{
	private DataBaseConnection dbc = null;
	private IStuDao dao = null;
	public StuDaoProxy() throws Exception{
		this.dbc = new DataBaseConnection();
		this.dao = new StuDaoImpl(this.dbc.getConnection());
	}
	
	
	@Override
	public boolean doCreate(Student stu) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
		if(this.dao.doFindById(stu.getStuId()) == null){
			flag = this.dao.doCreate(stu);
		}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doDelete(Student stu) throws Exception {		
		boolean flag = false;
		try{
		if(this.dao.doFindById(stu.getStuId()) != null){
			flag = this.dao.doDelete(stu);
		}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		// TODO Auto-generated method stub
		return flag;
	}

	
	@Override
	public boolean doChange(Student stu) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		//先通过id找到学生,执行change，执行成功则返回flag = 1；
		try{
			
		if(this.dao.doFindById(stu.getStuId()) != null){
			flag = this.dao.doChange(stu);
		}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	
	

	@Override
	public Student doFindById(int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		Student stu = null;
		try{
			stu = this.dao.doFindById(STU_ID);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return stu;
	}
	
	public List<Student> doFindAll() throws Exception{
		List<Student> all = null;
		try{
			all = this.dao.doFindAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}


	@Override
	public boolean doSaveFocusJob(int stuId, int jobId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
		if(this.dao.doFindById(stuId) != null){
			flag = this.dao.doSaveFocusJob(stuId, jobId);
		}
		}catch(Exception e){
			throw e;
		}
		return flag;
	}


	@Override
	public List<Integer> doWatchFocusJob(int stuId) throws Exception {
		// TODO Auto-generated method stub
		List<Integer> focusjob = null;
		try{
			if(this.dao.doFindById(stuId) != null){
				focusjob = this.dao.doWatchFocusJob(stuId);
			}
		}catch(Exception e){
				throw e;
		}
		return focusjob;
	}


	@Override
	public boolean doSetSkiLab(int stuId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		//先通过id找到学生,执行change，执行成功则返回flag = 1；
		try{		
			if(this.dao.doFindById(stuId) != null){
				flag = this.dao.doSetSkiLab(stuId);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}


	@Override
	public Resume doGetResume(int stuId) throws Exception {
		// TODO Auto-generated method stub
		Resume resume = new Resume();
		try{
			if(this.dao.doFindById(stuId) != null){
				resume = this.dao.doGetResume(stuId);
			}else{
				resume = null;
			}
		}catch(Exception e){
			throw e;
		}
		return resume;
	}
}
