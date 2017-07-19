package edu.nuaa.TestStu;

import java.util.List;

import edu.nuaa.factory.ResumeDaoFactory;
import edu.nuaa.factory.SkiDaoFactory;
import edu.nuaa.factory.StuDaoFactory;
import edu.nuaa.vo.Resume;
import edu.nuaa.vo.SkillTable;
import edu.nuaa.vo.Student;



public class TestStu2 {
	public static void main(String []args) throws Exception{
//		int stuId = 161520203;
//		Resume resume = new Resume();
//		resume = StuDaoFactory.getIstuDaoInstance().doGetResume(stuId);
//		System.out.println(resume.getResId());
//		System.out.println(resume.getStuId());
		//doSetSkiLab(int stuId)
		
////		SkillTable skilltable = new SkillTable();
//		int stuId = 161520203;
//		boolean flag = false;
//		flag = StuDaoFactory.getIstuDaoInstance().doSetSkiLab(stuId);
//		System.out.println(flag);
		
		int stuId = 161520209;
		
		List<Integer> flag = StuDaoFactory.getIstuDaoInstance().doWatchFocusJob(stuId);
		System.out.println(flag);
	}
}
