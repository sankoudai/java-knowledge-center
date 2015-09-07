package com.sankoudai.java.common;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author : sankoudai
 * @version : created at 2015/9/6
 */
public class PrintUtil {
    public static String toString(Map<String, String[]> arg){
        String str = null;

        if(arg != null){
            StringBuffer sb = new StringBuffer();
            sb.append("{");

            Set<Entry<String, String[]>> entries = arg.entrySet();
            for(Entry<String, String[]> entry : entries){
                String key = entry.getKey();
                String val = Arrays.toString(entry.getValue());
                sb.append(key + "=" + val + ", ");
            }

            int len = sb.length();
            if(sb.charAt(len-1) == ' '){
                sb.delete(len-2, len);
            }

            sb.append("}");
            str = sb.toString();
        }

        return str;
    }

    public static String toString(Object[] objects){
        if(objects == null){
            return null;
        }
        return Arrays.toString(objects);
    }

    public static String toString(Object object){
        if(object == null){
            return null;
        }
        return object.toString();
    }
}
