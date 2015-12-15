package com.nssoft.util;

import org.apache.log4j.Logger;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

import com.nssoft.exception.ApiException;
import com.nssoft.exception.ParamException;

/**   
 *
 * @ClassName ZipUtil
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年4月13日 下午3:22:36    
 * @version V1.0      
 *    
 */
public class ZipUtil {
	
	private static final Logger logger = Logger.getLogger(ZipUtil.class);

	public static final String EXT = ".zip";
	private static final int BUFFER = 1024;
	
	public static boolean compress(String srcPathName, File zipFile, String includes, String excludes) {
		return compressFun(srcPathName, zipFile, includes, excludes);
	}
	
	public static boolean compress(String srcPathName, File zipFile) {
		return compressFun(srcPathName, zipFile, null, null);
	}
	
	public static boolean compress(String srcPathName, String targetSrc, String includes, String excludes) {
		String targetName = "";
		String targetSrc_temp = srcPathName;
		if (targetSrc_temp.lastIndexOf("/") == targetSrc_temp.length() - 1) {
			targetSrc_temp = targetSrc.substring(0, targetSrc_temp.length());
		}
		targetName = targetSrc_temp.substring(targetSrc_temp.indexOf("/"), targetSrc_temp.length()) + ".zip";
		File zipFile = new File(targetSrc, targetName);
		return compressFun(srcPathName, zipFile, includes, excludes);
	}
	
	public static boolean compress(String srcPathName, String targetSrc) {
		String targetName = "";
		String targetSrc_temp = srcPathName;
		if (targetSrc_temp.lastIndexOf("/") == targetSrc_temp.length() - 1) {
			targetSrc_temp = targetSrc.substring(0, targetSrc_temp.length());
		}
		targetName = targetSrc_temp.substring(targetSrc_temp.indexOf("/"), targetSrc_temp.length()) + ".zip";
		File zipFile = new File(targetSrc, targetName);
		return compressFun(srcPathName, zipFile, null, null);
	}
	
	public static boolean compress(String srcPathName) {
		String targetName = "";
		String targetSrc = srcPathName;
		if (targetSrc.lastIndexOf("/") == targetSrc.length() - 1) {
			targetSrc = targetSrc.substring(0, targetSrc.length());
		}
		targetName = targetSrc.substring(targetSrc.indexOf("/"), targetSrc.length()) + ".zip";
		targetSrc = targetSrc.substring(0, targetSrc.indexOf("/"));
		File zipFile = new File(targetSrc, targetName);
		return compressFun(srcPathName, zipFile, null, null);
	}
	
	public static File compressToFile(String srcPathName, String targetSrc) {
		String targetName = "";
		String targetSrc_temp = srcPathName;
		if (targetSrc_temp.lastIndexOf("/") == targetSrc_temp.length() - 1) {
			targetSrc_temp = targetSrc.substring(0, targetSrc_temp.length());
		}
		targetName = targetSrc_temp.substring(targetSrc_temp.indexOf("/"), targetSrc_temp.length()) + ".zip";
		File zipFile = new File(targetSrc, targetName);
		compressFun(srcPathName, zipFile, null, null);
		return zipFile;
	}
	
	public static File compressToFile(String srcPathName) {
		String targetName = "";
		String targetSrc = srcPathName;
		if (targetSrc.lastIndexOf("/") == targetSrc.length() - 1) {
			targetSrc = targetSrc.substring(0, targetSrc.length());
		}
		targetName = targetSrc.substring(targetSrc.indexOf("/"), targetSrc.length()) + ".zip";
		targetSrc = targetSrc.substring(0, targetSrc.indexOf("/"));
		File zipFile = new File(targetSrc, targetName);
		compressFun(srcPathName, zipFile, null, null);
		return zipFile;
	}
	
