package cmu.edu.ds;

import java.io.IOException;
import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Random;
import java.util.Scanner;

/*
Based on Coulouris UDP socket code
Alice
 */
public class UDPClient {
    private DatagramSocket socket = null;
    private InetAddress host = null;
    private int port;

    public static void main(String[] args) {
        BigInteger p = new BigInteger("294558318881405180764747479252007358319960875235150893513057100495960335262381639732" +
                "393624382991877148611640594583065379669231891214833093801938123911763243718214043283" +
                "060093720669049649181956712189051916260382176617240174711734510352477962712574583690" +
                "779486253846522009126482319144984230256476305809392243435136726060071627481596350642" +
                "241513558954925792693196456498326057846493955255568347280893811272095586783577349445" +
                "131066561096635908313303089526419052508796347391313473326110069433039169945763380273" +
                "958809155750154147725521635748917952339066093424140296680685333565455781078703656353" +
                "98276428848740477292742280559"); //modulus
        BigInteger g = new BigInteger("5"); //base
        Random r = new Random();
        //int aInt =r.nextInt(21) + 2;
        //BigInteger a = new BigInteger(String.valueOf(aInt));
        BigInteger a = new BigInteger(2046, r);
        BigInteger A = g.modPow(a, p);
        System.out.println("value = " + A);
        UDPClient udpClient = new UDPClient();
        udpClient.init("localhost", 7272);
        udpClient.send(A.toString());
        BigInteger B = new BigInteger(udpClient.receive());
        System.out.println("Answer: " + B);
        BigInteger s = B.modPow(a, p);
        System.out.println("Shared Secret Key: " + s);
        udpClient.close();
    }

    private void init(String hostname, int portNumber) {
        try {
            host = InetAddress.getByName(hostname);
            port = portNumber;
            socket = new DatagramSocket();
        } catch (SocketException e) {
            System.out.println("Socket error " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error " + e.getMessage());
        }
    }

    private void send(String message) {
        byte[] m = message.getBytes();
        DatagramPacket packet = new DatagramPacket(m, m.length, host, port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            System.out.println("IO error " + e.getMessage());
        }
    }

    private String receive() {
        byte[] answer = new byte[2046];
        DatagramPacket reply = new DatagramPacket(answer, answer.length);
        try {
            socket.receive(reply);
        } catch (IOException e) {
            System.out.println("IO error " + e.getMessage());
        }
        return(new String(reply.getData(), 0, reply.getLength()));

    }

    private void close() {
        if (socket != null) socket.close();
    }
}