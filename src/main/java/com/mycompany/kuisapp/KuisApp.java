/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kuisapp;

import com.mycompany.kuisapp.view.HomeView;
import java.sql.SQLException;

/**
 *
 * @author LUTHFI NOVRA
 */
public class KuisApp {

    public static void main(String[] args) throws SQLException {
        HomeView app = new HomeView();
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}
