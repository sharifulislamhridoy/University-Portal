/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.web.commonInterface;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author shari
 */
public interface IcommonController<T> {

    public T create();

    public T save(T t);

    public ResponseEntity<T> edit(int id);

    public ResponseEntity<T> update(Integer id,T t);

    public List<T> getAll();

    public ResponseEntity<T> delete(Integer id);

    public ResponseEntity<T> getById(Integer id);

}
