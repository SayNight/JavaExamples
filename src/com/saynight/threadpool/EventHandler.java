package com.saynight.threadpool;

public class EventHandler {
	/**
	 * 处理业务
	 * @param workEvent
	 */
	public static void handle(WorkEvent workEvent){
		System.out.println("正在处理，workNo=[" + workEvent.getWorkNo() + "]");
	}
}
