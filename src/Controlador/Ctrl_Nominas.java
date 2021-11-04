/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.Nomina;
import java.sql.Connection;
import java.sql.Date;
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
    
    public ArrayList<Nomina> devolverNominas(){
        ArrayList<Nomina> lista = new ArrayList();
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM NOMINAS");
            while (rs.next()) {
                Nomina n = new Nomina(rs.getInt("Anio"),rs.getInt("Mes"),rs.getString("dni"),rs.getDouble("SueldoH"),rs.getDouble("SueldoHE"));
                lista.add(n);
            }
            s.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    //TODO Este se hace con el procedure
    public boolean insertNomina(Nomina n){
        try {
            s = con.createStatement();
            s.executeUpdate("INSERT INTO EMPLEADOS (ANIO,MES,DNI,SUELDOH,SUELDOHE) VALUES (\'"+e.getDni()+"\',\'"+e.getNombre()+"\',"+e.getHorasMin()+","+e.getPrecioHora()+","+e.getPrecioHoraE()+")");
            s.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error : "+ex.getMessage());
            return false;
        }
    }
    
    public boolean generarNominas(Date fecha){
        //TODO Este se hace con el procedure
        return true;
    }
    
    public boolean deleteNomina(int anio, int mes, String dni){
        try {
            s = con.createStatement();
            s.executeUpdate("DELETE FROM NOMINAS WHERE anio = "+anio+" AND mes = "+mes+" AND dni = '"+dni+"'");
            s.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR : "+ex.getMessage());
            return false;
        }
    }
    
    public boolean updateEmpleado(Empleado e){
        try {
            s=con.createStatement();
            s.executeUpdate("UPDATE EMPLEADOS SET nombre = \'"+e.getNombre()+"\', HorasMin = "+e.getHorasMin()+", precioHora = "+e.getPrecioHora()+", precioHoraE = "+e.getPrecioHoraE()+" WHERE dni = "+e.getDni());
            s.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR : "+ex.getMessage());
            return false;
        }
    }
}