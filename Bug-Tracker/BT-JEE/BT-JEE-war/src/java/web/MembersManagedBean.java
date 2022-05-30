package web;

import entity.MembersDTO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import session.MembersFacadeRemote;

/**
 *
 * @author Shiva Gupta
 */
@Named(value = "membersManagedBean")
@SessionScoped
public class MembersManagedBean implements Serializable{

    @EJB
    private MembersFacadeRemote membersFacade;
    
    private int membid; 
    private String membname; 
    private String membemail; 
    private String membrole; 
    private String membteam; 
    private String membpassword;
    
    public void addMember() {
        MembersDTO membDTO = new MembersDTO(membid, membname, membemail, membrole, 
        membteam, membpassword); 
        
        boolean result = membersFacade.createRecord(membDTO); 
        System.out.println("New Members has been added in the system: "
                + result
                + "\n" + membid
                + "\n" + membname );
    }
    
    //MembersFacade getter and setter methods
    public MembersFacadeRemote getMembersFacade() {
        return membersFacade;
    }

    public void setMembersFacade(MembersFacadeRemote membersFacade) {
        this.membersFacade = membersFacade;
    }
    
    //Field getter and setter methods
    public int getMembid() {
        return membid;
    }

    public void setMembid(int membid) {
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
    
    public MembersManagedBean() {
    }
    
}
