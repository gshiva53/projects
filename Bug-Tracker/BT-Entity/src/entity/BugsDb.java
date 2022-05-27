/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shiva Gupta
 * This class represents the Bugs DB. This is an entity class. Refer to lab 03. 
 */
@Entity
@Table(name = "BUGS_DB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BugsDb.findAll", query = "SELECT b FROM BugsDb b"),
    @NamedQuery(name = "BugsDb.findByBugid", query = "SELECT b FROM BugsDb b WHERE b.bugid = :bugid"),
    @NamedQuery(name = "BugsDb.findByBugname", query = "SELECT b FROM BugsDb b WHERE b.bugname = :bugname"),
    @NamedQuery(name = "BugsDb.findByBugdesc", query = "SELECT b FROM BugsDb b WHERE b.bugdesc = :bugdesc"),
    @NamedQuery(name = "BugsDb.findByBugstatus", query = "SELECT b FROM BugsDb b WHERE b.bugstatus = :bugstatus"),
    @NamedQuery(name = "BugsDb.findByBugcreatedby", query = "SELECT b FROM BugsDb b WHERE b.bugcreatedby = :bugcreatedby"),
    @NamedQuery(name = "BugsDb.findByBugpriority", query = "SELECT b FROM BugsDb b WHERE b.bugpriority = :bugpriority")})
public class BugsDb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BUGID")
    private Integer bugid;
    @Basic(optional = false)
    @Column(name = "BUGNAME")
    private String bugname;
    @Column(name = "BUGDESC")
    private String bugdesc;
    @Basic(optional = false)
    @Column(name = "BUGSTATUS")
    private String bugstatus;
    @Basic(optional = false)
    @Column(name = "BUGCREATEDBY")
    private String bugcreatedby;
    @Basic(optional = false)
    @Column(name = "BUGPRIORITY")
    private String bugpriority;

    public BugsDb() {
    }

    public BugsDb(Integer bugid) {
        this.bugid = bugid;
    }

    public BugsDb(int bugid, String bugname, String bugstatus, String bugcreatedby, String bugpriority) {
        this.bugid = bugid;
        this.bugname = bugname;
        this.bugstatus = bugstatus;
        this.bugcreatedby = bugcreatedby;
        this.bugpriority = bugpriority;
    }

    public int getBugid() {
        return bugid;
    }

    public void setBugid(Integer bugid) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bugid != null ? bugid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BugsDb)) {
            return false;
        }
        BugsDb other = (BugsDb) object;
        if ((this.bugid == null && other.bugid != null) || (this.bugid != null && !this.bugid.equals(other.bugid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BugsDb[ bugid=" + bugid + " ]";
    }
    
}
