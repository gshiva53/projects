package session;

import entity.MembersDTO;
import javax.ejb.Remote;

@Remote
public interface MembersFacadeRemote {
     public boolean createRecord(MembersDTO membDTO);
     public boolean updateRecord(MembersDTO membDTO); 
     public boolean deleteRecord(int membid); 
     public MembersDTO getRecord(int membid); 
}
