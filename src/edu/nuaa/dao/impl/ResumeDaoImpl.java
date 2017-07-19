package edu.nuaa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.nuaa.dao.IResumeDao;
import edu.nuaa.factory.JobDaoFactory;
import edu.nuaa.factory.ResumeDaoFactory;
import edu.nuaa.factory.SkiDaoFactory;
import edu.nuaa.factory.StuDaoFactory;
import edu.nuaa.vo.Job;
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
		String sql = "insert into res (resId,stuId,stuAge,stuName,stuSex,stuEdu,stuIntroduce,stuExperience,stuPrize,stuSkill) values (?,?,?,?,?,?,?,?,?,?)";
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
		//this.ps.setString(11, resume.getStuSkillLab());
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		
		boolean flag2 = this.setSkillLab(resume);
		this.ps.close();
		return flag&&flag2;
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
//		String changeSkillLab = resume.getStuSkillLab();
		boolean flag = false;
		String sql = "update res set stuAge = ?,stuName=?,stuSex=?,stuEdu=?,stuIntroduce = ?,stuExperience = ?,stuPrize = ?,stuSkill = ? where stuId = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, changeAge);
		this.ps.setString(2, changeName);
		this.ps.setString(3, changeSex);
		this.ps.setString(4, changeEdu);
		this.ps.setString(5, changeIntroduce);
		this.ps.setString(6, changeExperience);
		this.ps.setString(7, changePrize);
		this.ps.setString(8, changeSkill);
//		this.ps.setString(9, changeSkillLab);
		this.ps.setInt(9, stuId);
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

	@Override
	public boolean setSkillLab(Resume resume) throws Exception {
		boolean flag = false;
		String skill = resume.getStuSkill();//学生个人简历中的技能
		skill = skill.toLowerCase(); //全部转化为小写，用于和skillTable数据表中的标签进行匹配
		skill = "#"+skill;		//加个标志位，用于indexOf函数定位时不会定位到0；
		int count =10;			//SkillTable 的标签个数
		String skilllab = "";	//用来最后传入sql语句的设置stuSkillLab的字符串
		
		for(int i=0;i< count;i++){
//			System.out.println(SkiDaoFactory.getISkiDaoInstance().doFindById(i+1).getSkiName());
			if(skill.indexOf(SkiDaoFactory.getISkiDaoInstance().doFindById(i+1).getSkiName()) > 0){
				skilllab += "_";
				skilllab +=SkiDaoFactory.getISkiDaoInstance().doFindById(i+1).getSkiName();
				
			}
		}
		
		String sql = "update res set stuSkillLab = ? where resId = ?";
		this.ps = this.conn.prepareStatement(sql);//实例化
		this.ps.setString(1, skilllab);
		this.ps.setInt(2, resume.getResId());
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	public boolean syncSkillLab(Resume resume) throws Exception {
		boolean flag = false;
		int stuId = resume.getStuId();
		//获取id为stuId的学生在个人信息中填写
		String skill = StuDaoFactory.getIstuDaoInstance().doFindById(stuId).getStuSkill();
		skill = skill.toLowerCase(); //全部转化为小写，用于和skillTable数据表中的标签进行匹配
		skill = "#"+skill;	//加个标志位，用于indexOf函数定位时不会定位到0；
		int count =10;			//SkillTable 的标签个数
		String skilllab = "";	//用来最后传入sql语句的设置stuSkillLab的字符串
		
		for(int i=0;i< count;i++){
//			System.out.println(SkiDaoFactory.getISkiDaoInstance().doFindById(i+1).getSkiName());
			if(skill.indexOf(SkiDaoFactory.getISkiDaoInstance().doFindById(i+1).getSkiName()) > 0){
				skilllab += "_";
				skilllab +=SkiDaoFactory.getISkiDaoInstance().doFindById(i+1).getSkiName();
				
			}
		}
		
		String sql = "update res set stuSkillLab = ? where resId = ?";
		this.ps = this.conn.prepareStatement(sql);//实例化
		this.ps.setString(1, skilllab);
		this.ps.setInt(2, resume.getResId());
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	public List<Integer> findSuitJob(Resume resume,int MaxSal,int MinSal,String Type) throws Exception {

		List<Integer> all = new ArrayList<Integer>();
		int suitCount = 0; 
		String []joblist = null;
		Job job = null;
		double match;//匹配度
		String stusex =ResumeDaoFactory.getIResumeDaoInstance().findById(resume.getResId()).getStuSex();
		String []reslist = ResumeDaoFactory.getIResumeDaoInstance().findById(resume.getResId()).getStuSkillLab().split("_");
		String stuEdu = ResumeDaoFactory.getIResumeDaoInstance().findById(resume.getResId()).getStuEdu();
		
		String sql = "select jobId from job";
		//此处为选择所有工作的jobId ,以传给返回值
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		//判断匹配度
		while(rs.next()){
			suitCount = 0;
			job = JobDaoFactory.getJobDaoInstance().findById(rs.getInt(1));
			joblist = job.getJobSkillLab().split("_");
			//获得标签匹配度
			for(int i= 1; i<joblist.length ; i++){	
				for( int j = 1;j<reslist.length ; j++){
					if(joblist[i].equals(reslist[j])){
						suitCount ++;
					}
				}
			}
			match = (double)suitCount / (joblist.length);
			//判断性别，如果与工作性别要求不符，则查找下一个工作
			if(job.getJobSex().equals("男") && stusex.equals("女")){ continue;}
			if(job.getJobSex().equals("女") && stusex.equals("男")){ continue;}
			//判断学历,如果不符合就查找下一工作
			if(job.getJobEdu().equals("博士") && stuEdu.equals("博士") == false){continue;}
			if(job.getJobEdu().equals("硕士") && stuEdu.equals("本科")){continue;}
			//判断薪资  如果薪资不符合学生要求的最低值，则查找下一个工作
			if(job.getJobMinSal()+500 <  MinSal){continue;}
			if(job.getJobMaxSal()+500 < MaxSal){continue;}
			if( match >= 0.8 && Type.equals(job.getJobType())){
				all.add(rs.getInt(1));
			}
		}
		return all;
	}
	
}
