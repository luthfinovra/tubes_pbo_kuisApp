/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.model;

import com.mycompany.kuisapp.util.Pengguna;

/**
 *
 * @author LUTHFI NOVRA
 */
public class Siswa extends Pengguna{

    public Siswa(String nama, String username, String password) {
        super(nama, username, password);
    }

    @Override
    public String getRole() {
        return "SISWA";
    }
    
}
