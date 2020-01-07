package com.practice.threads.concurrency;

import java.io.File;
import java.util.concurrent.Callable;

public class FileCountTask implements Callable{
	File dir;
	long fileCount =0;
	
	public FileCountTask(File dir){
		this.dir = dir;
	}
	
	private void doCount(File parent){
		if(!parent.exists()){
			return;
		}
		File[] children = parent.listFiles();
		if(children == null){
			return;
		}
		for(File child: children){
			if(child.isDirectory()){
				doCount(child);
			} else if(child.isFile()){
				fileCount++;
			}
		}
	}
	
	public Long call() throws Exception{
		System.out.println("Start Counting " + dir);
		doCount(dir);
		System.out.println("Finished Counting " + dir);
		return fileCount;
	}
	
	
}
