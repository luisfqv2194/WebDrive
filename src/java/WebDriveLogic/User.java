/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebDriveLogic;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author XPC
 */
public class User {
    
    private String username;
    private String password;
    private long space;
    private Folder myDrive;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, long space) {
        this.username = username;
        this.password = password;
        this.space = space;
        this.createDrive();
    }

    public long getSpace() {
        return space;
    }

    public void setSpace(long space) {
        this.space = space;
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
    
    public boolean validateUser() {
        JSON_Handler jsonUser = new JSON_Handler(this.username,this.password);
        User user = jsonUser.readUserJSON();
        if(user != null){
            this.username = user.username;
            this.password = user.password;
            this.space = user.space;
            return true;
        }
        else {
            return false;
        }
        
    }
    
    public void createDrive() {
        this.myDrive = new Folder(new Folder("Drive", this.username),"Drive", this.username);
        this.myDrive.addFolder("Shared");
        JSON_Handler handler = new JSON_Handler();
        handler.writeNewFolderJson(myDrive);
    }
    
}
