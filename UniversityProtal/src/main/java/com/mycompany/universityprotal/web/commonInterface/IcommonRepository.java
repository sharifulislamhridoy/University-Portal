/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.web.commonInterface;

/**
 *
 * @author shari
 */
import java.util.List;

public interface IcommonRepository<T> {

    public T save(T object);

    public List<T> viewAll();

    public T update(T object);

    public T delete(int id);

    public T getById(int id);

}
