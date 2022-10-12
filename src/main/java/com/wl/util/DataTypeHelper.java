package com.wl.util;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * 验证类
 */
public class DataTypeHelper {

    private static Pattern patternInteger = compile("^[-\\+]?[\\d]*$");
    private static Pattern patternZhengInteger = compile("^(0|[1-9][0-9]*)$");
    private static Pattern patternDouble = compile("^[-\\+]?[.\\d]*$");
    private static Pattern patternZhengDouble = compile("^\\d+(\\.\\d+)?$");
    private static Pattern patternMobile = compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
    private static Pattern patternTelphone1 = compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
    private static Pattern patternTelphone2 = compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
    private static Pattern patternEmail = compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
    private static Pattern patternIDCard = compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
    private static Pattern patternUserName = compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$");
    private static Pattern patternUserPwd = compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$");
    /*
     * 判断是否为整数
     *
     * @param str 传入的字符串
     *
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger(String str) {
//        Pattern pattern = compile("^[-\\+]?[\\d]*$");
        return patternInteger.matcher(str).matches();
    }

    /*
     * 判断是否为整数
     *
     * @param str 传入的字符串
     *
     * @return 是整数返回true,否则返回false
     */
    public static boolean isZhengInteger(String str) {
//        Pattern pattern = compile("^(0|[1-9][0-9]*)$");
        return patternZhengInteger.matcher(str).matches();
    }

