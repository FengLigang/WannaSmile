package edu.nuaa.vo;
import edu.nuaa.vo.Student;


public class Student {
  
	private int stuId;
	private int stuAge;
	private int stuTel;
	private int stuResumeId;
	private String stuPsw;
	private String stuName;
	private String stuEdu;
	private String stuSex;
	private String stuEmail;
	private String stuIntroduce;
	/**
	 * 此处为工作经历
	 * **/
	private String stuExperience;
	/**
	 * 此处保存的是关注的工作
	 * **/
	private String stuFocus;
	/**
	 * 这是系统自动推荐的工作，在后台完成，如果前面工作做完后面可以实现此功能
	 * **/
	private String stuRecommend;
	
	/**
	 * 此处存储的是输入的一段话（字符串）
	 * **/
	private String stuSkill;
	/**
	 * 存储方式 skid_skid_skid，添加一个是否同步的询问功能
	 * **/
	private String stuSkillLab;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public int getStuTel() {
		return stuTel;
	}
	public void setStuTel(int stuTel) {
		this.stuTel = stuTel;
	}
	public int getStuResumeId() {
		return stuResumeId;
	}
	public void setStuResumeId(int stuResumeId) {
		this.stuResumeId = stuResumeId;
	}
	public String getStuPsw() {
		return stuPsw;
	}
	public void setStuPsw(String stuPsw) {
		this.stuPsw = stuPsw;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuEdu() {
		return stuEdu;
	}
	public void setStuEdu(String stuEdu) {
		this.stuEdu = stuEdu;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getStuIntroduce() {
		return stuIntroduce;
	}
	public void setStuIntroduce(String stuIntroduce) {
		this.stuIntroduce = stuIntroduce;
	}
	public String getStuExperience() {
		return stuExperience;
	}
	public void setStuExperience(String stuExperience) {
		this.stuExperience = stuExperience;
	}
	public String getStuFocus() {
		return stuFocus;
	}
	public void setStuFocus(String stuFocus) {
		this.stuFocus = stuFocus;
	}
	public String getStuRecommend() {
		return stuRecommend;
	}
	public void setStuRecommend(String stuRecommend) {
		this.stuRecommend = stuRecommend;
	}
	public String getStuSkill() {
		return stuSkill;
	}
	public void setStuSkill(String stuSkill) {
		this.stuSkill = stuSkill;
	}
	public String getStuSkillLab() {
		return stuSkillLab;
	}
	public void setStuSkillLab(String stuSkillLab) {
		this.stuSkillLab = stuSkillLab;
	}
	
	
	
	
	
	
	
	
	
}
