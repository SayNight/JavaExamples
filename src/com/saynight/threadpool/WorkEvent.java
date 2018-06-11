package com.saynight.threadpool;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkEvent implements Serializable{
	
	private static final long serialVersionUID = -1739230985770176506L;

	/**
	 * 任务编号
	 */
	private String workNo;
	
	/**
	 * 执行次数
	 */
	private AtomicInteger num;
	
	public WorkEvent(String workNo) {
		this.workNo = workNo;
		this.num = new AtomicInteger(0);
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public AtomicInteger getNum() {
		return num;
	}

	public void setNum() {
		this.num.incrementAndGet();
	}
	
}
