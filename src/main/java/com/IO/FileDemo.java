package com.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public static void main(String[] args) throws IOException {
        FileDemo fileDemo = new FileDemo();
        fileDemo.createFile();
//        fileDemo.traversalFile();
//        fileDemo.path();

    }
}
