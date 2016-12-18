package com.jiangsu.FileManage;

import java.io.File;


public class DeleteDemo {

	/**
	 * 删除文件夹
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = SizeDemo.getDir();
		 deleteFile(dir);
	}
	
	/**
	 * 删除文件夹
	 * @param dir 文件夹路径
	 */
	public static void deleteFile(File dir){
		File[] subFiles = dir.listFiles();
		for (File subFile : subFiles){
			if(subFile.isFile()){
				subFile.delete();
			}else{
				deleteFile(subFile);
			}
		}
		dir.delete();//循环结束后把自己删除
	}

}
