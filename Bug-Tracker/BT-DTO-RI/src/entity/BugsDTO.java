package entity;

import java.io.Serializable;

/**
 *
 * @author Shiva Gupta
 */
public class BugsDTO implements Serializable {

    private final int bugid;
    private final String bugname;
    private final String bugdesc;
    private final String bugstatus;
    private final String bugcreatedby;
    private final String bugpriority;

    public BugsDTO(int bugid, String bugname, String bugdesc, String bugstatus, String bugcreatedby, String bugpriority) {
        this.bugid = bugid;
        this.bugname = bugname;
        this.bugdesc = bugdesc;
        this.bugstatus = bugstatus;
        this.bugcreatedby = bugcreatedby;
        this.bugpriority = bugpriority;
    }

    public int getBugid() {
        return bugid;
    }

    public String getBugname() {
        return bugname;
    }

    public String getBugdesc() {
        return bugdesc;
    }

    public String getBugstatus() {
        return bugstatus;
    }

    public String getBugcreatedby() {
        return bugcreatedby;
    }

    public String getBugpriority() {
        return bugpriority;
    }
}
