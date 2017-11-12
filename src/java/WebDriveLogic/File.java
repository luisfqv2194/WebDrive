/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebDriveLogic;

import java.util.Date;

/**
 *
 * @author XPC
 */
public class File {
    private String name;
    private String owner;
    private Date created;
    private Date modified;
    private boolean shared;
    private String sharedOwner;
    private long size;

    public File(String name, String owner, Date created, Date modified, boolean shared, long size) {
        this.name = name;
        this.owner = owner;
        this.created = created;
        this.modified = modified;
        this.shared = shared;
        this.size = size;
    }

    public String getSharedOwner() {
        return sharedOwner;
    }

    public void setSharedOwner(String sharedOwner) {
        this.sharedOwner = sharedOwner;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
    
    
    
}
