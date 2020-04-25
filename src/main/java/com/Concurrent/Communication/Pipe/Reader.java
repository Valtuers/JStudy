package com.Concurrent.Communication.Pipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.stream.Collectors;

public class Reader implements Runnable {
    PipedInputStream pipedInputStream;

    public Reader(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        if(pipedInputStream != null) {
            String collect = new BufferedReader(new InputStreamReader(pipedInputStream))
                    .lines().collect(Collectors.joining("\n"));
            System.out.println(collect);
        }
        try {
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
