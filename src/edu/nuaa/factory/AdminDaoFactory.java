package edu.nuaa.factory;

import edu.nuaa.dao.IAdmDao;
import edu.nuaa.dao.proxy.AdminDaoProxy;

public class AdminDaoFactory {
    public static IAdmDao getIAdmDaoInstance() throws Exception{
    	return new AdminDaoProxy();
    }
}
