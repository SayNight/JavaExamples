package com.saynight.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class WorkQueue {
	
	private volatile static BlockingQueue<WorkEvent> queue;
	
	private WorkQueue(){}
	
	/**
	 * 初始化队列，延迟初始化，其实也可使用内部类单例模式
	 */
	private static void init(){
		
		if(queue == null){
			System.out.println("WorkQueue.queue null  init........");
			synchronized (WorkQueue.class) {
				System.out.println("WorkQueue.queue after synchronized still null  init........");
				if (queue == null) {
					queue = new LinkedBlockingDeque<WorkEvent>();
				}
			}
		}
	}
	
	public static  void putWorkEvent(WorkEvent workEvent){
		init();
		try {
			queue.put(workEvent);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("WorkQueue.putWorkEvent  fail........");
		}
	}

	public static BlockingQueue<WorkEvent> getQueue() {
		return queue;
	}
	
}
