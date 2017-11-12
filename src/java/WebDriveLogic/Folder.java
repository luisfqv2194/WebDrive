/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebDriveLogic;

import java.util.ArrayList;

/**
 *
 * @author XPC
 */
public class Folder {
    private Folder root;
    private String name;
    private String username;
    private ArrayList<Folder> childs = new ArrayList();
    private ArrayList<File> files = new ArrayList();

    public Folder(Folder root, String name, String username) {
        this.root = root;
        this.name = name;
        this.username = username;
        
    }

    public Folder(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public Folder getRoot() {
        return root;
    }

    public void setRoot(Folder root) {
        this.root = root;
    }

    public ArrayList<Folder> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<Folder> childs) {
        this.childs = childs;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }
    
    public void addFolder(String folderName) {
        this.childs.add(new Folder(new Folder(this.username,this.name),folderName,this.username));
    }
    
}
