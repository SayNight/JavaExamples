package com.saynight.threadpool;

public class WorkThread implements Runnable{
	@Override
	public void run() {
		while (true) {
			try {
				WorkEvent workEvent = WorkQueue.getQueue().take();
				workEvent.setNum();//任务执行次数+1
				System.out.println("ThreadName["  +  Thread.currentThread().getName() +  "], 获取到workEvent，workNo=[" + workEvent.getWorkNo() + "], ready handle");
				EventHandler.handle(workEvent);
				System.out.println("ThreadName["  +  Thread.currentThread().getName() +  "], 获取到workEvent，workNo=[" + workEvent.getWorkNo() + "], finish handle");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
