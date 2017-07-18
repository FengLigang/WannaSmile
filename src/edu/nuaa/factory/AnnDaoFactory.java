package edu.nuaa.factory;

import edu.nuaa.dao.IAnnDao;
import edu.nuaa.dao.proxy.AnnDaoProxy;


public class AnnDaoFactory {
	public static IAnnDao getIAnnDaoInstance(){
		return new AnnDaoProxy();
	}
}
