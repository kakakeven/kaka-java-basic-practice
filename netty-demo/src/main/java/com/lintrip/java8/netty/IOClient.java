package com.lintrip.java8.netty;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author kakakeven
 * @date 2022/8/22 16:54
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
