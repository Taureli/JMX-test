package com.jakub.myjmx.mbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class UpdateList extends NotificationBroadcasterSupport implements UpdateListMBean {

	private static UpdateList upd = new UpdateList();
	private static List<Integer> allElements = new ArrayList<Integer>();
	private static int counter = 0;
	
	public static UpdateList getInstance(){
		return upd;
	}

	@Override
	public void addElement() {
		List<Integer> temp = allElements;
		
		Random rand = new Random();
		allElements.add(rand.nextInt(100));
		
		Notification notification = new AttributeChangeNotification(upd, counter++, System.currentTimeMillis(),
									"New element on list.", "allElements", "List<Integer>", 
									temp, allElements);
			
		sendNotification(notification);
	}
	
	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };
		
		String name = AttributeChangeNotification.class.getName();
		String description = "New element added to the list";
		MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);

		return new MBeanNotificationInfo[] { info };
	}

	@Override
	public List<Integer> getElements() {
		return allElements;
	}
	
}
