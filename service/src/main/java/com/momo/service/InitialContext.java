package com.momo.service;

import com.momo.service.impl.TaskServiceImpl;
import com.momo.service.impl.TestServiceImpl;
import com.momo.service.util.ServiceConstants;

/**
 * Created with IntelliJ IDEA.
 * User: cnguyen
 * Date: 8/12/15
 * Time: 11:36 AM
 * InitialContext to lookup JNDI name
 */
public class InitialContext {
	public Object lookup(String jndiName){
		   
	      if(ServiceConstants.TASK_SERVICE.equalsIgnoreCase(jndiName)){
	         return new TaskServiceImpl();
	      }
	      else if (ServiceConstants.TEST_SERVICE.equalsIgnoreCase(jndiName)){
	         return new TestServiceImpl();
	      }
	      return null;		
	   }
}
