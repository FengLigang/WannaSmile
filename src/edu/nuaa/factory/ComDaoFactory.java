package edu.nuaa.factory;

import edu.nuaa.dao.IComDao;
import edu.nuaa.dao.proxy.ComDaoProxy;



public class ComDaoFactory {
	
		public static IComDao getIComDaoInstance()throws Exception{
			return new ComDaoProxy();
		

	}

}
