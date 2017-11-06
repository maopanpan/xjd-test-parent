package com.hz.xjd.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletResponse;

public class FileUtil {

	/**
	 * 保存文件
	 * @param file
	 * @param filepath
	 */
	public static void saveFile(File file, String filepath) {
		try {
			saveFile(new FileInputStream(file), filepath);
		} catch (Exception e) {
			System.out.println("File not found: " + file + ". " + e);
			e.printStackTrace();
		}
	}

	/**
	 * 保存文件
	 * @param ins
	 * @param filepath
	 */
	public static void saveFile(InputStream ins, String filepath) {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			int pos = filepath.lastIndexOf('/');
			File folder = new File(filepath.substring(0, pos));
			if (!folder.exists()) {//文件夹不存在，新建
				folder.mkdirs();
			}
			in = new BufferedInputStream(ins);
			out = new BufferedOutputStream(new FileOutputStream(filepath));
			byte[] b = new byte[8096];
			int i;
			while ((i = in.read(b)) != -1) {//写文件
				out.write(b, 0, i);
			}
			out.flush();
		} catch (IOException e) {
			System.out.println("Error occur when save file to disk " + filepath + ": " + e);
		} finally {//关闭输入，输出流
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException localIOException1) {
			}
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException localIOException1) {
			}
		}
	}

	/**
	 * 保存文件
	 * @param file
	 * @param type
	 * @param filename
	 * @return
	 */
	public static String saveFile(File file, String type, String filename) {
		return saveFile(file,null,type,filename);
	}

	/**
	 * 保存文件
	 * @param ins
	 * @param type
	 * @param filename
	 * @return
	 */
	public static String saveFile(InputStream ins, String type, String filename) {
		return saveFile(null,ins,type,filename);
	}

	/**
	 * 保存文件
	 * @param file
	 * @param ins
	 * @param type
	 * @param filename
	 * @return
	 */
	private static String saveFile(File file ,InputStream ins, String type, String filename) {
		String root = SystemConfig.getProperty("UPLOAD_ROOT_PATH");
		if ((root == null) || (root.trim().length() == 0)) {
			root = SystemConfig.getAppAbsPath();
		}

		String filepath = root + "/upload/" + type + "/" + filename;
		String approot = SystemConfig.getProperty("app.root", "/");
		filepath = filepath.replace(approot, "/");
		if (file != null) {
			saveFile(file, filepath);
		}
		if (ins != null) {
			saveFile(ins, filepath);
		}
		return "/upload/" + type + "/" + filename;
	}

	public static String readFromFile(String filePath) {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String line = reader.readLine();
			if (line != null) {
				sb.append(line);
			}
			while ((line = reader.readLine()) != null) {
				sb.append("\n" + line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			}
				catch (Exception localException1) {
			}
		}
		return sb.toString();
	}

	public static void writeToFile(String content, String filePath) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
			writer.write(content);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception localException1) {
			}
		}
	}

	public static void downloadFile(HttpServletResponse response, String filename, File file) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			response.addHeader("Content-Disposition", "attachment;filename=" +
			new String(filename.getBytes("GBK"), "ISO-8859-1"));
			response.setContentType("application/octet-stream");
			bos = new BufferedOutputStream(response.getOutputStream());
			bis = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[8192];
			int i;
			while ((i = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, i);
			}
			bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
