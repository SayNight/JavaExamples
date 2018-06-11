package com.saynight.threadpool.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.saynight.threadpool.ExtThreadPoolExecutor;

public class Index {
	public static void main(String[] args) {
		ExtThreadPoolExecutor executor = new ExtThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		WorkCallable callable = new WorkCallable();
		callable.setRequestId(System.currentTimeMillis());
		Future<Result> future = executor.submit(callable);
		Result result = null;
		try {
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result == null ? null : String.format("code[%s],message[%s]", result.getCode(), result.getMessage()));
	}
}
