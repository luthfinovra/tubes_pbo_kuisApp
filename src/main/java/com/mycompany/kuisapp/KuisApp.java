/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kuisapp;

import com.mycompany.kuisapp.model.GuruModel;
import com.mycompany.kuisapp.model.SiswaModel;
import com.mycompany.kuisapp.view.HomeView;
import java.sql.SQLException;

/**
 *
 * @author LUTHFI NOVRA
 */
public class KuisApp {

    public static void main(String[] args) throws SQLException {
        GuruModel guruModel = new GuruModel();
        SiswaModel siswaModel = new SiswaModel();
        HomeView app = new HomeView();
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}
