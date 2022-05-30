package session;

import javax.ejb.Remote;
import entity.BugsDTO; 
import java.util.ArrayList;

/**
 *
 * @author Shiva Gupta
 * Remote Interface class for Bugs DB class. 
 */
@Remote
public interface BugsFacadeRemote {
    public boolean createRecord(BugsDTO bugDTO);
    public boolean updateRecord(BugsDTO bugDTO); 
    public boolean deleteRecord(int bugid); 
    public BugsDTO getRecord(int bugid);
     public ArrayList<BugsDTO> getAllRecords(); 
}
