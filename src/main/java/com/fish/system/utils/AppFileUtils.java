package com.fish.system.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Properties;

/**
 * @ClassName AppFileUtils
 * @Description 文件上传的工具类
 * @Author 柚子茶
 * @Date 2021/3/1 12:36
 * @Version 1.0
 */
public class AppFileUtils {

	/**
	 * 得到文件上传的路径
	 */
	public static String PATH = "D:/upload/";
	static {
		InputStream stream = AppFileUtils.class.getClassLoader().getResourceAsStream("file.properties");
		Properties properties = new Properties();
		try {
			properties.load(stream);
			PATH = properties.getProperty("path");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param response 响应
	 * @param path     文件的相对路径
	 * @param oldName  文件原始名称
	 * @return ResponseEntity<Object>
	 * @description 下载服务器中的文件
	 * @author 柚子茶
	 * @date 2021/3/1 12:38
	 **/
	public static ResponseEntity<Object> downloadFile(HttpServletResponse response, String path, String oldName) {
		//4,使用绝对路径+相对路径去找到文件对象
		File file = new File(AppFileUtils.PATH, path);
		//5,判断文件是否存在
		if (file.exists()) {
			try {
				try {
					//如果名字有中文 要处理编码
					oldName = URLEncoder.encode(oldName, "UTF-8");
				} catch (Exception e) {
					e.printStackTrace();
				}
				//把file转成一个bytes
				byte[] bytes = FileUtils.readFileToByteArray(file);
				HttpHeaders header = new HttpHeaders();
				//封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
				header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				//设置下载的文件的名称
				header.setContentDispositionFormData("attachment", oldName);
				//创建ResponseEntity对象
				ResponseEntity<Object> entity =
						new ResponseEntity<Object>(bytes, header, HttpStatus.CREATED);
				return entity;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		} else {
			PrintWriter out;
			try {
				out = response.getWriter();
				out.write("文件不存在");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}


	/**
	 * @param path 文件路径
	 * @return void
	 * @description 根据文件路径删除上传到服务器的文件
	 * @author 柚子茶
	 * @date 2021/3/1 12:39
	 **/
	public static void deleteFileUsePath(String path) {
		File file = new File(PATH, path);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * @param filePath 文件相对路径
	 * @param suffix 需要修改的文件后缀
	 * @return String
	 * @description 更改文件后缀
	 * @author 柚子茶
	 * @date 2021/3/1 12:41
	 **/
	public static String modifyFileSuffix(String filePath, String suffix) {
		try {
			File file = new File(PATH, filePath);
			if (file.exists()) {
				file.renameTo(new File(PATH, filePath.replace(suffix, "")));
				String newFileName = filePath.replace(suffix, "");
				return newFileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
