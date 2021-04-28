package com.yao;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StrParser3 {
    public static void main(String[] args) {
        String ql = "user,name=wangwu,age=18,addr=\"陕西 西安 碑林\" message=\"你好\nzhangsan\n,lisi\",math=54,ch=455 20210410";
        Result2 result2 = parse(ql);
        System.out.println("measurement为："+ result2.getMeasurement());
        System.out.println("tags为："+ result2.getTags());
        System.out.println("fields为："+ result2.getFields());
        System.out.println("timestamp为："+ result2.getTimestamp());
    }

    /**
     * 用于向map集合中存入值
     * @param array  拆分之后的字符串数组
     * @param key   区别值 向哪一个map中存储
     * @return
     */
    public static Map<String, String> getValues(String[] array, String key){
        HashMap<String, String> tags = new HashMap<>();
        HashMap<String,String> fields = new HashMap<>();
        for(String s:array){
            String[] ms = s.split("=");
            if ("tags".equals(key)){
                tags.put(ms[0], ms[1]);
            }
            if ("fields".equals(key)){
                fields.put(ms[0], ms[1]);
            }
        }
        return tags.size() == 0?fields:tags;
    }

    private static Result2 parse(String ql) {
        //声明对象
        Result2 result2 = new Result2();
        //根据空格拆分
        String[] firstStr = ql.split(" ");
        for (int i = 0; i < firstStr.length; i++) {
            if (!firstStr[i].contains("=")){
                firstStr[i-1] += " "+firstStr[i];
                i=i+1;
            }
        }

        for (int i = 0; i < firstStr.length; i++) {
            System.out.println(firstStr[i]);
        }

        System.out.println("**************************");

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0;i<firstStr.length;i++) {
            if (firstStr[i].contains("=")){
                strings.add(firstStr[i]);
            }
        }

        //获取第一段然后根据第一个逗号拆分，第一个元素就是measurement值
        String[] secondStr = strings.get(0).split(",", 2);
        result2.setMeasurement(secondStr[0]);
        //name=wangwu,age=18,addr="陕西 西安,碑林"
        String[] threeStr = secondStr[1].split(",",3);
        result2.setTags(getValues(threeStr, "tags"));
        String[] split = strings.get(1).split(",");
        String[] strings1 = new String[split.length-1];
        for (int i = 0; i < split.length; i++) {
            if (!split[i].contains("=")){
                split[i-1] += ","+split[i];
                i = i+1;
            }
        }


        ArrayList<String> strings2 = new ArrayList<>();
        for (int i = 0;i<split.length;i++) {
            if (split[i].contains("=")){
                strings2.add(split[i]);
            }
        }


        String[] s = strings2.get(strings2.size() - 1).split(" ");
        strings2.remove(strings2.size() - 1);
        strings2.add(s[0]);

        String[] strings3 = new String[strings2.size()];
        for (int i = 0; i < strings2.size(); i++) {
            strings3[i] = strings2.get(i);
        }
        result2.setFields(getValues(strings3, "fields"));
            result2.setTimestamp(s[s.length - 1]);
        return result2;
    }
}
