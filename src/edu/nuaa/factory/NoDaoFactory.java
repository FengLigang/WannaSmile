package edu.nuaa.factory;

import edu.nuaa.dao.IResumeDao;
import edu.nuaa.dao.proxy.ResumeDaoProxy;

public class NoDaoFactory {
	public static IResumeDao getIResumeDaoInstance() throws Exception{
		return new ResumeDaoProxy();
	}
}
