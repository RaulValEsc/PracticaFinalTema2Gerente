/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Nomina;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Ctrl_Nominas {

    Connection con;
    Statement s;
    ResultSet rs;

    public Ctrl_Nominas(Connection con) {
        this.con = con;
    }

    public ArrayList<Nomina> devolverNominas() {
        ArrayList<Nomina> lista = new ArrayList();
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM NOMINAS");
            while (rs.next()) {
                Nomina n = new Nomina(rs.getInt("Anio"), rs.getInt("Mes"), rs.getString("dni"), rs.getDouble("SueldoH"), rs.getDouble("SueldoHE"));
                lista.add(n);
            }
            s.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean insertNomina(int anio, int mes, String dni) {
        try {
            CallableStatement sentencia = con.prepareCall("{call P_GENERARNOMINA(? , ?, ? ) }");
            sentencia.setInt(1, anio);
            sentencia.setInt(2, mes);
            sentencia.setString(3, dni);
            sentencia.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
            return false;
        }
    }

    public boolean generarNominas(int anio, int mes) {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT DNI FROM EMPLEADOS");
            while (rs.next()) {
                CallableStatement sentencia = con.prepareCall("{call P_GENERARNOMINA(? , ?, ? ) }");
                sentencia.setInt(1, anio);
                sentencia.setInt(2, mes);
                sentencia.setString(3,rs.getString("DNI"));
                sentencia.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteNomina(int anio, int mes, String dni) {
        try {
            s = con.createStatement();
            s.executeUpdate("DELETE FROM NOMINAS WHERE anio = " + anio + " AND mes = " + mes + " AND dni = '" + dni + "'");
            s.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
            return false;
        }
    }

    public boolean updateNomina(Nomina n) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE NOMINAS SET ANIO = ?, MES = ?, DNI = ?, SUELDOH = ?, SUELDOHE = ? WHERE ANIO = ? AND MES = ? AND DNI = ?");
            ps.setInt(1, n.getAnio());
            ps.setInt(2, n.getMes());
            ps.setString(3, n.getDni());
            ps.setDouble(4, n.getSueldoH());
            ps.setDouble(5, n.getSueldoHE());
            ps.setInt(6, n.getAnio());
            ps.setInt(7, n.getMes());
            ps.setString(8, n.getDni());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
            return false;
        }
    }
}
