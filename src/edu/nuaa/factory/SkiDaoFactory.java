package edu.nuaa.factory;

import edu.nuaa.dao.ISkiDao;
import edu.nuaa.dao.proxy.SkiDaoProxy;;

public class SkiDaoFactory {

	public static ISkiDao getISkiDaoInstance()throws Exception{
		return new SkiDaoProxy();
	}

}
