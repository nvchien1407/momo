package com.momo.service.interfaces;
/**
 * Created with IntelliJ IDEA.
 * User: cnguyen
 * Date: 8/12/15
 * Time: 11:36 AM
 * This interface implement the ServiceLocator pattern described at 
 * http://www.tutorialspoint.com/design_pattern/service_locator_pattern.htm
 * There is also an article about EJB3 kill it of 
 * http://www.javalobby.org/articles/service-locator/?source=archives
 */

public interface Service {
	public String getName();
	public void execute();
}
