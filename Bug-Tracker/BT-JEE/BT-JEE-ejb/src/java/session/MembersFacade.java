package session;

import entity.MembersDTO;
import entity.MembersDb;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Shiva Gupta
 */
@Stateless
public class MembersFacade implements MembersFacadeRemote {

    @PersistenceContext(unitName = "BT-JEE-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    //Private CRUD operations for MembersDb
    private void create(MembersDb member) {
        em.persist(member);
    }

    private void edit(MembersDb member) {
        em.merge(member);
    }

    private void remove(MembersDb member) {
        em.remove(em.merge(member));
    }

    private MembersDb find(Object id) {
        return em.find(MembersDb.class, id);
    }

    //CRUD operations functionality exposed
    @Override
    public boolean createRecord(MembersDTO membDTO) {
        if (find(membDTO.getMembid()) != null) {
            // member whose id can be found
            return false;
        }
        // member whose id could not be found
        try {
            MembersDb memb = this.DTO2DAO(membDTO);
            this.create(memb); // add to database
        } catch (Exception ex) {
        }
        return true;
    }

    @Override
    public boolean updateRecord(MembersDTO membDTO) {
        if (find(membDTO.getMembid()) == null) {
            return false;
        }
        try {
            MembersDb memb = this.DTO2DAO(membDTO);
            this.edit(memb);
            return true;
        } catch (Exception ex) {
        }
        return false;
    }

    @Override
    public boolean deleteRecord(int membid) {
        if (find(membid) == null) {
            return false; //membid  does not exist in the table
        }
        try {
            this.remove(find(membid));
            return true;
        } catch (Exception ex) {
        }
        return false;
    }

    @Override
    public MembersDTO getRecord(int membid) {
        if (find(membid) != null) {
            return this.DAO2DTO(find(membid));
        }
        //if the memb with membid is NOT found 
        return null;
    }

    @Override
    public ArrayList<MembersDTO> getAllRecords() {
        javax.persistence.Query query;
        query = em.createNamedQuery("MembersDb.findAll");
        List<MembersDb> members = query.getResultList();
        ArrayList<MembersDTO> membersDTO  = new ArrayList<>();

        for (MembersDb member : members) {
            MembersDTO membDTO = this.DAO2DTO(member);
            membersDTO.add(membDTO);
        }
        return membersDTO ;
    }

    //information passing between DAO and DTO 
    private MembersDb DTO2DAO(MembersDTO membDTO) {
        MembersDb memb = new MembersDb();

        memb.setMembid(membDTO.getMembid());
        memb.setMembname(membDTO.getMembname());
        memb.setMembemail(membDTO.getMembemail());
        memb.setMembrole(membDTO.getMembrole());
        memb.setMembteam(membDTO.getMembteam());
        memb.setMembpassword(membDTO.getMembpassword());

        return memb;
    }

    private MembersDTO DAO2DTO(MembersDb memb) {
        MembersDTO membDTO = new MembersDTO(memb.getMembid(),
                memb.getMembname(),
                memb.getMembemail(),
                memb.getMembrole(),
                memb.getMembteam(),
                memb.getMembpassword());

        return membDTO;
    }
}
