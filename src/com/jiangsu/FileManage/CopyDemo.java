package com.jiangsu.FileManage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {

	/**
	 * 文件夹拷贝
	 * 从键盘接收两个文件夹路径，把其中一个文件夹的拷贝到另一个文件夹中
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File src = SizeDemo.getDir();
		File dest = SizeDemo.getDir();
		copy(src,dest);
	}
	
	/**
	 * 拷贝文件夹(源文件夹和目标文件夹不能是同一个)
	 * @param src  源文件夹
	 * @param dest 目标文件夹
	 * @throws IOException 
	 */
	public static void copy(File src,File dest) throws IOException {
		 if(src.equals(dest)){
			 System.out.println("源文件夹和目标文件夹不能是同一个");  //自己拷贝自己会导致不断创建，只到内存耗尽，蓝屏
			 return;
		 }
		 File newDir = new File(dest,src.getName());//在新文件夹创建文件夹
		 newDir.mkdir();
		 File[] subFiles = src.listFiles();
		 for(File subFile : subFiles){
			 if(subFile.isFile()){
				 BufferedInputStream bis = new BufferedInputStream(new FileInputStream(subFile));
				 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(newDir,subFile.getName())));
				 int b;
				 while((b=bis.read()) != -1){
					 bos.write(b);
				 }
				 bis.close();
				 bos.close();
			 }else{
				 copy(subFile,newDir);  //如果是文件夹，源文件夹是 subFile,目标文件夹是：newDir
			 }
		 }
	}

}
