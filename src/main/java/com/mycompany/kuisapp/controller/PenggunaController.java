/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kuisapp.controller;

import com.mycompany.kuisapp.DAO.GuruDAO;
import com.mycompany.kuisapp.DAO.SiswaDAO;
import com.mycompany.kuisapp.model.Guru;
import com.mycompany.kuisapp.model.Siswa;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author LUTHFI NOVRA
 */
public class PenggunaController {
    private final GuruDAO guruDAO;
    private final SiswaDAO siswaDAO;

    public PenggunaController(GuruDAO guruDAO, SiswaDAO siswaDAO) {
        this.guruDAO = guruDAO;
        this.siswaDAO = siswaDAO;
    }

    public void register(String name, String username, char[] password, String role) {
        if (role.equals("GURU")) {
            if (guruDAO.isUsernameExists(username)) {
                JOptionPane.showMessageDialog(null, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Hash the password with a salt
            String hashedPassword = BCrypt.hashpw(new String(password), BCrypt.gensalt());
            guruDAO.addGuru(new Guru(name, username, hashedPassword));
        } else if (role.equals("SISWA")) {
            if (siswaDAO.isUsernameExists(username)) {
                JOptionPane.showMessageDialog(null, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Hash the password with a salt
            String hashedPassword = BCrypt.hashpw(new String(password), BCrypt.gensalt());
            siswaDAO.addSiswa(new Siswa(name, username, hashedPassword));
        }

        JOptionPane.showMessageDialog(null, "Registration successful", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean login(String username, char[] password, String role) {
        if (role.equals("GURU")) {
            Guru guru = guruDAO.getGuruByUsername(username);
            if (guru != null && BCrypt.checkpw(new String(password), guru.getPassword())) {
                JOptionPane.showMessageDialog(null, "login successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } else if (role.equals("SISWA")) {
            Siswa siswa = siswaDAO.getSiswaByUsername(username);
            if (siswa != null && BCrypt.checkpw(new String(password), siswa.getPassword())) {
                JOptionPane.showMessageDialog(null, "login successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }

        JOptionPane.showMessageDialog(null, "Login failed", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
