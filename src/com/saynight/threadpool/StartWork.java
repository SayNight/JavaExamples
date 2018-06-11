package com.saynight.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class StartWork {
	public static void main(String[] args) {

		System.out.println("准备放任务线程");
		int workNum = 6;
		for (int i = 0; i < workNum; i++) {
			WorkEvent workEvent = new WorkEvent("任务线程" + i);
			WorkQueue.putWorkEvent(workEvent);
		}

		// 初始化线程池
		ExtThreadPoolExecutor executor = new ExtThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		// 先准备工作线程
		System.out.println("准备五个工作线程");
		executor.execute(new WorkThread());
		executor.execute(new WorkThread());
		executor.execute(new WorkThread());
		executor.execute(new WorkThread());
		executor.execute(new WorkThread());
		
		System.out.println("休息10s");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("10s后 。。。 准备放任务线程");
		for (int i = 0; i < workNum; i++) {
			WorkEvent workEvent = new WorkEvent("10s 后 任务线程" + i);
			WorkQueue.putWorkEvent(workEvent);
		}
	}
}
