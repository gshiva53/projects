package web;

import entity.MembersDTO;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import session.MembersFacadeRemote;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Shiva Gupta
 */
@Named(value = "membersManagedBean")
@SessionScoped
public class MembersManagedBean implements Serializable {

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
                membteam, stringToSHA256(membpassword));

        if (membersFacade.createRecord(membDTO)) {
            this.info("Member added");
        } else {
            this.error("Member NOT added");
        }
    }

    public void updateMember() {
        MembersDTO membDTO = new MembersDTO(membid, membname, membemail, membrole,
                membteam, stringToSHA256(membpassword));

        if (membersFacade.updateRecord(membDTO)) {
            this.info("Member updated");
        } else {
            this.error("Member NOT updated");
        }
    }

    public void deleteMember() {
        if (membersFacade.deleteRecord(membid)) {
            this.warn("Member deleted");
        } else {
            this.error("Member NOT deleted");
        }
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

    //Faces Context messages methods 
    public void info(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
    }

    public void warn(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
    }

    public void error(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
    }

    public String stringToSHA256(String s) {
        String output = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = s;
            md.update(text.getBytes("UTF-8"));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            output = bigInt.toString(16);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
        }

        return output;
    }

    public String SHA256ToString(String SHA256String) {
        String output = null;

        try {
            output = DigestUtils.shaHex(SHA256String);
        } catch (Exception ex) {
        }

        return output;
    }
}
