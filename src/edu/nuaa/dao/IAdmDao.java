package edu.nuaa.dao;

import java.util.List;

import edu.nuaa.vo.SkillTable;

public interface IAdmDao {
    public boolean doCreate(SkillTable skilltable) throws Exception;
	
	public boolean doDeleteById(int skiId) throws Exception;
	
	public boolean doChangeName(int skiId, String skiName) throws Exception;
	
	public SkillTable doFindById(int skiId) throws Exception;
	
	public List<SkillTable> doFindAll() throws Exception;
}
