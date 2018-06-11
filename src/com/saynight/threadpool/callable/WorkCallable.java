package com.saynight.threadpool.callable;

import java.util.concurrent.Callable;

public class WorkCallable implements Callable<Result>{
	
	private long requestId;
	
	@Override
	public Result call() throws Exception {
		System.out.println(String.format("处理任务，requestId【%s】", requestId));
		Result result = new Result();
		result.setCode(200);
		result.setMessage("SUCCESS");
		return result;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

}
