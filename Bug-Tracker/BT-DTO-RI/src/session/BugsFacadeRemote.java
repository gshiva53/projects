/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Remote;
import entity.BugsDTO; 

/**
 *
 * @author Shiva Gupta
 */
@Remote
public interface BugsFacadeRemote {
    public boolean createRecord(BugsDTO bugDTO);
    public boolean updateRecord(BugsDTO bugDTO); 
    public boolean deleteRecord(int bugid); 
    public BugsDTO getRecord(int bugid);
}
