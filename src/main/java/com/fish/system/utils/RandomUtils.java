package com.fish.system.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName RandomUtils
 * @Description 随机生成字符串的工具类
 * @Author 柚子茶
 * @Date 2021/3/1 12:47
 * @Version 1.0
 */
public class RandomUtils {

	private static Random random = new Random();

	/**
	 * 获取到系统的当前时间
	 * @return
	 */
	public static String getSystemTime(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(new Date());
	}


	/**
	 * 使用时间+四位随机数生成的随机文件名
	 * @param fileName
	 * @return
	 */
	public static String createRandomFileNameByTime(String fileName,String suffix){

		//创建时间的格式化对象
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

		int index = fileName.lastIndexOf(".");
		int fileLength = fileName.length();
		String fileExtension = fileName.substring(index, fileLength);

		//随机生成四位随机数字
		int num = random.nextInt(9000)+1000;
		//获取到当前的时间并且对当前的时间进行格式化
		String time = simpleDateFormat.format(new Date());
		return time+num+fileExtension+suffix;
	}

	/**
	 * 使用时间+四位随机数生成的随机文件名
	 * @param fileName
	 * @return
	 */
	public static String createRandomFileNameByTime(String fileName){

		//创建时间的格式化对象
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

		int index = fileName.lastIndexOf(".");
		int fileLength = fileName.length();
		String fileExtension = fileName.substring(index, fileLength);

		//随机生成四位随机数字
		int num = random.nextInt(9000)+1000;
		//获取到当前的时间并且对当前的时间进行格式化
		String time = simpleDateFormat.format(new Date());
		return time+num+fileExtension;
	}

	/**
	 * 使用时间+4位随机数生成单号
	 * @param numberedHead
	 */
	public static String createRandomNumberByTime(String numberedHead) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String newTime = simpleDateFormat.format(new Date());
		int num = random.nextInt(9000)+1000;
		return numberedHead+newTime+num;
	}


	/**
	 * 使用UUID生成的随机文件名
	 * @param fileName
	 * @return
	 */
	public static String createRandomFileNameByUUID(String fileName){

		/**
		 * 得到文件的后缀名称
		 * @Param fileExtension 文件扩展名
		 */
		int index = fileName.lastIndexOf(".");
		int fileLength = fileName.length();
		String fileExtension = fileName.substring(index, fileLength);
		return UUID.randomUUID().toString().replace("-","").substring(0,16).toUpperCase()+fileExtension;
	}


}
