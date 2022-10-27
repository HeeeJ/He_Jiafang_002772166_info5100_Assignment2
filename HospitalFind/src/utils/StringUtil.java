package utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jiaf
 */
public class StringUtil {
    /**
     * Empty or not
     * 
     * @param str
     * @return boolen
     */
    public static boolean isEmpty(String str) {
	if (str == null || "".equals(str.trim())) {
            return true;
	} else {
            return false;
	}
    }
    public static boolean isNotEmpty(String str) {
        if (str != null && !"".equals(str.trim())) {
                return true;
        } else {
                return false;
        }
    }

}
