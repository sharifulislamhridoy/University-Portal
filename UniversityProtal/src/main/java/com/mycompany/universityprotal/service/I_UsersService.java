/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.service;

import com.mycompany.universityprotal.model.Users;
import com.mycompany.universityprotal.web.commonInterface.IcommonService;

/**
 *
 * @author shari
 */
public interface I_UsersService extends IcommonService<Users>{
      public Users getEmailPassword(String  email,String password);
}
