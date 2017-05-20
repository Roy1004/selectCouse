package com.book.util;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trans {
 
    public static Map getSubMap(List list, Integer limit, Integer offset) {
        int size = list.size();
        limit = limit==null?size:limit;
        offset = offset==null?0:offset;
        HashMap<String,Object> ans = new HashMap<String, Object>();
        if (limit+offset > size) {
            ans.put("rows", list.subList(offset, size));
            ans.put("total", Integer.toString(size));
        } else {
            offset = offset >size?size: offset;
            ans.put("rows", list.subList(offset, size > (limit+offset) ? (limit+offset) : size));
            ans.put("total", Integer.toString(size));
        }
        return ans;
    }

    public static String  MD5(String args) throws Exception {
        String original = args;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }

//        System.out.println("original:" + original);
//        System.out.println("digested(hex):" + sb.toString());
        return sb.toString();
    }

}
