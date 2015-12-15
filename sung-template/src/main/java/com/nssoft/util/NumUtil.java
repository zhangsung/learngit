package com.nssoft.util;

import java.util.regex.Pattern;

/**
 *
 * @ClassName NumUtil
 * @Description Copyright (c) 2014 by NS Soft.
 * @author xuliguo
 * @date 2015年3月12日 上午10:20:47
 * @version V1.0
 * 
 */
public class NumUtil {
	public static final String[] enNum = { // 基本数词表
	"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT",
			"NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN",
			"FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN",
			"TWENTY", "", "", "", "", "", "", "", "", "", "THIRTY", "", "", "",
			"", "", "", "", "", "", "FOURTY", "", "", "", "", "", "", "", "",
			"", "FIFTY", "", "", "", "", "", "", "", "", "", "SIXTY", "", "",
			"", "", "", "", "", "", "", "SEVENTY", "", "", "", "", "", "", "",
			"", "", "EIGHTY", "", "", "", "", "", "", "", "", "", "NINETY" };

	public static final String[] enUnit = { "HUNDRED", "THOUSAND", "MILLION",
			"BILLION", "TRILLION", "QUINTILLION" }; // 单位表

	public static void main(String[] args) {
		System.out.println(toDollars("23232"));
		System.out.println(toDollars("34343.34"));
	}

	public static String toDollars (String num) {
		Pattern pattern1 = Pattern.compile("^\\d+$|-\\d+$"); // 就是判断是否为整数
		Pattern pattern2 = Pattern.compile("\\d+\\.\\d+$|-\\d+\\.\\d+$");//判断是否为小数
		if (pattern1.matcher(num).matches()) {
			return "U.S DOLLARS " + analyze(num) + " ONLY.";
		} else if (pattern2.matcher(num).matches()) {
			String [] nums = num.split("\\.");
			return "U.S DOLLARS " + analyze(nums[0]) + " CENTS " + analyze(nums[1]) + " ONLY.";
		} 
		return num;
	}
	
	public static String toCartons (String num) {
		Pattern pattern1 = Pattern.compile("^\\d+$|-\\d+$"); // 就是判断是否为整数
		if (pattern1.matcher(num).matches()) {
			return analyze(num);
		} 
		return num;
	}
	
	public static String analyze(long num) { // long型参数，
		return analyze(String.valueOf(num)); // 因为long型有极限，所以以字符串参数方法为主
	}

	public static String analyze(String num) { // 数字字符串参数
		// 判断字符串是否为数字
		if (!num.matches("\\d+")) {
			return String.format("%s is not number", num);
		}
		
		num = num.replaceAll("^[0]*([1-9]*)", "$1"); // 把字符串前面的0去掉

		if (num.length() == 0) { // 如果长度为0，则原串都是0
			return enNum[0];
		} else if (num.length() > 9) { // 如果大于9，即大于999999999，题目限制条件
			return "too big";
		}

		// 按3位分割分组
		int count = (num.length() % 3 == 0) ? num.length() / 3
				: num.length() / 3 + 1;
		if (count > enUnit.length) {
			return "too big";
		} // 判断组单位是否超过，
			// 可以根据需求适当追加enUnit
		String[] group = new String[count];
		for (int i = num.length(), j = group.length - 1; i > 0; i -= 3) {
			group[j--] = num.substring(Math.max(i - 3, 0), i);
		}

		StringBuilder buf = new StringBuilder(); // 结果保存
		for (int i = 0; i < count; i++) { // 遍历分割的组
			int v = Integer.valueOf(group[i]);
			if (v >= 100) { // 因为按3位分割，所以这里不会有超过999的数
				buf.append(enNum[v / 100]).append(" ").append(enUnit[0])
						.append(" ");
				v = v % 100; // 获取百位，并得到百位以后的数
				if (v != 0) {
					buf.append("AND ");
				} // 如果百位后的数不为0，则追加and
			}
			if (v != 0) { // 前提是v不为0才作解析
				if (v < 20 || v % 10 == 0) { // 如果小于20或10的整数倍，直接取基本数词表的单词
					buf.append(enNum[v]).append(" ");
				} else { // 否则取10位数词，再取个位数词
					buf.append(enNum[v - v % 10]).append("");
					buf.append(enNum[v % 10]).append(" ");
				}
				if (i != count - 1) { // 百位以上的组追加相应的单位
					buf.append(enUnit[count - 1 - i]).append(" ");
				}
			}
			//buf.append("(" + num + ") CARTONS OF");
			//buf.insert(0, "INVOICE OF ");
		}

		return buf.toString().trim(); // 返回值
	}
}
