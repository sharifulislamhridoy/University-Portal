/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.web.ControllerImpliment;

import com.mycompany.universityprotal.model.Users;
import com.mycompany.universityprotal.web.commonInterface.IcommonController;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author shari
 */
public interface I_UsersController extends IcommonController<Users>{
     public ResponseEntity<Users> getEmailPassword(String  email,String password);
}
