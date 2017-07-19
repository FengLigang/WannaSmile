package edu.nuaa.test;

import edu.nuaa.factory.ResumeDaoFactory;
import edu.nuaa.vo.Resume;

public class Test {

	public static void main(String[] args) {
		boolean flag = false;
    	Resume resume = new Resume();
    	resume.setResId(2);
    	resume.setStuId(2);
    	resume.setStuAge(1);
    	resume.setStuName("456123");
    	resume.setStuSex("w");
    	resume.setStuEdu("w");
    	resume.setStuIntroduce("ww");
    	resume.setStuExperience("ww");
    	resume.setStuPrize("w");
    	resume.setStuSkill("w");
    	resume.setStuSkillLab("w");
    	try{
    		flag = ResumeDaoFactory.getIResumeDaoInstance().changeAll(resume);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	if(flag == true){
    		System.out.println("true");
    	}else{
    		System.out.println("false");
    	}
	}

}
