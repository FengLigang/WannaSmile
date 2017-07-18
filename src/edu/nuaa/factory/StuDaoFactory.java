package edu.nuaa.factory;

import edu.nuaa.dao.IStuDao;
import edu.nuaa.dao.proxy.StuDaoProxy;

public class StuDaoFactory {
	public static IStuDao getIstuDaoInstance() throws Exception{
		return new StuDaoProxy();
	}
}
