/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebDriveLogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author XPC
 */
public class JSON_Handler {
    
    private String username;
    private String password;
    private long espacio;
    
    public static final String usersJSON = "C:\\Users\\XPC\\Documents\\GitHub\\WebDrive\\JsonFiles\\Users.json";
    public static final String filesJSON = "C:\\Users\\XPC\\Documents\\GitHub\\WebDrive\\JsonFiles\\Files.json";
    public static final String foldersJSON = "C:\\Users\\XPC\\Documents\\GitHub\\WebDrive\\JsonFiles\\Folders.json";

    public JSON_Handler(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public JSON_Handler() {
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getEspacio() {
        return espacio;
    }

    public void setEspacio(long espacio) {
        this.espacio = espacio;
    }
    
    
    
    public User readUserJSON() {
        JSONParser parser = new JSONParser();
        User resultado = null;
        try {
            // Cambiar dirección de lectura
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(this.usersJSON));
            JSONArray arrayUsers = (JSONArray) jsonObject.get("arrayUsers");
            Iterator<JSONObject> userIterator = arrayUsers.iterator();
            
            
            while(userIterator.hasNext()) {
                JSONObject userRecord = userIterator.next();
                
                if(userRecord.get("username").equals(this.username) 
                        && userRecord.get("password").equals(this.password)) { 
                    
                    resultado = new User((String)userRecord.get("username"), (String)userRecord.get("password"), Long.parseLong((String)userRecord.get("space")));
                    return resultado;
                }
                
            }
            
            return resultado;
            
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(JSON_Handler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSON_Handler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JSON_Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return resultado;
        
    } 
    
    public void writeNewFolderJson(Folder newFolder) {
        JSONParser parser = new JSONParser();
        System.out.println("Mi nombre es: "+newFolder.getName());
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new BufferedReader(new FileReader(this.foldersJSON)));
            
            JSONArray arrayFolders = (jsonObject.toJSONString().equals("{}") ? new JSONArray() : (JSONArray) jsonObject.get("arrayFolders"));
            JSONObject driveObj = new JSONObject();
            JSONObject rootObj = new JSONObject();
            JSONObject sharedObj = new JSONObject();
            JSONArray arraychilds = new JSONArray();
            
            rootObj.put("name", newFolder.getRoot().getName());
            rootObj.put("username", newFolder.getRoot().getUsername());
            
            System.out.println(rootObj.toJSONString());
            
            sharedObj.put("name", newFolder.getRoot().getName());
            sharedObj.put("username", newFolder.getRoot().getUsername());
            
            arraychilds.add(sharedObj);
            
            driveObj.put("root", rootObj);
            driveObj.put("username", newFolder.getUsername());
            driveObj.put("name", newFolder.getName());
            driveObj.put("childs", arraychilds);
            driveObj.put("files", new JSONArray());
            
            arrayFolders.add(driveObj);
            System.out.println(driveObj.toJSONString());
            FileWriter fw = new FileWriter(this.foldersJSON);
            BufferedWriter bw = new BufferedWriter(fw);
            jsonObject = new JSONObject();
            jsonObject.put("arrayFolders", arrayFolders);
            System.out.println(jsonObject.toJSONString());
            fw.write(jsonObject.toJSONString());
            fw.close();
            
            
            
          
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSON_Handler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSON_Handler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JSON_Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
