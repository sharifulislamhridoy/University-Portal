/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.web.commonInterface;

import java.util.List;

/**
 *
 * @author shari
 */
public interface IcommonService<T> {

    public T save(T t);

    public List<T> viewAll();

    public void update(T t);

    public void delete(Integer id);

    public T getById(Integer id);
}
