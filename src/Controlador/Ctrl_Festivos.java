/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Festivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author PC
 */
public class Ctrl_Festivos {

    Connection con;
    Statement s;
    PreparedStatement ps;
    ResultSet rs;

    public Ctrl_Festivos(Connection con) {
        this.con = con;
    }

    public ArrayList<Festivo> devolverFestivos() {
        ArrayList<Festivo> lista = new ArrayList();
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM FESTIVOS ORDER BY FECHA");
            while (rs.next()) {
                Festivo f = new Festivo(rs.getDate("Fecha"));
                lista.add(f);
            }
            s.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }
        return lista;
    }

    public boolean insertFestivo(Festivo f) {
        try {
            ps = con.prepareStatement("INSERT INTO FESTIVOS (Fecha) VALUES (?)");
            ps.setDate(1,f.getFecha());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteFestivo(Date fecha) {
        try {
            ps = con.prepareStatement("DELETE FROM FESTIVOS WHERE FECHA = ?");
            ps.setDate(1,fecha);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
            return false;
        }
    }
}
