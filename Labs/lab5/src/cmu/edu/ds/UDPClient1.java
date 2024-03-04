//package cmu.edu.ds;
//
//import java.io.*;
//import java.net.*;
//import java.math.BigInteger;
//import java.security.SecureRandom;
//
///*
//Based on Coulouris UDP socket code
// */
//public class UDPClient1 {
//    private DatagramSocket socket = null;
//    private InetAddress host = null;
//    private int port;
//    // Diffie-Hellman parameters
//    private static final BigInteger g = BigInteger.valueOf("5");
//    private static final BigInteger p = new BigInteger(23);
//    private BigInteger a, A;
//
//    public static void main(String[] args) {
////        Scanner keyboard = new Scanner(System.in);
////        System.out.print("Enter an integer: ");
////        int value = Integer.parseInt(keyboard.nextLine());
////        System.out.println("value = " + value);
////        UDPClient1 udpClient1 = new UDPClient1();
////        udpClient1.init("localhost", 7272);
////        udpClient1.send(Integer.toString(value));
////        value = Integer.parseInt(udpClient1.receive());
////        System.out.println("Answer: " + value);
////        udpClient1.close();
//        UDPClient1 udpClient1 = new UDPClient1();
//        udpClient1.init("localhost", 7272);
//        udpClient1.performKeyExchange();
//        udpClient1.close();
//    }
//
//    private void init(String hostname, int portNumber) {
//        try {
//            host = InetAddress.getByName(hostname);
//            port = portNumber;
//            socket = new DatagramSocket();
//            SecureRandom rnd = new SecureRandom();
//            a = new BigInteger(2046, rnd);
////            a = new BigInteger(2046, new SecureRandom());
//            A = g.modPow(a, p);
//        } catch (SocketException e) {
//            System.out.println("Socket error " + e.getMessage());
//        } catch (IOException e) {
//            System.out.println("IO error " + e.getMessage());
//        }
//    }
//
//    private void performKeyExchange() {
//        try {
//            send(A.toString()); // Send Alice's public value to Bob
//            BigInteger B = new BigInteger(receive()); // Receive Bob's public value
//            BigInteger s = B.modPow(a, p); // Compute the shared secret
//            System.out.println("Shared secret: " + s.toString(16));
//        } catch (Exception e) {
//            System.out.println("Key exchange error: " + e.getMessage());
//        }
//    }
//
//    private void send(String message) {
//        byte[] m = message.getBytes();
//        DatagramPacket packet = new DatagramPacket(m, m.length, host, port);
//        try {
//            socket.send(packet);
//        } catch (IOException e) {
//            System.out.println("IO error " + e.getMessage());
//        }
//    }
//
//    private String receive() {
//        byte[] answer = new byte[256];
//        DatagramPacket reply = new DatagramPacket(answer, answer.length);
//        try {
//            socket.receive(reply);
//        } catch (IOException e) {
//            System.out.println("IO error " + e.getMessage());
//        }
//        return(new String(reply.getData(), 0, reply.getLength()));
//
//    }
//
//    private void close() {
//        if (socket != null) socket.close();
//    }
//}
