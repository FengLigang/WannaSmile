package edu.nuaa.dao.impl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.nuaa.dao.IStuDao;
import edu.nuaa.factory.JobDaoFactory;
import edu.nuaa.factory.NoDaoFactory;
import edu.nuaa.factory.ResumeDaoFactory;
import edu.nuaa.factory.SkiDaoFactory;
import edu.nuaa.factory.StuDaoFactory;
import edu.nuaa.vo.Job;
import edu.nuaa.vo.Resume;
import edu.nuaa.vo.SkillTable;
import edu.nuaa.vo.Student;

public class StuDaoImpl implements IStuDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	public StuDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Student stu) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into stu (stuId,stuAge,stuTel,stuResumeId,stuPsw,stuName,stuEdu,stuSex,stuEmail,stuIntroduce,stuExperience,stuFocus,stuRecommend,stuSkill,stuSkillLab) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, stu.getStuId());
		this.ps.setInt(2, stu.getStuAge());
		this.ps.setInt(3, stu.getStuTel());
		this.ps.setInt(4, stu.getStuResumeId());
		this.ps.setString(5, stu.getStuPsw());
		this.ps.setString(6, stu.getStuName());
		this.ps.setString(7, stu.getStuEdu());
		this.ps.setString(8, stu.getStuSex());
		this.ps.setString(9, stu.getStuEmail());
		this.ps.setString(10, stu.getStuIntroduce());
		this.ps.setString(11, stu.getStuExperience());
		this.ps.setString(12, stu.getStuFocus());
		this.ps.setString(13, stu.getStuRecommend());
		this.ps.setString(14, stu.getStuSkill());
		this.ps.setString(15, stu.getStuSkillLab());
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		try{
			this.ps.close();
		}catch(Exception e){
			throw e;
		}
		return false;
	}

	@Override
	public boolean doDelete(Student stu) throws Exception{
		boolean flag = false;
		int STU_ID = stu.getStuId();
		String sql = "delete from stu where stuId="+STU_ID;
		this.ps = this.conn.prepareStatement(sql);
		if (this.ps.executeUpdate() > 0) {
			flag = true;
		}
		this.ps.close();
		return flag;
	}


	@Override
	public boolean doChange(Student stu) throws Exception {

		boolean flag = false;
		int stuId = stu.getStuId();
		int changestuAge = stu.getStuAge();
		int changestuTel = stu.getStuTel();
		int changeresumeId = stu.getStuResumeId();
		String changepsw = stu.getStuPsw();
		String changestuName = stu.getStuName();
		String changestuEdu = stu.getStuEdu();
		String changestuSex = stu.getStuSex();
		String changestuEmail = stu.getStuEmail();
		String changeIntroduce = stu.getStuIntroduce();
		String changeExperience = stu.getStuExperience();
		String changeFocus = stu.getStuFocus();
		String changeRecommend = stu.getStuRecommend();
		String changeSkill = stu.getStuSkill();
		String changeSkillLab = stu.getStuSkillLab();
		String sql = "update stu set stuAge=?,stuTel=?, stuResumeId=?,stuPsw=?,stuName=?,stuEdu=?,stuSex=?,stuEmail=?,stuIntroduce=?,stuExperience=?,stuFocus=?,stuRecommend=?,stuSkill=?,stuSkillLab=? where  stuId= ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, changestuAge);
		this.ps.setInt(2, changestuTel);
		this.ps.setInt(3, changeresumeId);
		this.ps.setString(4, changepsw);
		this.ps.setString(5, changestuName);
		this.ps.setString(6, changestuEdu);
		this.ps.setString(7, changestuSex);
		this.ps.setString(8, changestuEmail);
		this.ps.setString(9, changeIntroduce);
		this.ps.setString(10, changeExperience);
		this.ps.setString(11, changeFocus);
		this.ps.setString(12, changeRecommend);
		this.ps.setString(13, changeSkill);
		this.ps.setString(14, changeSkillLab);
		this.ps.setInt(15, stuId);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		
		this.ps.close();
		
		return flag;
	}
	
	@Override
	public Student doFindById(int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select stuId,stuAge,stuTel,stuResumeId,stuPsw,stuName,stuEdu,stuSex,stuEmail,stuIntroduce,stuExperience,stuFocus,stuRecommend,stuSkill,stuSkillLab from stu where stuId = ?";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setInt(1, STU_ID);
		Student stu = null;
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			stu = new Student();
			stu.setStuId(rs.getInt(1));
			stu.setStuAge(rs.getInt(2));
			stu.setStuTel(rs.getInt(3));
			stu.setStuResumeId(rs.getInt(4));
			stu.setStuPsw(rs.getString(5));
			stu.setStuName(rs.getString(6));
			stu.setStuEdu(rs.getString(7));
			stu.setStuSex(rs.getString(8));
			stu.setStuEmail(rs.getString(9));
			stu.setStuIntroduce(rs.getString(10));
			stu.setStuExperience(rs.getString(11));
			stu.setStuFocus(rs.getString(12));
			stu.setStuRecommend(rs.getString(13));
			stu.setStuSkill(rs.getString(14));
			stu.setStuSkillLab(rs.getString(15));
		}
		rs.close();
		this.ps.close();
		return stu;
	}
	
	
	public List<Student> doFindAll() throws Exception{
		String sql = "select stuId,stuAge,stuTel,stuResumeId,stuPsw,stuName,stuEdu,stuSex,stuEmail,stuIntroduce,stuExperience,stuFocus,stuRecommend,stuSkill,stuSkillLab from stu";
		
		this.ps=this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		List<Student> all = new ArrayList<Student>();
		Student stu = null;
		while(rs.next()){
			stu = new Student();
			stu.setStuId(rs.getInt(1));
			stu.setStuAge(rs.getInt(2));
			stu.setStuTel(rs.getInt(3));
			stu.setStuResumeId(rs.getInt(4));
			stu.setStuPsw(rs.getString(5));
			stu.setStuName(rs.getString(6));
			stu.setStuEdu(rs.getString(7));
			stu.setStuSex(rs.getString(8));
			stu.setStuEmail(rs.getString(9));
			stu.setStuIntroduce(rs.getString(10));
			stu.setStuExperience(rs.getString(11));
			stu.setStuFocus(rs.getString(12));
			stu.setStuRecommend(rs.getString(13));
			stu.setStuSkill(rs.getString(14));
			stu.setStuSkillLab(rs.getString(15));	
			all.add(stu);
		}
		return all;
	}
	
	
	@Override
	public boolean doSaveFocusJob(int stuId, int jobId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Student student = new Student();
		student = StuDaoFactory.getIstuDaoInstance().doFindById(stuId);
		String stufocus = student.getStuFocus();
		if(student.getStuFocus() == null){
			stufocus = "_";
		}
		stufocus = stufocus + jobId + "_";
		String sql = "update stu set stuFocus=? where stuId= ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, stufocus);
		this.ps.setInt(2, stuId);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}
	
	
	@Override
	public List<Integer> doWatchFocusJob(int stuId) throws Exception {
		Student student = new Student();
		student = StuDaoFactory.getIstuDaoInstance().doFindById(stuId);		
		String stufocus = student.getStuFocus();
		String []stufocus2 = stufocus.split("_");

		List<Integer> focusjob = new ArrayList<Integer>();
		System.out.println(stufocus2.length);//3
		for(int i=1;i<stufocus2.length;i++){
			focusjob.add(Integer.parseInt(stufocus2[i]));
		}
		return focusjob;
	}
	
	
	@Override
	public boolean doSetSkiLab(int stuId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Student student = new Student();
		student = StuDaoFactory.getIstuDaoInstance().doFindById(stuId);
		String getstuskill;
			
		SkillTable skilltable = new SkillTable();
		String result = "_"; //存放最后关键字和“_”连接完成的最终存放在skillLab中的字符串
		String s3 = null;
		int s1 = 0;
		int s2 = 0;
		for(int skiId = 1 ; skiId <= 10 ; skiId++){
			getstuskill = student.getStuSkill(); //学生的skill描述
			skilltable = SkiDaoFactory.getISkiDaoInstance().doFindById(skiId);//skill表中的一行，skiId使得一行一行遍历
			String skiname = skilltable.getSkiName(); //获取这一行的存放的skill的name
			s1 = getstuskill.indexOf(skiname);//关键字的首index
			s2 = s1 + skiname.length();		  //关键字的尾index
			if(s1 == -1){					  //找不到这个关键字的时候，s1默认会被置为-1，所以这里要continue,否则会exception；
				continue;
			}
			s3 = getstuskill.substring(s1,s2);
			s3 += "_";
			result = result + s3;
		}
		System.out.println(result);
		String sql = "update stu set stuSkillLab=? where stuId= ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, result);
		this.ps.setInt(2, student.getStuId());
		System.out.println(result);
		
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}
	
	@Override
	public Resume doGetResume(int stuId) throws Exception {
		// TODO Auto-generated method stub
		Resume resume = new Resume();
		resume = ResumeDaoFactory.getIResumeDaoInstance().findById(stuId);
		return resume;
	}
}