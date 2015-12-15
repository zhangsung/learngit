package com.nssoft.util;
/**   
 *
 * @ClassName ZipCipherUtil
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年4月13日 下午5:44:12    
 * @version V1.0      
 *    
 */
import java.io.File;
import java.util.UUID;

public class ZipCipherUtil {
	/**
	 * 对目录srcFile下的所有文件目录进行先压缩后加密,然后保存为destfile
	 * 
	 * @param srcFile
	 *            要操作的文件或文件夹
	 * @param destfile
	 *            压缩加密后存放的文件
	 * @param keyfile
	 *            密钥
	 */
	public void encryptZip(String srcFile, String destfile, String keyStr) throws Exception {
		File temp = new File(UUID.randomUUID().toString() + ".zip");
		temp.deleteOnExit();
		// 先压缩文件
		ZipUtil.compress(srcFile, temp);
		// 对文件加密
		new CipherUtil().encrypt(temp.getAbsolutePath(), destfile, keyStr);
		temp.delete();
	}

	/**
	 * 对文件srcfile进行先解密后解压缩,然后解压缩到目录destfile下
	 * 
	 * @param srcfile
	 *            要解密和解压缩的文件名 
	 * @param destfile
	 *            解压缩后的目录
	 * @param publicKey
	 *            密钥
	 */
	public void decryptUnzip(String srcfile, String destfile, String keyStr) throws Exception {
		File temp = new File(UUID.randomUUID().toString() + ".zip");
		temp.deleteOnExit();
		// 先对文件解密
		new CipherUtil().decrypt(srcfile, temp.getAbsolutePath(), keyStr);
		// 解压缩
		ZipUtil.decompress(srcfile, destfile);
		temp.delete();
	}
	
	public static void main(String[] args) throws Exception {
		long l1 = System.currentTimeMillis();
		
		//加密
//		new ZipCipherUtil().encryptZip("d:\\test\\111.jpg", "d:\\test\\photo.zip", "12345");
		//解密
//		new ZipCipherUtil().decryptUnzip("d:\\test\\photo.zip", "d:\\test\\111_1.jpg", "12345");
		
		long l2 = System.currentTimeMillis();
		System.out.println((l2 - l1) + "毫秒.");
		System.out.println(((l2 - l1) / 1000) + "秒.");
	}
}

