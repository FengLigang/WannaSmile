package edu.nuaa.dao;
import edu.nuaa.vo.Student;

public interface IStuDao {
	public boolean doCreate(Student stu) throws Exception;
	
	
	
	public boolean doDeleteById(int STU_ID) throws Exception;
	
	
	
	//public boolean doChange(Student stu) throws Exception;
	public boolean doChangeID(int STU_ID,String STU_Name) throws Exception;
	public boolean doChangeAge(int STU_Age,int STU_ID) throws Exception;
	public boolean doChangeTel(int STU_Tel,int STU_ID) throws Exception;
	public boolean doChangeResumeId(int STU_ResemeId,int STU_ID) throws Exception;
	public boolean doChangePsw(String STU_Psw,int STU_ID) throws Exception;
	public boolean doChangeName(String STU_Name,int STU_ID) throws Exception;
	public boolean doChangeEdu(String STU_Edu,int STU_ID) throws Exception;
	public boolean doChangeSex(String STU_Sex,int STU_ID) throws Exception;
	public boolean doChangeEmail(String STU_Email,int STU_ID) throws Exception;
	public boolean doChangeItroduce(String STU_Introduce,int STU_ID) throws Exception;
	public boolean doChangeExperience(String STU_Experience,int STU_ID) throws Exception;
	public boolean doChangeFocus(String STU_Focus,int STU_ID) throws Exception;
	public boolean doChangeRecommend(String STU_Recommend,int STU_ID) throws Exception;
	public boolean doChangeSkill(String STU_Skill,int STU_ID) throws Exception;
	public boolean doChangeSkillLab(String STU_SkillLab,int STU_ID) throws Exception;
	
	
	public Student doFindById(int STU_ID) throws Exception;
}
