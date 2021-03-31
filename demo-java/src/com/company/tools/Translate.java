package com.company.tools;

import com.company.tools.http.HttpGet;
import com.company.tools.http.TransApi;
import com.company.tools.http.TransTool;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Translate {


    public static void main(String[] args) throws Exception {
        String fromlangue="auto";
        String tolangue="en";
        String appid="";
        String secretkey="";
        String tofilename="en.txt";
        System.out.println("注意：请确保您要转换的文件和此运行类在同一目录下！并且名字为source.txt");
        System.out.println("本项目基于百度翻译api,请去百度翻译官网获取appid和密钥");
        System.out.println("请输入您的appid：");
        Scanner scan = new Scanner(System.in);
        if(scan.hasNext()){
            appid=scan.next();
        }
        System.out.println("请输入您的密钥：");
        if(scan.hasNext()){
            secretkey=scan.next();
        }

        System.out.println("请选择你要转换的文件语言，选择A、B、C、D...中的一项按回车即可");
        System.out.println("A.auto-自动检测  B.zh-中文 C.en-英语  D.jp-日语 E.kor-韩语 F.fra-法语 G.spa-西班牙语 H.th-泰语 I.ru-俄语 J.de-德语 K.pl-波兰语 L.dan-丹麦语 " +
                "M.it-意大利语 N.pt-葡萄牙语" );

        // 从键盘接收数据
        // next方式接收字符串
        System.out.println("请输入：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String getword = scan.next();
            switch (getword){
                case "A":
                    fromlangue="auto";
                    break;
                case "B":
                    fromlangue="zh";
                    break;
                case "C":
                    fromlangue="en";
                    break;
                case "D":
                    fromlangue="jp";
                    break;
                case "E":
                    fromlangue="kor";
                    break;
                case "F":
                    fromlangue="fra";
                    break;
                case "G":
                    fromlangue="spa";
                    break;
                case "H":
                    fromlangue="th";
                    break;
                case "I":
                    fromlangue="ru";
                    break;
                case "J":
                    fromlangue="de";
                    break;
                case "K":
                    fromlangue="pl";
                    break;
                case "L":
                    fromlangue="dan";
                    break;
                case "M":
                    fromlangue="it";
                    break;
                case "N":
                    fromlangue="pt";
                    break;
                default:
                    fromlangue="auto";
            }
        }
        System.out.println("A.zh-中文 B.en-英语  C.jp-日语 D.kor-韩语 E.fra-法语 F.spa-西班牙语 G.th-泰语 H.ru-俄语 I.de-德语 J.pl-波兰语 K.dan-丹麦语 " +
                "L.it-意大利语 M.pt-葡萄牙语" );
        System.out.println("请核对一下上面列表是否有你需要转换的目标语言，有在下方输入Y并按回车，没有输入N");
        if(scan.hasNext()){
            String hasLangue=scan.next();
            if(hasLangue.equals("Y")){
                System.out.println("请选择你要转换的目标语言，选择A、B、C、D...中的一项按回车即可");
                if(scan.hasNext()){
                    String getword = scan.next();
                    switch (getword){
                        case "A":
                            tolangue="zh";
                            break;
                        case "B":
                            tolangue="en";
                            break;
                        case "C":
                            tolangue="jp";
                            break;
                        case "D":
                            tolangue="kor";
                            break;
                        case "E":
                            tolangue="fra";
                            break;
                        case "F":
                            tolangue="spa";
                            break;
                        case "G":
                            tolangue="th";
                            break;
                        case "H":
                            tolangue="ru";
                            break;
                        case "I":
                            tolangue="de";
                            break;
                        case "J":
                            tolangue="pl";
                            break;
                        case "K":
                            tolangue="dan";
                            break;
                        case "L":
                            tolangue="it";
                            break;
                        case "M":
                            tolangue="pt";
                            break;
                        default:
                            tolangue="en";
                    }
                }
            }else {
                System.out.println("请查询百度翻译API，确定你要转换语言的代号，再进行操作，请勿填错。如中文代号为zh");
                System.out.println("请输入你要转换语言的代号(英文小写)：");
                if(scan.hasNext()){
                    tolangue=scan.next();
                    if(tolangue.trim().equals("")||tolangue==null){
                        tolangue="en";
                    }
                }
            }
        }
        tofilename=tolangue+".txt";
        scan.close();
        System.out.println("文件转换中....");
        System.out.println("loading.....");
        TransTool transTool=new TransTool();
        transTool.TransLangue(appid,secretkey,tofilename,fromlangue,tolangue);
        System.out.println("感谢等待---made by yorkmass");
    }
}
