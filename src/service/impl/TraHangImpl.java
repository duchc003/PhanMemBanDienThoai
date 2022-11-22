/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.TraHangReposotory;
import service.TraHangService;
import viewmodel.TraHangViewmodel;

/**
 *
 * @author HieuIT
 */
public class TraHangImpl implements TraHangService{

    private TraHangReposotory TraHangReposotory = new TraHangReposotory();
    
    @Override
    public List<TraHangViewmodel> getAll() {
        return TraHangReposotory.getAll();
    }
    
}
