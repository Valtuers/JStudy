package com.IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo {

    public void fileWriter() throws IOException {
        try(Writer w = new FileWriter(".\\src\\main\\java\\com\\IO\\test.txt")){
            w.write("哈哈");
            w.write("奥术大师多撒");
        }
    }

    public static void main(String[] args) throws IOException {
        WriterDemo writerDemo = new WriterDemo();
        writerDemo.fileWriter();
    }
}
