/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aisdataadapter;

/**
 * This class is used as a connection parameter to a connection object.
 * 
 * @author oteken
 */
public class ConnectionCredential {
    
    /** The host to connect to. */
    private String host;
    
    /** The port to connect to on the host server. */
    private int port;
    
    /** Optional username for login on host. */
    private String aisUsername;
 
    /** Optional password for login on host. */
    private String aisPassword;
    
    /** Check for an authorized login. */
    private boolean authorization;
    
    /** Constructor without authorization settings. */
    public ConnectionCredential(String host, int port) {
        this.host = host;
        this.port = port;
        this.authorization = false;
    }
    
    /** Constructor with authorization settings. */
    public ConnectionCredential(String host, int port, 
            String username, String password) {
        this(host, port);
        this.aisUsername = username;
        this.aisPassword = password;
        this.authorization = true;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getAisUsername() {
        return aisUsername;
    }

    public String getAisPassword() {
        return aisPassword;
    }

    public boolean isAuthorization() {
        return authorization;
    }
}
