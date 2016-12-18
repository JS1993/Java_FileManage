package com.jiangsu.FileManage;

import java.io.File;
import java.util.Scanner;

public class SizeDemo {

	/**
	 * 从键盘接收一个文件夹路径，统计该文件夹的大小
	 * @param args
	 */
	public static void main(String[] args) {
		File file = getDir();
		System.out.println(getFileLength(file));       //直接获取文件夹的大小结果是0
	}

	/**
	 * 从键盘接收一个文件夹路径
	 * @return 文件夹路径
	 */
	public static File getDir(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个文件夹路径");
		while(true){
			String line = sc.nextLine();
			File dir = new File(line);
			if(!dir.exists()){
				System.out.println("您录入的文件夹路径不存在，请输入一个文件夹路径");
			}else if(dir.isFile()){
				System.out.println("您录入的是一个文件路径，请输入一个文件夹路径");
			}else{
				sc.close();
				return dir;
			}
		}
	}
	
	/**
	 * 统计该文件夹的大小
	 * @param dir  文件夹路径
	 * @return  文件夹大小
	 */
	public static long getFileLength(File dir){
		long len = 0;
		File[] subFiles = dir.listFiles();
		for(File subFile : subFiles){
			if(subFile.isFile()){
				len = len + subFile.length();
			}else{
				len = len + getFileLength(subFile);
			}
		}
		return len;
	}
	
}











