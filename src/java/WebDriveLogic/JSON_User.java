/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebDriveLogic;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class JSON_User {
    
    private String username;
    private String password;

    public JSON_User(String username, String password) {
        this.username = username;
        this.password = password;
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
    
    public boolean readUserJSON() {
        JSONParser parser = new JSONParser();
        boolean resultado = false;
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Users\\XPC\\Documents\\GitHub\\WebDrive\\JsonFiles\\Users.json"));
            JSONArray arrayUsers = (JSONArray) jsonObject.get("arrayUsers");
            Iterator<JSONObject> userIterator = arrayUsers.iterator();
            
            
            while(userIterator.hasNext()) {
                JSONObject userRecord = userIterator.next();
                
                if(userRecord.get("username").equals(this.username) 
                        && userRecord.get("password").equals(this.password)) { 
                    
                    resultado = true;
                    return resultado;
                }
                
            }
            
            return resultado;
            
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(JSON_User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSON_User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JSON_User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return resultado;
        
    } 
    
    
    
}
