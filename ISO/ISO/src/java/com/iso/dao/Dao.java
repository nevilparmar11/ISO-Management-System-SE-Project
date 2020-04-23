/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dao;

import java.util.List;

/**
 *
 * @author Nitant
 */
public interface Dao<T> {
    
    public List<T> view();
    public int delete(T obj);
    public int update(T obj);
    public int insert(T obj);
}
