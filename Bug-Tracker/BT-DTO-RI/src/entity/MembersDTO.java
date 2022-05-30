package entity;

import java.io.Serializable;

/**
 *
 * @author Shiva Gupta
 */
public class MembersDTO implements Serializable{
    private final int membid; 
    private final String membname; 
    private final String membemail; 
    private final String membrole; 
    private final String membteam;
    private final String membpassword; 

    public MembersDTO(int membid, String membname, String membemail, String membrole, String membteam, String membpassword) {
        this.membid = membid;
        this.membname = membname;
        this.membemail = membemail;
        this.membrole = membrole;
        this.membteam = membteam;
        this.membpassword = membpassword;
    }
    
    public int getMembid() {
        return membid;
    }

    public String getMembname() {
        return membname;
    }

    public String getMembemail() {
        return membemail;
    }

    public String getMembrole() {
        return membrole;
    }

    public String getMembteam() {
        return membteam;
    }

    public String getMembpassword() {
        return membpassword;
    }

}
