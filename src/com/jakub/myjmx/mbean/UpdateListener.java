package com.jakub.myjmx.mbean;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class UpdateListener {
	
	public UpdateListener() throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName objectName = new ObjectName("com.jakub.myjmx:type=UpdateList");
		UpdateList mbean = UpdateList.getInstance();
		
		mbs.registerMBean(mbean, objectName);
	}
	
}
