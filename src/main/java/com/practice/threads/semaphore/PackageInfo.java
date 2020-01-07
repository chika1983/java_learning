package com.practice.threads.semaphore;

class PackageInfo 
{
  public static void main(String[] args) 
  {
	  
	  System.out.println(getClassName(java.awt.Frame.class));
  }
  
  public static String getClassName(Class c) {
	    String className = c.getName();
	    int firstChar;
	    firstChar = className.lastIndexOf('.') + 1;
	    if (firstChar > 0) {
	      className = className.substring(firstChar);
	    }
	    return className;
	  }
}