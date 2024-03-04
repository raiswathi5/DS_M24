//package cmu.edu.ds;
//
//import java.io.IOException;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//import java.net.SocketException;
//import java.math.BigInteger;
//import java.security.SecureRandom;
//
///*
//Based on Coulouris UDP socket code
// */
//public class UDPServer1 {
//    private DatagramSocket socket = null;
//    private InetAddress inetAddress = null;
//    private int port;
//    // Diffie-Hellman parameters
//    private static final BigInteger g = BigInteger.valueOf(5);
//    private static final BigInteger p = new BigInteger("23");
//    private BigInteger b, B;
//
//    public static void main(String[] args) {
////        UDPServer1 udpServer1 = new UDPServer1();
////        udpServer1.init(7272);
////        int value = Integer.parseInt(udpServer1.receive());
////        System.out.println("Server received: " + value);
////        value++;
////        String message = Integer.toString(value);
////        udpServer1.send(message);
////        udpServer1.close();
//        UDPServer1 udpServer1 = new UDPServer1();
//        udpServer1.init(7272);
//        udpServer1.performKeyExchange();
//        udpServer1.close();
//    }
//
//    private void init(int portnumber) {
//        try {
//            socket = new DatagramSocket(portnumber);
//            //new code
//            SecureRandom rnd = new SecureRandom();
//            b = new BigInteger(2046, rnd);
////            b = new BigInteger(2046, new SecureRandom());
//            B = g.modPow(b, p);
//            System.out.println("Server socket created");
//        } catch (SocketException e) {
//            System.out.println("Socket error " + e.getMessage());
//        } catch (IOException e) {
//            System.out.println("IO error " + e.getMessage());
//        }
//    }
//
//    private void performKeyExchange() {
//        try {
//            BigInteger A = new BigInteger(receive()); // Receive Alice's public value
//            send(B.toString()); // Send Bob's public value to Alice
//            BigInteger s = A.modPow(b, p); // Compute the shared secret
//            System.out.println("Shared secret: " + s.toString(16));
//        } catch (Exception e) {
//            System.out.println("Key exchange error: " + e.getMessage());
//        }
//    }
//
//    private void send(String message) {
//        byte[] buffer = new byte[256];
//        buffer = message.getBytes();
//        DatagramPacket reply = new DatagramPacket(buffer, buffer.length, inetAddress, port);
//        try {
//            socket.send(reply);
//        } catch (SocketException e) {
//            System.out.println("Socket error " + e.getMessage());
//        } catch (IOException e) {
//            System.out.println("IO error " + e.getMessage());
//        }
//
//    }
//
//    private String receive() {
//        byte[] buffer = new byte[256];
//        DatagramPacket request = new DatagramPacket(buffer, buffer.length);
//
//        try {
//            socket.receive(request);
//            inetAddress = request.getAddress();
//            port = request.getPort();
//        } catch (SocketException e) {
//            System.out.println("Socket error " + e.getMessage());
//        } catch (IOException e) {
//            System.out.println("IO error " + e.getMessage());
//        }
//        return new String(request.getData(), 0, request.getLength());
//    }
//
//    private void close() {
//        if (socket != null) socket.close();
//    }
//}
