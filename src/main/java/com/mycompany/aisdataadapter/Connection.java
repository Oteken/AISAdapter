/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aisdataadapter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class handles the connection to the server.
 * 
 * @author oteken
 */
public class Connection {
    
    private ConnectionCredential credential;
    
    private Socket clientSocket;
    
    /** Received input from server. */
    private BufferedInputStream connection = null;
    
    /** 
     * Given parameter to the connection is stored inside a global variable.
     * Connection is not made after constructing class, but rather after
     * invoking the connect() method.   
     */
    public Connection(ConnectionCredential credential) {
        this.credential = credential;
    }
    
    /** Sets global BufferedInputStream to connected stream. */
    public void connect() {
        if (credential.isAuthorization())
            authConnection();
        else
            unauthConnection();
    }
    
    /** Connection without username and password. */
    private void unauthConnection() {
        try {
            this.clientSocket = new Socket(credential.getHost(), credential.getPort());
            this.connection = new BufferedInputStream(clientSocket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /** Connection with username and password. */
    private void authConnection() {
        this.connection = new BufferedInputStream(null);
    }
    
    /** Closes buffered stream and socket. */
    public void stopConnection() {
        if(this.connection == null)
            return;
        try {
            this.connection.close();
            this.clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Get stream connected to.
     * Null if not connected yet.
     * @return 
     */
    public BufferedInputStream getConnection() {
        return connection;
    }
}
