package componentBeans;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Shiva Gupta
 */
@Named(value = "bugsGrowlManagedBean")
@Dependent
public class bugsGrowlManagedBean implements Serializable{
    public String bugAddMessage;  
    
    //add a FacesMessage to FacesContext
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    //add different severity messages
    public void showInfo() { 
        System.out.println("bugAddMessage" + bugAddMessage);
        addMessage(FacesMessage.SEVERITY_INFO, "Info", bugAddMessage);
    }

    public void showWarn(String message) {
        addMessage(FacesMessage.SEVERITY_WARN, "Warn", message);
    }

    public void showError(String message) {
        addMessage(FacesMessage.SEVERITY_ERROR, "Error", message);
    }
}
