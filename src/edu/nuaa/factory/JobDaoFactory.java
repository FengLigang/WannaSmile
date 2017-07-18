package edu.nuaa.factory;

import edu.nuaa.dao.JobDao;

import edu.nuaa.dao.proxy.JobDaoproxy;

public class JobDaoFactory {
	public static JobDao getJobDaoInstance()throws Exception{
		return new JobDaoproxy();
}
}