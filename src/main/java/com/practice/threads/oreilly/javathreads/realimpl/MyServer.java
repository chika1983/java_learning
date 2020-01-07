package com.practice.threads.oreilly.javathreads.realimpl;
import java.net.*;
import java.io.*;
public class MyServer {
public static void main(String args[]) throws Exception {
TCPServer serv = new ServerHandler();
serv.startServer(300);
}
}