package edu.nuaa.StuTest;

import edu.nuaa.factory.StuDaoFactory;
import edu.nuaa.vo.Student;

public class StuTest {
	public static void main(String []args){
		Student stu = null;
		for(int i = 1; i<20; i++){
			stu = new Student();
			stu.setStuAge(10 + i);
			stu.setStuEdu("collage 2");
			stu.setStuEmail("i@nuaa.edu.cn");
			stu.setStuExperience("no experience");
			stu.setStuFocus("1 2 3 4");
			stu.setStuId(161520200 + i);
			stu.setStuIntroduce("I am a programmer,i like coding");
			stu.setStuName("fanlihong-" + i);
			stu.setStuPsw("123456");
			stu.setStuRecommend("no recommend");
			stu.setStuResumeId(i);
			stu.setStuSex("female");
			stu.setStuSkill("java c c++");
			stu.setStuSkillLab("java c c++");
			stu.setStuTel(1599635 + i);
			
			try {
				StuDaoFactory.getIstuDaoInstance().doCreate(stu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
