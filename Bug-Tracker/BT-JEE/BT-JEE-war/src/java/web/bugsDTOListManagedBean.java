/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.BugsDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.BugsFacadeRemote;

/**
 *
 * @author Shiva Gupta
 */
@Named(value = "bugsDTOListManagedBean")
@ViewScoped
public class bugsDTOListManagedBean implements Serializable {

    @EJB
    private BugsFacadeRemote bugsFacade;

    private int bugid;
    private String bugname;
    private String bugdesc;
    private String bugstatus;
    private String bugcreatedby;
    private String bugpriority;
    private ArrayList<BugsDTO> bugsDTOList;

    public bugsDTOListManagedBean() {
    }

    @PostConstruct
    public void getAllRecords() {
        bugsDTOList = bugsFacade.getAllRecords();
    }

    public BugsFacadeRemote getBugsFacade() {
        return bugsFacade;
    }

    public void setBugsFacade(BugsFacadeRemote bugsFacade) {
        this.bugsFacade = bugsFacade;
    }

    public ArrayList<BugsDTO> getBugsDTOList() {
        return bugsDTOList;
    }

    public void setBugsDTOList(ArrayList<BugsDTO> bugsDTOList) {
        this.bugsDTOList = bugsDTOList;
    }

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
