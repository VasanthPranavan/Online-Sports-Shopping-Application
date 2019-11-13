/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

/**
 *
 * @author Vasanth Pranavan
 */
@Named
@ApplicationScoped
@DeclareRoles({"ADMIN_ROLE", "PHYSICIAN_ROLE", "CUSTOMER_ROLE"})
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                errorPage = "/error.xhtml")
)
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/itmd4515DS",
        callerQuery = "select PASSWORD from sec_user where USERNAME = ?",
        groupsQuery = "select GROUPNAME from sec_user_groups where USERNAME = ?"
)
public class SecurityConfig {

}
