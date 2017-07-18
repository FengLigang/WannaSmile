package edu.nuaa.dao.impl;
import java.sql.*;

import javax.resource.cci.ResultSet;

import edu.nuaa.dao.IStuDao;
import edu.nuaa.vo.Student;

public class StuDaoImpl implements IStuDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	@Override
	public boolean doCreate(Student stu) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into stu (STU_ID,STU_Age,STU_Tel,STU_Resumeld,STU_Psw,STU_Name,STU_Edu,STU_Sex,STU_Email,STU_Introduce,STU_Experience,STU_Focus,STU_Recommend,STU_Skill,STU_SkillLab) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
	public boolean doDeleteById(int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "delete from stu where STU_ID=?";
		this.ps.setInt(1, STU_ID);
		this.ps = this.conn.prepareStatement(sql);
		if(ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

//	@Override
//	public boolean doChange(Student stu) throws Exception {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
	@Override
	public boolean doChangeID(int STU_ID,String STU_Name) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		String sql = "update stu set STU_ID = '"+ STU_ID +"' where STU_Name = '"+ STU_Name +"'";
		this.ps = this.conn.prepareStatement(sql);
		
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}



	@Override
	public boolean doChangeAge(int STU_Age,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		String sql = "update stu set STU_Age = '"+ STU_Age +"' where STU_ID = '"+ STU_ID +"'";
		this.ps = this.conn.prepareStatement(sql);
		
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeTel(int STU_Tel,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "update stu set STU_Tel = '"+ STU_Tel +"' where STU_ID='" + STU_ID + "'";
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeResumeId(int STU_ResumeId,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "update stu set STU_ResumeId = '"+ STU_ResumeId +"' where STU_ID='" + STU_ID + "'";
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangePsw(String STU_Psw,int STU_ID) throws Exception {
		String sql = "update stu set STU_Psw = '"+ STU_Psw +"' where STU_ID='" + STU_ID + "'";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeName(String STU_Name,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update stu set STU_Name = '"+ STU_Name +"' where STU_ID='" + STU_ID + "'";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeEdu(String STU_Edu,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update stu set STU_Edu = '"+ STU_Edu +"' where STU_ID='" + STU_ID + "'";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeSex(String STU_Sex,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update stu set STU_Sex = '"+ STU_Sex +"' where STU_ID='" + STU_ID + "'";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeEmail(String STU_Email,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update stu set STU_Email = '"+ STU_Email +"' where STU_ID='" + STU_ID + "'";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeItroduce(String STU_Introduce,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update stu set STU_Introduce = '"+ STU_Introduce +"' where STU_ID='" + STU_ID + "'";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeExperience(String STU_Experience,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update stu set STU_Experience = '"+ STU_Experience +"' where STU_ID='" + STU_ID + "'";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeFocus(String STU_Focus,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update stu set STU_Focus = '"+ STU_Focus +"' where STU_ID='" + STU_ID + "'";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeRecommend(String STU_Recommend,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update stu set STU_Recommend = '"+ STU_Recommend +"' where STU_ID='" + STU_ID + "'";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeSkill(String STU_Skill,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update stu set STU_Skill = '"+ STU_Skill +"' where STU_ID='" + STU_ID + "'";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}

	@Override
	public boolean doChangeSkillLab(String STU_SkillLab,int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update stu set STU_SkillLab = '"+ STU_SkillLab +"' where STU_ID='" + STU_ID + "'";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return false;
	}
	
	
	
	@Override
	public Student doFindById(int STU_ID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select STU_ID,STU_Age,STU_Tel,STU_Resumeld,STU_Psw,STU_Name,STU_Edu,STU_Sex,STU_Email,STU_Introduce,STU_Experience,STU_Focus,STU_Recommend,STU_Skill,STU_SkillLab from stu where STU_ID = ?";
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