    /*
     * 判断是否为浮点数，包括double和float
     *
     * @param str 传入的字符串
     *
     * @return 是浮点数返回true,否则返回false
     */
    public static boolean isDouble(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        } else {
//            Pattern pattern = compile("^[-\\+]?[.\\d]*$");
            return patternDouble.matcher(str).matches();
        }
    }

    /*
     * 判断是否为浮点数，包括double和float
     *
     * @param str 传入的字符串
     *
     * @return 是浮点数返回true,否则返回false
     */
    public static boolean isZhengDouble(String str) {
//		Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]{2})?$");
//        Pattern pattern = compile("^\\d+(\\.\\d+)?$");
        return patternZhengDouble.matcher(str).matches();
    }

    /**
     * 判断用户名是否合法（8~16位，只能由字母和数字组成）
     * @param str
     * @return
     */
    public static boolean isRightUserName(String str){
        return patternUserName.matcher(str).matches();
    }

    /**
     * 判断密码是否合法（6~18位，只能由字母和数字组成）
     * @param str
     * @return
     */
    public static boolean isRightPwd(String str){
        return patternUserPwd.matcher(str).matches();
    }

    /**
     * 手机号验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
//        Pattern p = null;
        Matcher m = null;
        boolean b = false;
//        p = compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = patternMobile.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     * 电话号码验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isPhone(String str) {
//        Pattern p1 = null, p2 = null;
        Matcher m = null;
        boolean b = false;
//        p1 = compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
//        p2 = compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
        if (str.length() > 9) {
            m = patternTelphone1.matcher(str);
            b = m.matches();
        } else {
            m = patternTelphone2.matcher(str);
            b = m.matches();
        }
        return b;
    }

    /**
     * @param str
     * @return boolean
     * @Title: isEmail
     * @Description: TODO(判定是不是邮箱)
     * @Author cyz 695789170@qq.com
     * @date：2015-9-4 下午3:46:22
     */
    public static boolean isEmail(String str) {
//        Pattern pattern = compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = patternEmail.matcher(str);
        return matcher.matches();
    }

    /**
     * 区间验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean intervalStr(String str, int start_length, int end_length) {
        if (StringUtils.isEmpty(str)) {
            if (str.trim().length() < start_length || str.trim().length() > end_length) {//返回false
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    /**
     * 根据身份编号获取年龄
     *
     * @param idCard 身份编号
     * @return 年龄
     */
    public static int getAgeByIdCard(String idCard) {
        int iAge = 0;
        Calendar cal = Calendar.getInstance();
        String year = idCard.substring(6, 10);
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }

    /**
     * 根据身份编号获取性别
     *
     * @param idCard 身份编号
     * @return 性别(M - 男 ， F - 女 ， N - 未知)
     */
    public static String getGenderByIdCard(String idCard) {
        String sGender = "未知";
        String sCardNum = idCard.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = "0";//男
        } else {
            sGender = "1";//女
        }
        return sGender;
    }

    /**
     * 身份证验证规则： 第十八位数字（校验码）的计算方法为：
     * 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
     * 2.将这17位数字和系数相乘的结果相加。
     * 3.用加出来和除以11，看余数是多少？
     * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
     * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
     *
     * @author: (caoyuanzheng)
     * @e-mail: qiumingllu@foxmail.com
     */
    public static boolean isCardId(String cardNo) {
        if (StringUtils.isEmpty(cardNo)) {//身份证不为空
            cardNo = cardNo.toUpperCase();
            //定义判别用户身份证号的正则表达式（要么是15位，要么是18位，最后一位可以为字母）
//            Pattern idNumPattern = compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
            //通过Pattern获得Matcher
            Matcher idNumMatcher = patternIDCard.matcher(cardNo);
            //判断用户输入是否为身份证号
            if (idNumMatcher.matches()) {
                // 1.将身份证号码前面的17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
                int[] intArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                int sum = 0;
                for (int i = 0; i < intArr.length; i++) {
                    // 2.将这17位数字和系数相乘的结果相加。
                    sum += Character.digit(cardNo.charAt(i), 10) * intArr[i];
                }
                //System.out.println("Totally sum：" + sum);
                // 3.用加出来和除以11，看余数是多少？
                int mod = sum % 11;
                //System.out.println("Totally sum%11 = " + mod);
                // 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
                int[] intArr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                int[] intArr3 = {1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2};
                String matchDigit = "";
                for (int i = 0; i < intArr2.length; i++) {
                    int j = intArr2[i];
                    if (j == mod) {
                        matchDigit = String.valueOf(intArr3[i]);
                        if (intArr3[i] > 57) {
                            matchDigit = String.valueOf((char) intArr3[i]);
                        }
                    }
                }
                if (matchDigit.equals(cardNo.substring(cardNo.length() - 1))) {
//	            System.out.println("ID Card Verify Sucsess!");
                    return true;
                } else {
//	            System.out.println("ID Card Verify Faild!");
                    return false;
                }
                // 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * @param f
     * @return Double
     * @Title: doubleReturn2
     * @Description: TODO(保留小数点两位)
     * @Author cyz 695789170@qq.com
     * @date：2016-2-25 下午9:32:50
     */
    public static Double doubleReturn2(Double f) {
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    /**
     * @param f
     * @return Double
     * @Title: doubleReturn2
     * @Description: TODO(保留小数点两位)
     * @Author cyz 695789170@qq.com
     * @date：2016-2-25 下午9:32:50
     */
    public static String doubleFormat(Double f) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");//格式化设置
        return decimalFormat.format(f);
    }

    /**
     * byte(字节)根据长度转成kb(千字节)和mb(兆字节)
     *
     * @param bytes
     * @return String
     */
    public static String bytes2kb(Long bytes) {
        float returnValue = 0.0f;
        if (bytes != null) {
            BigDecimal filesize = new BigDecimal(bytes);
            BigDecimal megabyte = new BigDecimal(1024 * 1024);
            returnValue = filesize.divide(megabyte, 2, BigDecimal.ROUND_UP).floatValue();
            if (returnValue > 1) {
                return (returnValue + "MB");
            }
            BigDecimal kilobyte = new BigDecimal(1024);
            returnValue = filesize.divide(kilobyte, 2, BigDecimal.ROUND_UP).floatValue();
        }
        return (returnValue + "KB");
    }

}
