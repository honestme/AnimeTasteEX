package com.honestme.animetasteex.util;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Administrator on 2015/11/2 0002.
 */
public class ApiUtil {
    public static String getAccessToken(TreeMap<String,String> treeMap,
                                        String app_secret){

        String toMd5 = "";
        Set<String> keys = treeMap.keySet();
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            toMd5 += key + "=" + treeMap.get(key) + "&";
        }

        toMd5 = toMd5.substring(0,toMd5.length() - 1);
        toMd5 += app_secret;
        return MD5.digest(toMd5);

    }

}
