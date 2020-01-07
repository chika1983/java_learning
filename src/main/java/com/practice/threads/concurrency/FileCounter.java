package com.practice.threads.concurrency;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileCounter {
	
	public static void main(String args[]){
		String [] dirs = { 
				"C:\\Users\\Anand Ram\\Downloads\\Anand",
				"C:\\Users\\Anand Ram\\Downloads\\Dhanya"
		};
		ExecutorService executorService = Executors.newFixedThreadPool(dirs.length);
		Future<Long> [] results = new Future[dirs.length];
		for(int i =0 ; i<dirs.length; i++){
			File dir = new File(dirs[i]);
			FileCountTask task = new FileCountTask(dir);
			results[i] = executorService.submit(task);
		}
		
		//print result
		for(int i=0; i<dirs.length; i++){
			long fileCount =0L;
			try{
				fileCount = results[i].get();
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}catch(ExecutionException ee){
				ee.printStackTrace();
			}
			System.out.println(dirs[i] + " contains " + fileCount + " files.");
		}
		
		executorService.shutdownNow();
	}
}
