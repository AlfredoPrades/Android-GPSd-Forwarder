package io.github.tiagoshibata.gpsdclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpSensorStream {
    private final static byte[] ip = {(byte) 192, (byte) 168, (byte) 42, (byte) 136};
    private InetAddress clientAddress;
    private int clientPort = 0;
    private DatagramSocket udpSocket;

    public UdpSensorStream(int clientPort, String id) {
        try {
            clientAddress = InetAddress.getByAddress(ip);
        } catch (UnknownHostException e) {
            throw new ExceptionInInitializerError(e);
        }
        this.clientPort = clientPort;
        try {
            udpSocket = new DatagramSocket();
        } catch (SocketException e) {
//            log(e.toString());
        }
    }

    protected void send(byte[] data) {
        final DatagramPacket packet = new DatagramPacket(data, data.length, clientAddress, clientPort);
        final byte[] packetData = data;
        try {
            udpSocket.send(packet);
        } catch (IOException e) {
//            log(e.toString());
        }
//        Runnable sendTask = new Runnable() {
//            @Override
//            public void run() {
//                dataOrderLock.lock();
//                try {
//                    udpSocket.send(packet);
//                } catch (IOException e) {
//                    log(e.toString());
//                }
//                dataOrderLock.unlock();
//            }
//        };
    }
}
