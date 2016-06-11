package com.qkn.automation.utilities;

public class TestConstants {
	private static int waitTimemultiplier;
	
	public static final int MAXSLEEPTIME = 10000*waitTimemultiplier; // that is 10 seconds
	public static final int MINSLEEPTIME = 2000*waitTimemultiplier; // 2 seconds
	public static final int NOMINALSLEEPTIME = 5000*waitTimemultiplier;//5 SECONDS
	
	public static int getWaitTimemultiplier() {
		return waitTimemultiplier;
	}
	public static void setWaitTimemultiplier(int waitTimemultiplier) {
		System.out.println("The sleep time is multiplied by "+waitTimemultiplier);
		TestConstants.waitTimemultiplier = waitTimemultiplier;
	}
	
	
	

}
