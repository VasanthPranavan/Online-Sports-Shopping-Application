/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.web;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Vasanth Pranavan
 */
@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    @NotBlank(message = "Please enter your username")
    private String username;
    @NotBlank(message = "Please enter your password")
    private String password;

    @Inject
    private SecurityContext securityContext;
    @Inject
    private FacesContext facesContext;
    @Inject
    private ExternalContext externalContext;

    /**
     *
     */
    public LoginController() {
    }

    /**
     *
     * @return
     */
    public String getRemoteUser() {
        return externalContext.getRemoteUser();
    }

    /**
     *
     * @return
     */
    public boolean isAdmin() {
        return securityContext.isCallerInRole("ADMIN_ROLE");
    }

    /**
     *
     * @return
     */
    public boolean isPhysician() {
        return securityContext.isCallerInRole("PHYSICIAN_ROLE");
    }

    /**
     *
     * @return
     */
    public boolean isCustomer() {
        return securityContext.isCallerInRole("CUSTOMER_ROLE");
    }

    /**
     *
     * @return
     */
    public String doLogout() {

        try {
            ((HttpServletRequest)externalContext.getRequest()).logout();
      
        } catch (ServletException ex) {
           LOG.log(Level.SEVERE, null, ex);
           return "/error.xhtml";
        }
        return "/login.xhtml?faces-redirect=true";

    }

    /**
     *
     * @return
     */
    public String doLogin() {

        LOG.info("in doLogin");

        Credential credential = new UsernamePasswordCredential(username, new Password(password));

        AuthenticationStatus status = securityContext.authenticate(
                (HttpServletRequest) externalContext.getRequest(),
                (HttpServletResponse) externalContext.getResponse(),
                AuthenticationParameters.withParams().credential(credential));

        LOG.info("authentication ststus " + status.toString());

        switch (status) {
            case NOT_DONE:
                LOG.info("case is NOT_DONE");
                return "/error.xhtml";
            case SEND_CONTINUE:
                LOG.info("case is SEND_CONTINUE");
                break;
            case SEND_FAILURE:
                LOG.info("case is SEND_FAILURE");
                return "/error.xhtml";

            case SUCCESS:
                LOG.info("case is SUCCESS");
                break;
        }
        return "/welcome.xhtml?faces-redirect=true";

    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
