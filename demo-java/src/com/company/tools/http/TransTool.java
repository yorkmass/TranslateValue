package com.company.tools.http;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class TransTool {
    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
   // private static final String APP_ID = "xxxxxxx";
   // private static final String SECURITY_KEY = "xxxxxx";

    public void TransLangue(String APP_ID,String SECURITY_KEY,String toFileName,String fromLangue,String toLangue) throws IOException {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        File f=new File("source.txt");
        List<String> ss= Files.readAllLines(f.toPath());
        //写入中文字符时解决中文乱码问题
        FileOutputStream fos=new FileOutputStream(new File(toFileName));
        OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw=new BufferedWriter(osw);
        //简写如下：
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
        //        new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8"));

        for(String s:ss){
            if(!s.split(":")[0].equals(s)){

                if(!(s.split(":")[1].trim().equals("{")||s.split(":")[1].trim().equals("["))){
                    String res=UnicodeConverteUtil.unicode2String(api.getTransResult(s.split(":")[1].trim(),fromLangue,toLangue));
                    res=res.replaceAll("«","").replaceAll("»","").replaceAll("\\\\","");
                    s=s.split(":")[0]+":"+res;
                }
            }
            bw.write(s+"\t\n");

        }
        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();
        System.out.println("生成成功！");
    }
}
