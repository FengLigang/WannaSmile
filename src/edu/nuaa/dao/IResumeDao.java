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
	
	
}
