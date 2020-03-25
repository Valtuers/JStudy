package com.IO;

import java.io.*;

public class StreamDemo {

    public void fileInputStream() throws IOException {
        try(FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\IO\\test.txt");){
            StringBuilder sb = new StringBuilder();
            for(;;){
                int n = fis.read();
                if(n == -1){
                    break;
                }
                sb.append((char) n);
            }
            System.out.println(sb);
        }
    }

    public void fileOutputStream() throws IOException {
        OutputStream op = new FileOutputStream(".\\src\\main\\java\\com\\IO\\test.txt");
        op.write("Hello".getBytes("UTF-8"));
        op.close();
    }
    /*
        装饰者模式
     */
    public void decorator() throws IOException {
        byte[] data = "hello, world!".getBytes("UTF-8");
        try (CountInputStream input = new CountInputStream(new ByteArrayInputStream(data))) {
            StringBuilder sb = new StringBuilder();
            int n;
            while ((n = input.read()) != -1){
                sb.append((char) n);
            }
            System.out.println(sb);
            System.out.println("Total read " + input.getBytesRead() + " bytes");
        }

    }

    public static void main(String[] args) throws IOException {
        StreamDemo streamDemo = new StreamDemo();
        streamDemo.fileInputStream();
        streamDemo.fileOutputStream();
        streamDemo.decorator();
    }
}
/*
    装饰者模式示范类
 */
class CountInputStream extends FilterInputStream {
    private int count = 0;

    CountInputStream(InputStream in) {
        super(in);
    }

    public int getBytesRead() {
        return this.count;
    }

    public int read() throws IOException {
        int n = in.read();
        if (n != -1) {
            this.count ++;
        }
        return n;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int n = in.read(b, off, len);
        this.count += n;
        return n;
    }
}