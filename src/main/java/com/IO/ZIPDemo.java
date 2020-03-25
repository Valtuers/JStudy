package com.IO;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZIPDemo {
    /*
        压缩文件
     */
    public void compress() throws IOException {
        try(ZipOutputStream zop = new ZipOutputStream(new FileOutputStream(".\\src\\main\\java\\com\\IO\\test.zip"))){
            File[] files = new File(".\\src\\main\\java\\com\\IO\\").listFiles();
            for(File f : files){
                zop.putNextEntry(new ZipEntry(f.getName()));
                zop.write("你好".getBytes("UTF-8"));
                zop.closeEntry();
            }
        }
    }
    /*
        解压文件
     */
    public void decompress() throws IOException {
        // 创建文件夹
        File file = new File(".\\src\\main\\java\\com\\IO\\test");
        if(!file.exists()){
            file.mkdir();
        }
        ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(".\\src\\main\\java\\com\\IO\\test.zip")));
        ZipEntry zipEntry = null;
        while((zipEntry = zis.getNextEntry()) != null){
            String filename = zipEntry.getName();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int n;
            while((n = zis.read(bytes,0,bytes.length)) > -1){
                byteArrayOutputStream.write(bytes,0,n);
            }
            bytes = byteArrayOutputStream.toByteArray();
            String content = new String(bytes,"UTF-8");
            File newFile = new File(file.getPath() + File.separator + filename);
            OutputStream op = new FileOutputStream(newFile);
            op.write(content.getBytes("UTF-8"));
        }

    }

    public static void main(String[] args) throws IOException {
        ZIPDemo zipDemo = new ZIPDemo();
        zipDemo.compress();
        zipDemo.decompress();
    }
}
