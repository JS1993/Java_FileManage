package com.jiangsu.FileManage;

import java.io.File;

public class PrintDemo {

	/**
	 * 从键盘接收一个文件夹路径，把文件夹中的所有文件以及文件夹的名字按层级打印
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = SizeDemo.getDir();
		printLev(dir,0);
	}

	private static void printLev(File dir,int lev) {
		File[] subFiles = dir.listFiles();
		for(File subFile : subFiles){
			for(int i=0 ;i<=lev;i++){    					//显示层级缩进
				System.out.println("\t");
			}
			System.out.println(subFile);
			if(subFile.isDirectory()){
				printLev(subFile,lev+1);
			}
		}
		
	}

}
