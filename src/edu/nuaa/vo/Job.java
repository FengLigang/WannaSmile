package edu.nuaa.vo;

public class Job {
	
	private int jobId;
	/**
	 * 这里是工作一共需要多少的人
	 * **/
	private int jobPersonNumber;
	private String jobName;
	/**
	 * 这里是工作需要的教育水平
	 * **/
	private String jobEdu;
	private String jobSex;
	/**
	 * 此处保存的是保存的是输入的一段话（字符串）
	 * **/
	private String jobSkill;
	/**
	 * 此处存放的是从上面skill里面筛选出来的标签
	 * **/
	private String jobSkillLab;
	/**
	 * 此处为工作经验，可以不作为标签匹配的一个设置
	 * **/
	private String jobExperience;
	/**
	 * 此处为工作类型，全职兼职实习或是无要求
	 * **/
	private String jobType;
	
	/**
	 * 工资最高水平和最低水平
	 * **/
	private double jobMaxSal;
	private double jobMinSal;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getJobPersonNumber() {
		return jobPersonNumber;
	}
	public void setJobPersonNumber(int jobPersonNumber) {
		this.jobPersonNumber = jobPersonNumber;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobEdu() {
		return jobEdu;
	}
	public void setJobEdu(String jobEdu) {
		this.jobEdu = jobEdu;
	}
	public String getJobSex() {
		return jobSex;
	}
	public void setJobSex(String jobSex) {
		this.jobSex = jobSex;
	}
	public String getJobSkill() {
		return jobSkill;
	}
	public void setJobSkill(String jobSkill) {
		this.jobSkill = jobSkill;
	}
	public String getJobSkillLab() {
		return jobSkillLab;
	}
	public void setJobSkillLab(String jobSkillLab) {
		this.jobSkillLab = jobSkillLab;
	}
	public String getJobExperience() {
		return jobExperience;
	}
	public void setJobExperience(String jobExperience) {
		this.jobExperience = jobExperience;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public double getJobMaxSal() {
		return jobMaxSal;
	}
	public void setJobMaxSal(double jobMaxSal) {
		this.jobMaxSal = jobMaxSal;
	}
	public double getJobMinSal() {
		return jobMinSal;
	}
	public void setJobMinSal(double jobMinSal) {
		this.jobMinSal = jobMinSal;
	}
	
	
	
	
}
