package com.honestme.animetasteex.util;

import java.util.List;

/**
 * Created by Administrator on 2015/12/1 0001.
 */
public class TextUtil {
    public static boolean isEmpty(Object object){
        if(object instanceof String){
            String string = (String)object;

            return string.length() == 0;
        }

        if(object instanceof List){
            List list = (List)object;

            return list.isEmpty();
        }

        return true;
    }
}
