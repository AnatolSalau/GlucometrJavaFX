package com.work;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.work.comPort.ComPortConnectivity;
import com.work.control.Control;
import com.work.exception.ComPortException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

       /* LinkedList<Byte> bytesRiesived = new LinkedList<>();

        SerialPort comPort = SerialPort.getCommPorts()[1];
//        System.out.println(SerialPort.getCommPorts().toString());
//        SerialPort[] ports = SerialPort.getCommPorts();
//        String[] result = new String[ports.length];
//        for (int i = 0; i < ports.length; i++) {
//            // result[i] = ports[i].getSystemPortName();
//            result[i] = ports[i].getDescriptivePortName();
//            System.out.println(result[i]);
//        }
        comPort.setBaudRate(57600);
        comPort.setNumDataBits(8);
        comPort.setNumStopBits(SerialPort.ONE_STOP_BIT);
        comPort.setParity(SerialPort.NO_PARITY);
        comPort.openPort();
        comPort.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
                    return;
                byte[] newData = new byte[comPort.bytesAvailable()];
                int numRead = comPort.readBytes(newData, newData.length);
                System.out.println("Read " + numRead + " bytes.");
                System.out.println(comPort.bytesAvailable());
                    numRead = comPort.readBytes(newData, newData.length);
                    for (int i = 0; i < newData.length; i++) {
                        bytesRiesived.add(newData[i]);
                    }
                System.out.println(bytesRiesived);
                    bytesRiesived.clear();
                }

        });*/

        Control control = new Control();
        System.out.println(control.parceFromFile());
    }
}
