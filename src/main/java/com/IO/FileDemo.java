package com.IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileDemo {
    /*
        创建文件和目录
     */
    public void createFile() throws IOException {
        // 创建文件
        File f = new File(".\\src\\main\\java\\com\\IO\\test.txt");
        System.out.println(f.createNewFile());

        // 创建临时文件
        File tempFile = File.createTempFile("tmp-", ".html", new File(".\\src\\main\\java\\com\\IO"));

        tempFile.deleteOnExit();    // JVM退出时自动删除

        // 创建目录
        File c = new File(".\\src\\main\\java\\com\\IO\\test");
        c.mkdir();
    }
    /*
        遍历文件
     */
    public void traversalFile(){
        File f = new File(".\\");
        String[] list = f.list();
        for(String s : list){
            System.out.println(s);
        }
        System.out.println("=====================");
        File[] files = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".iml");
            }
        });
        for (File fs: files) {
            System.out.println(fs.getName());
        }
    }
    /*
        递归遍历所有文件及其子目录
     */
    public void recursionFile(File file, int lev){
        File[] files = file.listFiles();
        for(File f : files){
            int i = lev;
            while( i > 0){
                System.out.print("-");
                --i;
            }
            if(f.isDirectory()){
                System.out.println(f.getName());
                recursionFile(f, ++lev);
            }else {
                System.out.println(f.getName());
            }
        }
    }

    public void path() throws IOException {
        Path p = Paths.get(".","test.txt");
        System.out.println(p);
        // 转换为绝对路径
        System.out.println(p.toAbsolutePath());
        // 转换为规范路径
        System.out.println(p.toAbsolutePath().normalize());
        // 转换为File对象
        File file = p.toFile();
        System.out.println(file.createNewFile());
    }

    /*
        拷贝文件
     */
    public static void readAndCopy(){
        Path sourcePath = Paths.get("G:\\IntelliJIDEA\\project\\JStudy\\src\\main\\java\\com\\IO\\FileDemo.java");
        Path destinationPath = Paths.get("G:\\IntelliJIDEA\\project\\JStudy\\src\\main\\java\\com\\IO\\copy1.txt");
        try {
            Files.copy(sourcePath,destinationPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        FileDemo fileDemo = new FileDemo();
//        fileDemo.createFile();
//        fileDemo.traversalFile();
//        fileDemo.path();
//        fileDemo.readAndCopy();
        fileDemo.recursionFile(new File(".\\"), 0);
    }
}
