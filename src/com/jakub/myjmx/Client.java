package com.jakub.myjmx;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.AttributeChangeNotification;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.jakub.myjmx.mbean.UpdateListMBean;

public class Client {

	public static void main(String[] args) throws Exception{
		
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        ObjectName mxbeanName = new ObjectName("com.jakub.myjmx:type=UpdateList");
        
        NotificationListener listener = new NotificationListener() {
			@Override
			public void handleNotification(Notification notification, Object obj) {

				if (notification instanceof AttributeChangeNotification) {
					AttributeChangeNotification acn = (AttributeChangeNotification) notification;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
					Date date = new Date(acn.getTimeStamp());
					sdf.format(date);
					System.out.println(notification.getMessage() + " Updated on " + sdf.format(date));
					System.out.println("List before change: " + acn.getOldValue());
					System.out.println("List after update: " + acn.getNewValue());
				}
			}
		};
		
        mbsc.addNotificationListener(mxbeanName, listener, null, null);
		UpdateListMBean counterProxy = JMX.newMBeanProxy(mbsc, mxbeanName, UpdateListMBean.class);
        
        System.in.read();
        
	}
	
}
