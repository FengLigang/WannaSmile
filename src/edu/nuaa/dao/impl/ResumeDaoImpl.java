package edu.nuaa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nuaa.dao.IResumeDao;
import edu.nuaa.vo.Resume;

public class ResumeDaoImpl implements IResumeDao{
	
	private Connection conn = null;// 数据库连接对象
	private PreparedStatement ps = null;// 数据库操作对象

	public ResumeDaoImpl(Connection conn) {// 通过构造方法来取得数据库连接
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(Resume resume) throws Exception {
		boolean flag = false;
		String sql = "insert into res (resId,stuId,stuAge,stuName,stuSex,stuEdu,stuIntroduce,stuExperience,stuPrize,stuSkill,stuSkillLab) values (?,?,?,?,?,?,?,?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);//实例化
		this.ps.setInt(1, resume.getResId());
		this.ps.setInt(2, resume.getStuId());
		this.ps.setInt(3,resume.getStuAge());
		this.ps.setString(4, resume.getStuName());
		this.ps.setString(5, resume.getStuSex());
		this.ps.setString(6, resume.getStuEdu());
		this.ps.setString(7, resume.getStuIntroduce());
		this.ps.setString(8, resume.getStuExperience());
		this.ps.setString(9, resume.getStuPrize());
		this.ps.setString(10, resume.getStuSkill());
		this.ps.setString(11, resume.getStuSkillLab());
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	public boolean doDelete(Resume resume) throws Exception {
		boolean flag = false;
		int delId = resume.getStuId();
		String sql = "delete from res where stuId = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, delId);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	public boolean changeAll(Resume resume) throws Exception {
		int stuId = resume.getStuId();
		//int resId = resume.getResId();
		int changeAge = resume.getStuAge();
		String changeName = resume.getStuName();
		String changeSex = resume.getStuSex();
		String changeEdu = resume.getStuEdu();
		String changeIntroduce = resume.getStuIntroduce();
		String changeExperience = resume.getStuExperience();
		String changePrize = resume.getStuPrize();
		String changeSkill = resume.getStuSkill();
		String changeSkillLab = resume.getStuSkillLab();
		boolean flag = false;
		String sql = "update res set stuAge = ?,stuName=?,stuSex=?,stuEdu=?,stuIntroduce = ?,stuExperience = ?,stuPrize = ?,stuSkill = ?,stuSkillLab = ? where stuId = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, changeAge);
		this.ps.setString(2, changeName);
		this.ps.setString(3, changeSex);
		this.ps.setString(4, changeEdu);
		this.ps.setString(5, changeIntroduce);
		this.ps.setString(6, changeExperience);
		this.ps.setString(7, changePrize);
		this.ps.setString(8, changeSkill);
		this.ps.setString(9, changeSkillLab);
		this.ps.setInt(10, stuId);
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	//关键字有哪些？？
	@Override
	public List<Resume> findByKeyword(String keyword) throws Exception {
		
		List<Resume> all = new ArrayList<Resume>();
		String sql = "select resId,stuId,stuAge,stuName,stuSex,stuEdu,stuIntroduce,stuExperience,stuPrize,stuSkill,stuSkillLab from res where stuName like ? or stuSkill like ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, "%" + keyword + "%");
		this.ps.setString(2, "%" + keyword + "%");
		ResultSet rs = this.ps.executeQuery();
		Resume resume = null;
		while (rs.next()) {
			resume = new Resume();
			resume.setResId(rs.getInt(1));
			resume.setStuId(rs.getInt(2));
			resume.setStuAge(rs.getInt(3));
			resume.setStuName(rs.getString(4));
			resume.setStuSex(rs.getString(5));
			resume.setStuEdu(rs.getString(6));
			resume.setStuIntroduce(rs.getString(7));
			resume.setStuExperience(rs.getString(8));
			resume.setStuPrize(rs.getString(9));
			resume.setStuSkill(rs.getString(10));
			resume.setStuSkillLab(rs.getString(11));
			all.add(resume);
		}
		rs.close();
		this.ps.close();
		return all;
	}

	@Override
	public Resume findById(int stuId) throws Exception {
		String sql = "select resId,stuId,stuAge,stuName,stuSex,stuEdu,stuIntroduce,stuExperience,stuPrize,stuSkill,stuSkillLab from res where stuId = ?";
		Resume resume = null;
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, stuId);
		ResultSet rs = this.ps.executeQuery();
		if (rs.next()) {
			resume = new Resume();
			resume.setResId(rs.getInt(1));
			resume.setStuId(rs.getInt(2));
			resume.setStuAge(rs.getInt(3));
			resume.setStuName(rs.getString(4));
			resume.setStuSex(rs.getString(5));
			resume.setStuEdu(rs.getString(6));
			resume.setStuIntroduce(rs.getString(7));
			resume.setStuExperience(rs.getString(8));
			resume.setStuPrize(rs.getString(9));
			resume.setStuSkill(rs.getString(10));
			resume.setStuSkillLab(rs.getString(11));
		}
		rs.close();
		this.ps.close();
		return resume;
	}
	
}
