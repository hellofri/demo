package com.example.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * mybatis自动生成代码补充
 * https://www.cnblogs.com/modou/p/6354230.html
 * https://www.cnblogs.com/haoyul/p/9647968.html
 * https://blog.csdn.net/yoyofu007/article/details/80994999
 */
public class MyGenerator {
    private static String templatePathname="E:/blt/code/demo/src/main/resources/templates/";

    public static void main(String[] args) {
        write400CustomizeFile();
    }

    public static void write400CustomizeFile() {
        try {
            //自动生成代码项目目录
            String pathname = "E:/blt/code/generator/src/main/java/com/auto";
            File[] fileList = getFileList(pathname);
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isFile()) {
                    String fileName = fileList[i].getName();
                    System.out.println("文件：" + fileName);
                }

                if (fileList[i].isDirectory()) {
                    String fileName = fileList[i].getName();
                    System.out.println("目录：" + fileName);

                    String targetFilePathname = pathname.replace("auto","customize/"+fileName);

                    String daoPathname = pathname+"/"+fileName;
                    File[] daoFileList = getFileList(daoPathname);
                    Arrays.stream(daoFileList).forEach(daoFiles -> {
                        String daoParentName = daoFiles.getName().replace(".java","");
                        String daoName = daoParentName.replace("Auto","");
                        Map map = new HashMap();
                        map.put("daoParentName",daoParentName);
                        map.put("type",fileName);
                        map.put("classType","interface");
                        map.put("lombok",0);
                        if("model".equals(fileName)){
                            map.put("classType","class");
                            if(!daoName.endsWith("Query")){
                                daoName = daoName+"BO";
                                map.put("lombok",1);
                            }
                        }


                        map.put("daoName",daoName);
                        String newFileName = daoName+".java";

                        writeFile(map,templatePathname,targetFilePathname,"400Customize.ftl",newFileName);
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File[] getFileList(String pathname){
        File file = new File(pathname);
        return file.listFiles();
    }

    /**
     * 生成文件
     * @param map 模板中的动态值
     * @param templatePathname 模板所在目录路径
     * @param pathname 待生成的文件路径，目录要创建好，否则会报错
     * @param templateName 模板名称
     * @param fileName 待生成的文件名称
     */
    public static void writeFile(Map map,String templatePathname,String pathname,String templateName,String fileName) {
        try {
            Configuration cfg = new Configuration();
            cfg.setDirectoryForTemplateLoading(new File(templatePathname));
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            Template temp = cfg.getTemplate(templateName);
            File file = new File(pathname+"/" + fileName);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            temp.process(map, bw);
            bw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
