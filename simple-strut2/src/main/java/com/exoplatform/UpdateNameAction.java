package com.exoplatform;

import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.apache.struts2.portlet.interceptor.PortletPreferencesAware;
import org.exoplatform.container.ExoContainer;
import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.services.organization.OrganizationService;
import org.exoplatform.services.organization.User;
import org.exoplatform.services.organization.UserProfile;

/**
 * @author <a href="kienna@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
public class UpdateNameAction extends DefaultActionSupport implements PortletPreferencesAware
{
   private static final long serialVersionUID = 1L;

   private String firstName;

   private String lastName;

   private PortletPreferences preferences;

   @Override
   public String execute() throws Exception
   {
      preferences.setValue("firstName", firstName);
      preferences.setValue("lastName", lastName);
      preferences.store();
      getActionMessages().add("Name updated");
      
      HttpServletRequest request = ServletActionContext.getRequest();
      if (request.getRemoteUser() != null) {
         ExoContainer exoContainer =
                  ExoContainerContext.getCurrentContainer();
         OrganizationService orgService = (OrganizationService) exoContainer.getComponentInstanceOfType(OrganizationService.class);
         User user = orgService.getUserHandler().findUserByName(request.getRemoteUser());
         user.setFirstName(firstName);
         user.setLastName(lastName);
         orgService.getUserHandler().saveUser(user, true);
      }
      
      return SUCCESS;
   }

   @Override
   public String input() throws Exception
   {
      firstName = preferences.getValue("firstName", "");
      lastName = preferences.getValue("lastName", "");
      return INPUT;
   }

   public void setPortletPreferences(PortletPreferences preferences)
   {
      this.preferences = preferences;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getLastName()
   {
      return lastName;
   }

}
