package edu.nuaa.dao;

import java.util.List;

import edu.nuaa.vo.Resume;

public interface IResumeDao {
	/**
	 * @author: wch
	 * class : Resume
	 * */
	/**
	 * 简历数据的增添操作，以doCreate命名
	 * @param Resume 要添加的数据对象
	 * @return 是否添加成功
	 * @throws Exception 有异常交给调用方处理
	 * */
	public boolean doCreate(Resume resume) throws Exception;
	
	/**
	 * 删除操作 doDelete
	 * @param Resume 要删除的对象
	 * @return 是否删除成功
	 * @throws Exception 有异常调用方处理
	 * */
	public boolean doDelete(Resume resume) throws Exception;
	
	/**
	 * 更改操作
	 * 这里是指更改全部信息，即相当于查找到之后删除之后重建
	 * @param stuId 查找到要删除的resume类
	 * @return 是否更改成功
	 * @throws Exception
	 * */
	public boolean changeAll(Resume resume) throws Exception;
	
	/**
	 * 查找操作 按照关键字查找 findByKeyword
	 * @param keyword 要查找的关键字
	 * @return Resume的序列List<Resume>
	 * @throws Exception
	 * */
	public List<Resume> findByKeyword(String keyword) throws Exception;
	
	/**
	 * 查找一条数据
	 * @param stuId 按照账号查找
	 * @return Resume
	 * @throws Exception
	 * */
	public Resume findById(int stuId) throws Exception;
	
	/**
	 * 设置技能标签
	 * @param Resume对象
	 * @return boolean
	 * @throws Exception
	 * */
	public boolean setSkillLab(Resume resume) throws Exception;
	
	
	/**
	 * 学生个人信息的skill里的关键字同步到resume中的skilllab
	 * @param resume 填写完个人信息时，前端询问是否同步到简历中的skillLab中
	 * @return boolean
	 * @throws
	 * */
	public boolean syncSkillLab(Resume resume) throws Exception;
	
	/**
	 * 查找适合工作
	 * @param 根据薪资等一系列要求，查找适合自己的工作
	 * @return 
	 * @throws Exception
	 * */
	public List<Integer> findSuitJob(Resume resume, int MaxSal,int MinSal,String Type) throws Exception;
}
