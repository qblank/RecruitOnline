package cn.qblank.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author evan_qb
 *
 */
public class TimeUtil {
	/** 日期转换为自定义格式输出 */
	public static String DateToString(Date date, String formatType) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		String dateStr="";
		if(date!=null){
			dateStr = sdf.format(date);
		}
		return dateStr;
	}
}
