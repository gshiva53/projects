package Bugs;

import java.io.Serializable;

/**
 *
 * @author Shiva Gupta This class is the Data Transfer Object class(DTO). Refer
 * to Lab 03.
 */
public class BugsDTO implements Serializable {

    private final int bugid;
    private final String bugname;
    private final String bugdesc;
    private final String bugstatus;
    private final String bugcreatedby;
    private final String bugpriority;

    public BugsDTO(int id, String name, String desc, String status, String createdby, String priority) {
        this.bugid = id;
        this.bugname = name;
        this.bugdesc = desc;
        this.bugstatus = status;
        this.bugcreatedby = createdby;
        this.bugpriority = priority;
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
