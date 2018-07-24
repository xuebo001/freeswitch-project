package com.fxb.fs;

import org.freeswitch.esl.ESLconnection;
import org.freeswitch.esl.ESLevent;

/**
 * MySELTest
 * Created by fxb on 2018/7/23.
 */
public class MySELTest {

    public static void main(String[] args) {
        ESLevent event;

        System.load("/Users/fxb/Documents/jar/libesljni.so");
        ESLconnection conn =  new ESLconnection("127.0.0.1",8021,"ClueCon");

        if (1 == conn.connected()){
            System.out.println("Connected!");
        }

        conn.events("plain","ALL");

        while (1 == conn.connected()){
            event = conn.recvEvent();
            System.out.println(event.getHeader("Event-Name",-1));
            //System.out.println(event.serialize("plain"));
        }
    }

}
