package com.momo.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.momo.service.interfaces.Service;

public class Cache {
	private static final Logger LOGGER = LoggerFactory.getLogger(Cache.class);
	private Map<String, Service> serviceMap;

	public Cache() {
		serviceMap = Collections.synchronizedMap(new HashMap<String, Service>());
	}

	public Service getService(String serviceName) {

		if (serviceMap.containsKey(serviceName)) {
			LOGGER.info("Returning cached  " + serviceName + " object");
			return serviceMap.get(serviceName);
		}
		return null;
	}

	public void addService(String serviceName, Service newService) {
		serviceMap.put(serviceName, newService);
	}

}
