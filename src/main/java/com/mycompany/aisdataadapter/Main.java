/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aisdataadapter;

import dk.dma.ais.binary.BinArray;
import dk.dma.ais.binary.SixbitEncoder;
import dk.dma.ais.binary.SixbitException;
import dk.dma.ais.message.AisMessage;
import dk.dma.ais.reader.AisReader;
import dk.dma.ais.reader.AisReaders;
import dk.dma.ais.sentence.SentenceLine;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oteken
 */
public class Main {
    
    public static void main(String[] args){
        /** Create settings object that loads in all settings. */
        Setting settings = new Setting();
        
        /** Get connection settings and set the concerning variables. */
        Properties connectionSettings = 
                settings.properties.get("settings.properties");
        final String host = connectionSettings.getProperty("host");
        final int port = Integer.parseInt(connectionSettings.getProperty("port"));

        /** Connect to host. */
        ConnectionCredential credential = new ConnectionCredential(host, port);
        Connection connection = new Connection(credential);
        connection.connect();
        BufferedInputStream con = connection.getConnection();
        
        try {
            ArrayList<String> packets = new ArrayList<>();
            StringBuilder packet = new StringBuilder();
            char character = (char) con.read();
            packet.append(character);
            for (int i = 0; i < 50; i++) {
                character = (char) con.read();
                if(character != '!') {
                    packet.append(character);
                } else if(packet.toString().charAt(0) == '!') {
                    packets.add(packet.toString());
                } else
                    packet = new StringBuilder();
            }
            connection.stopConnection();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
