package com.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexDemo {
    /*
        ? : 匹配0~1个字符
        * : 匹配0或以上个字符
        + : 匹配1或以上个字符
        \d : 匹配数字
        \w : 匹配字符
        \s : 匹配空格
        {n,m} : 匹配指定范围内n~m个字符
        [n-m] : 匹配指定范围内n-m的字符
        [^n-m] : 不匹配指定范围内n-m的字符
        . : 匹配任意字符(a,b,&,0)
        ^/$ : 表示开头和结尾
        n|m : 匹配n或者匹配m
     */
    public void rules(){
        System.out.println("001".matches("00\\d?"));
        System.out.println("0012".matches("00\\d*"));
        System.out.println("0012".matches("00\\d+"));
        System.out.println("00123".matches("00\\d{3}"));
        System.out.println("001234".matches("00\\d{0,4}"));
        System.out.println("00A".matches("00."));
        System.out.println("00B".matches("^[0]{2}\\w+$"));
        System.out.println("CC".matches("AA|BB"));
        System.out.println("is AA".matches("is\\s(AA|BB)"));
        System.out.println("020-84359685".matches("\\d{3}-[^0]\\d{7}"));
    }

    /*
        分组匹配
     */
    public void pattern(){
        Pattern p = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})");
        Matcher m = p.matcher("23:59:26");
        if(m.matches()){
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
        }else{
            System.out.println("匹配失败！！！");
        }
    }

    public void backReference(){
        String s = "The weather is good today";
        String s1 = s.replaceAll("\\s(\\w{2})\\s", " <b>$1</b> ");
        System.out.println(s1);
    }

    public static void main(String[] args) {
        RegexDemo demo = new RegexDemo();
        demo.rules();
        demo.pattern();
        demo.backReference();
    }
}
