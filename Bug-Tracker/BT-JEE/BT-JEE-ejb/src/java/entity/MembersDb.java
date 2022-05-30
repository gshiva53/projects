package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shiva Gupta
 */
@Entity
@Table(name = "MEMBERS_DB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MembersDb.findAll", query = "SELECT m FROM MembersDb m"),
    @NamedQuery(name = "MembersDb.findByMembid", query = "SELECT m FROM MembersDb m WHERE m.membid = :membid"),
    @NamedQuery(name = "MembersDb.findByMembname", query = "SELECT m FROM MembersDb m WHERE m.membname = :membname"),
    @NamedQuery(name = "MembersDb.findByMembemail", query = "SELECT m FROM MembersDb m WHERE m.membemail = :membemail"),
    @NamedQuery(name = "MembersDb.findByMembrole", query = "SELECT m FROM MembersDb m WHERE m.membrole = :membrole"),
    @NamedQuery(name = "MembersDb.findByMembteam", query = "SELECT m FROM MembersDb m WHERE m.membteam = :membteam"),
    @NamedQuery(name = "MembersDb.findByMembpassword", query = "SELECT m FROM MembersDb m WHERE m.membpassword = :membpassword")})
public class MembersDb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBID")
    private Integer membid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MEMBNAME")
    private String membname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MEMBEMAIL")
    private String membemail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MEMBROLE")
    private String membrole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MEMBTEAM")
    private String membteam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MEMBPASSWORD")
    private String membpassword;

    public MembersDb() {
    }

    public MembersDb(Integer membid) {
        this.membid = membid;
    }

    public MembersDb(Integer membid, String membname, String membemail, String membrole, String membteam, String membpassword) {
        this.membid = membid;
        this.membname = membname;
        this.membemail = membemail;
        this.membrole = membrole;
        this.membteam = membteam;
        this.membpassword = membpassword;
    }

    public Integer getMembid() {
        return membid;
    }

    public void setMembid(Integer membid) {
        this.membid = membid;
    }

    public String getMembname() {
        return membname;
    }

    public void setMembname(String membname) {
        this.membname = membname;
    }

    public String getMembemail() {
        return membemail;
    }

    public void setMembemail(String membemail) {
        this.membemail = membemail;
    }

    public String getMembrole() {
        return membrole;
    }

    public void setMembrole(String membrole) {
        this.membrole = membrole;
    }

    public String getMembteam() {
        return membteam;
    }

    public void setMembteam(String membteam) {
        this.membteam = membteam;
    }

    public String getMembpassword() {
        return membpassword;
    }

    public void setMembpassword(String membpassword) {
        this.membpassword = membpassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (membid != null ? membid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MembersDb)) {
            return false;
        }
        MembersDb other = (MembersDb) object;
        if ((this.membid == null && other.membid != null) || (this.membid != null && !this.membid.equals(other.membid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MembersDb[ membid=" + membid + " ]";
    }
    
}
