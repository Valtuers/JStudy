package com.IO;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class ReaderDemo {

    public void fileReader() throws IOException {
        try(Reader r = new FileReader(".\\src\\main\\java\\com\\IO\\test.txt")){
            StringBuilder sb = new StringBuilder();
            char[] c = new char[10];
            while(r.read(c) != -1){
                sb.append(c);
                c = new char[10];
            }
            System.out.println(sb);
        }
    }

    public void stringReader() throws IOException {
        try(Reader r = new StringReader("你好")){
            System.out.println(r.read());
        }
    }

    public static void main(String[] args) throws IOException {
        ReaderDemo readerDemo = new ReaderDemo();
        readerDemo.fileReader();
        readerDemo.stringReader();
    }
}
