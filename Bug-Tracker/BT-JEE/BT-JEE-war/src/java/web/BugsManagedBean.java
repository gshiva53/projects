/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.BugsDTO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import session.BugsFacadeRemote;

/**
 *
 * @author Shiva Gupta
 */
@Named(value = "bugsManagedBean")
@SessionScoped
public class BugsManagedBean implements Serializable {

    @EJB
    private BugsFacadeRemote bugsFacade;

    private int bugid;
    private String bugname;
    private String bugdesc;
    private String bugstatus;
    private String bugcreatedby;
    private String bugpriority;

    /**
     * Creates a new instance of BugsManagedBean
     */
    public BugsManagedBean() {
    }
    
    //wrapper method for returning a string result and 
    //using the createRecord() method of facade SLSB. 
    //Refer to lab05. 
    public void addBug() {
        
        BugsDTO bugDTO = new BugsDTO(bugid, bugname, bugdesc, 
        bugstatus, bugcreatedby, bugpriority); 
        
        boolean result = bugsFacade.createRecord(bugDTO); 
        System.out.println("New bug has been added in the system: " 
                + result 
                + "\n" + bugid 
                + "\n" + bugname);
        
    }
    
    //BugsFacadeRemote getter and setter method
    public BugsFacadeRemote getBugsFacade() {
        return bugsFacade;
    }

    public void setBugsFacade(BugsFacadeRemote bugsFacade) {
        this.bugsFacade = bugsFacade;
    }
    
    //Field getter and setter methods
    public int getBugid() {
        return bugid;
    }

    public void setBugid(int bugid) {
        this.bugid = bugid;
    }

    public String getBugname() {
        return bugname;
    }

    public void setBugname(String bugname) {
        this.bugname = bugname;
    }

    public String getBugdesc() {
        return bugdesc;
    }

    public void setBugdesc(String bugdesc) {
        this.bugdesc = bugdesc;
    }

    public String getBugstatus() {
        return bugstatus;
    }

    public void setBugstatus(String bugstatus) {
        this.bugstatus = bugstatus;
    }

    public String getBugcreatedby() {
        return bugcreatedby;
    }

    public void setBugcreatedby(String bugcreatedby) {
        this.bugcreatedby = bugcreatedby;
    }

    public String getBugpriority() {
        return bugpriority;
    }

    public void setBugpriority(String bugpriority) {
        this.bugpriority = bugpriority;
    }

}
