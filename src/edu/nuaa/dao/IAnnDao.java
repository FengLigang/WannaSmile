package edu.nuaa.dao;

import java.util.List;

import edu.nuaa.vo.Announce;

public interface IAnnDao {
	public boolean doCreate(Announce ann ) throws Exception;
	
	public boolean doDelete(int annId ) throws Exception;
	
	public Announce doFindByid(int annId ) throws Exception;
	
	public boolean doChange(Announce ann ) throws Exception;
	
	public List<Announce> findByKeyword(String keyword) throws Exception;

}