    private static boolean compressFun(String srcPathName, File zipFile, String includes, String excludes) {  
        Boolean success = true;
        try {
        	  	 File srcdir = new File(srcPathName);  
             if (!srcdir.exists())  
                 throw new ApiException(srcPathName + "不存在!");  
             Project prj = new Project();  
             Zip zip = new Zip();  
             zip.setProject(prj);  
             zip.setDestFile(zipFile); 
             FileSet fileSet = new FileSet();  
             fileSet.setProject(prj);  
             fileSet.setDir(srcdir); 
             if (includes != null)
             		fileSet.setIncludes(includes);
             if (excludes != null)
             		fileSet.setExcludes(excludes);
             //fileSet.setIncludes("**/*.java"); 包括哪些文件或文件夹 eg:zip.setIncludes("*.java");  
             //fileSet.setExcludes(...); 排除哪些文件或文件夹  
             zip.addFileset(fileSet);  
             zip.execute();  
        } catch (Exception e) {
        		success = false;
        		logger.error(e.getMessage());
        		throw new ParamException(e.getMessage());
        }
        return success;
    }  
    
	/**
	 * 文件 解压缩
	 * 
	 * @param srcPath
	 *            源文件路径
	 * 
	 * @throws Exception
	 */
	public static void decompress(String srcPath) throws Exception {
		File srcFile = new File(srcPath);
		decompress(srcFile);
	}

	/**
	 * 解压缩
	 * 
	 * @param srcFile
	 * @throws Exception
	 */
	public static void decompress(File srcFile) throws Exception {
		String basePath = srcFile.getParent();
		decompress(srcFile, basePath);
	}

	/**
	 * 解压缩
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws Exception
	 */
	public static void decompress(File srcFile, File destFile) throws Exception {
		CheckedInputStream cis = new CheckedInputStream(new FileInputStream(
				srcFile), new CRC32());
		ZipInputStream zis = new ZipInputStream(cis);
		decompress(destFile, zis);
		zis.close();
	}

	/**
	 * 解压缩
	 * 
	 * @param srcFile
	 * @param destPath
	 * @throws Exception
	 */
	public static void decompress(File srcFile, String destPath)
			throws Exception {
		decompress(srcFile, new File(destPath));
	}

	/**
	 * 文件 解压缩
	 * 
	 * @param srcPath
	 *            源文件路径
	 * @param destPath
	 *            目标文件路径
	 * @throws Exception
	 */
	public static void decompress(String srcPath, String destPath)
			throws Exception {
		File srcFile = new File(srcPath);
		decompress(srcFile, destPath);
	}

	/**
	 * 文件 解压缩
	 * 
	 * @param destFile
	 *            目标文件
	 * @param zis
	 *            ZipInputStream
	 * @throws Exception
	 */
	private static void decompress(File destFile, ZipInputStream zis)
			throws Exception {
		ZipEntry entry = null;
		while ((entry = zis.getNextEntry()) != null) {
			// 文件
			String dir = destFile.getPath() + File.separator + entry.getName();
			File dirFile = new File(dir);
			// 文件检查
			fileProber(dirFile);
 			if (entry.isDirectory()) {
 				dirFile.mkdirs();
 			} else {
 				decompressFile(dirFile, zis);
 			}
 			zis.closeEntry();
 		}
 	}

	/**
	 * 文件探针
	 * 
	 * 
	 * 当父目录不存在时，创建目录！
	 * 
	 * 
	 * @param dirFile
	 */
	private static void fileProber(File dirFile) {
		File parentFile = dirFile.getParentFile();
		if (!parentFile.exists()) {
			// 递归寻找上级目录
			fileProber(parentFile);
			parentFile.mkdir();
		}

	}
	/**
	 * 文件解压缩
	 * 
	 * @param destFile
	 *            目标文件
	 * @param zis
	 *            ZipInputStream
	 * @throws Exception
	 */
	private static void decompressFile(File destFile, ZipInputStream zis)
			throws Exception {
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));
		int count;
		byte data[] = new byte[BUFFER];
		while ((count = zis.read(data, 0, BUFFER)) != -1) {
			bos.write(data, 0, count);
		}
		bos.close();
	}
}
