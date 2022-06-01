package componentBeans;

import entity.MembersDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.MembersFacadeRemote;

/**
 *
 * @author Shiva Gupta
 */
@Named(value = "membersDTOListManagedBean")
@ViewScoped
public class membersDTOListManagedBean implements Serializable {

    @EJB
    private MembersFacadeRemote membersFacade;

    private int membid;
    private String membname;
    private String membemail;
    private String membrole;
    private String membteam;
    private String membpassword;
    private ArrayList<MembersDTO> membDTOList; 

    @PostConstruct
    public void getAllRecords() {
        membDTOList = membersFacade.getAllRecords(); 
    }

    public MembersFacadeRemote getMembersFacade() {
        return membersFacade;
    }

    public void setMembersFacade(MembersFacadeRemote membersFacade) {
        this.membersFacade = membersFacade;
    }

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

    public ArrayList<MembersDTO> getMembDTOList() {
        return membDTOList;
    }

    public void setMembDTOList(ArrayList<MembersDTO> membDTOList) {
        this.membDTOList = membDTOList;
    }
    
}
