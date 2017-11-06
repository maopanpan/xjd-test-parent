package com.hz.xjd.common.utils;

import java.util.Random;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils{
	private static final char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private static char[] charArr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
			'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z' };

	public static final String EMPTY = "";
    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

	/**
	 * 截取字符串
	 *
	 * @param input
	 * @param maxlength
	 * @param hasEllipsis
	 *            是否带省略...
	 * @return
	 */
	public static String truncate(String input, int maxlength, boolean hasEllipsis) {
		if ((input == null) || (input.length() <= maxlength)) {
			return input;
		}
		return input.substring(0, maxlength) + (hasEllipsis ? "..." : "");
	}

	public static boolean isEmpty(String input) {
		return (input == null) || (input.trim().length() == 0);
	}

	public static boolean isNotEmpty(String input) {
		return !isEmpty(input);
	}

	public static String jsStrEscape(String input) {
		if (input == null) {
			return null;
		}
		return input.replace("\"", "\\\"").replace("'", "\\'").replaceAll("(\\r)?\\n", "\\\\n");
	}

	public static String htmlEscape(String input) {
		 if (input == null) {
			 return null;
		 }
		 return input.replaceAll("&", "&amp;")
				 .replaceAll("<", "&lt;")
				 .replaceAll(">", "&gt;")
				 .replaceAll("\"", "&quot;")
				 .replaceAll("'", "&apos;");
	}
	public static String sqlEscape(String input) {
		 if (input == null) {
			 return null;
		 }
		 return input.replace("'", "''");
	}
	public static String toHTML(String input) {
		 if (input == null) {
			 return null;
		 }
		 return "<p>" + input.replaceAll(" ", "&nbsp;").replaceAll("(\\r)?\\n", "</p><p>") + "</p>";
	}
	public static String getFileType(String filePath) {
		if (filePath == null) {
			return null;
		}
		filePath = filePath.toLowerCase();
		int pos = filePath.lastIndexOf(".");
		if (pos != -1) {
			return filePath.substring(pos);
		}
		if (filePath.length() > 3) {
			return "." + filePath.substring(filePath.length() - 3);
		}
		return filePath;
	}
	public static String clearScriptCode(String input) {
		 if (input == null) {
			 return null;
		 }
		 return input.replaceAll("(?i)<script[^>]*>[^<]*</script[^>]*>", "");
	}
	public static String html2text(String html) {
		if (html == null) {
			return null;
		}
	    return html.replaceAll("(?i)<script[^>]*>[^<]*</script[^>]*>", "")
	  	      .replaceAll("(?i)<style[^>]*>[^<]*</style[^>]*>", "")
	  	      .replaceAll("&[a-zA-Z]+;", " ")
	  	      .replaceAll("(\\r)?\\n", " ")
	  	      .replaceAll("<[^>]+>", "")
	  	      .replace("　", " ")
	  	      .replaceAll("(\\s)+", " ");
	}

	public static String genRandomString(int num) {
		Random rnd = new Random(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder(num);
		sb.append(letters[rnd.nextInt(letters.length)]);
		for (int i = 0; i < num - 1; i++) {
			sb.append(charArr[rnd.nextInt(charArr.length)]);
		}
		return sb.toString();
	}
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }
    /**
     * 校验手机号
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
    	return Pattern.matches(REGEX_MOBILE, mobile);
    }
    /**
     * 整型字符串转换为整型
     * @param str
     * @return
     */
    public static Integer convertInteger(String str) {
    	Integer ret = 0;
    	try {
    		ret = Integer.valueOf(str);
		} catch (Exception e) {
			System.out.println("不是整型字符串。");
		}
		return ret;
	}
}
