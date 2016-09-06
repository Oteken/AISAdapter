/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aisdataadapter;

/**
 * Raw AIS packet.
 * 
 * @author oteken
 */
public class EncodedPacket {
    
    private String rawPacket;
    
    /** 
     * First parameter of the raw packet.
     * Contains the packet type.
     */
    private enum packetType{AIVDM, AIVDO};
    
    /** 
     * Second Parameter of the raw packet.
     * Contains value for the total amount of packets that are sent.
     */
    private int totalPacketMessages;
    
    /** 
     * Third Parameter of the raw packet.
     * Current packet count of the total.
     */
    private int currentPacketMessage;
    
    /** 
     * Type of AIS system the packet has been sent from.
     * These are different radio channels.
     */
    private char classType;
    
    /**
     * The message inside the packet.
     * Messages vary from type 1-27
     */
    private EncodedMessage encodedMessage;
    
    private String endOfMessage;
    
    private String checkSum;
    
    
    
    
}
