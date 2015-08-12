package com.momo.service;

import com.momo.service.interfaces.Service;

public class ServiceLocator {
	private static Cache cache;

	   static {
	      cache = new Cache();		
	   }

	   public static Service getService(String jndiName){

		   Service serviceFromCache = cache.getService(jndiName);

	      if(serviceFromCache != null){
	         return serviceFromCache;
	      }

	      InitialContext context = new InitialContext();
	      Service service = (Service)context.lookup(jndiName);
	      cache.addService(jndiName,service);
	      return service;
	   }
	}
