package edu.nuaa.dao.impl;
import java.sql.*;

import javax.resource.cci.ResultSet;

import edu.nuaa.dao.IStuDao;
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
		int STU_ID = stu.getStuId();
		boolean flag = false;
		String sql = "delete from stu where stuId=STU_ID";
		this.ps = this.conn.prepareStatement(sql);
		if (this.ps.executeUpdate() > 0) {
			flag = true;
		}
		this.ps.close();
		return flag;
	}


	@Override
	public boolean doChange(Student stu) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		int changestuId = stu.getStuId();
		int changestuAge = stu.getStuAge();
		int changestuTel = stu.getStuTel();
		int changestuResumeId = stu.getStuResumeId();
		String changestuPsw = stu.getStuPsw();
		String changestuName = stu.getStuName();
		String changestuEdu = stu.getStuEdu();
		String changestuSex = stu.getStuSex();
		String changestuEmail = stu.getStuEmail();
		String changestuIntroduce = stu.getStuIntroduce();
		String changestuExperience = stu.getStuExperience();
		String changestuFocus = stu.getStuFocus();
		String changestuRecommend = stu.getStuRecommend();
		String changestuSkill = stu.getStuSkill();
		String changestuSkillLab = stu.getStuSkillLab();
		
		String sql = "update stu set stuId = ?,stuAge = ?,stuTel = ?,stuResumeId = ?,stuPsw = ?,stuName = ?,stuEdu = ?,stuSex = ?,stuEmail = ?,stuIntroduce = ?,stuExperience = ?,stuFocus = ?,stuRecommend = ?,stuSkill =　?,stuSkillLab = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, changestuId);
		this.ps.setInt(2, changestuAge);
		this.ps.setInt(3, changestuTel);
		this.ps.setInt(4, changestuResumeId);
		this.ps.setString(5, changestuPsw);
		this.ps.setString(6, changestuName);
		this.ps.setString(7, changestuEdu);
		this.ps.setString(8, changestuSex);
		this.ps.setString(9, changestuEmail);
		this.ps.setString(10, changestuIntroduce);
		this.ps.setString(11, changestuExperience);
		this.ps.setString(12, changestuFocus);
		this.ps.setString(13, changestuRecommend);
		this.ps.setString(14, changestuSkill);
		this.ps.setString(15, changestuSkillLab);
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}
	
	@Override
	public Student doFindById(int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select stuId,stuAge,stuTel,stuResumeId,stuPsw,stuName,stuEdu,stuSex,stuEmail,stuIntroduce,stuExperience,stuFocus,stuRecommend,stuSkill,stuSkillLab from stu where STU_ID = ?";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setInt(1, STU_ID);
		Student stu = null;
		java.sql.ResultSet rs = this.ps.executeQuery();
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



}