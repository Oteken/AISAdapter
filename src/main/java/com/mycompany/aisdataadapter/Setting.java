/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aisdataadapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class imports all the values from property files.
 * 
 * @author oteken
 */
public class Setting {
    
    /** Store for all properties during execution*/
    public HashMap<String, Properties> properties;
    
    public String propertiesPath = new File("src/main/resources/").getAbsolutePath();
    
    public Setting() {
        loadFiles();
    }
    
    /** 
     * Find all files with .properties extention
     * and return all names in an ArrayList.
     */
    private ArrayList<String> getFileNames() {
        ArrayList<String> fileNames = new ArrayList<>();
        File[] files = new File(propertiesPath).listFiles();
        for (File file : files) {
            fileNames.add(file.getName());
        }
        return fileNames;
    }
    
    /** Load all .properties files into global HashMap*/
    private void loadFiles(){
        ArrayList<String> fileNames = getFileNames();
        properties = new HashMap<>();
        String path;
        for (String fileName : fileNames) {
            path = propertiesPath + "/" + fileName;
            try {
                FileInputStream in = new FileInputStream(path);
                Properties property = new Properties();
                property.load(in);
                properties.put(fileName, property);
                in.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

