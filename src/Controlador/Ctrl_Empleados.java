/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import java.sql.Connection;
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
public class Ctrl_Empleados {
    Connection con;
    Statement s;
    ResultSet rs;

    public Ctrl_Empleados(Connection con) {
        this.con = con;
    }
    
    public ArrayList<Empleado> devolverEmpleados(){
        ArrayList<Empleado> lista = new ArrayList();
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM EMPLEADOS ORDER BY dni");
            while (rs.next()) {
                Empleado e = new Empleado(rs.getString("dni"),rs.getString("nombre"),rs.getDouble("HorasMin"),rs.getDouble("precioHora"),rs.getDouble("precioHoraE"));
                lista.add(e);
            }
            s.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public boolean insertEmpleado(Empleado e){
        try {
            s = con.createStatement();
            s.executeUpdate("INSERT INTO EMPLEADOS (dni,nombre,HorasMin,precioHora,precioHoraE) VALUES (\'"+e.getDni()+"\',\'"+e.getNombre()+"\',"+e.getHorasMin()+","+e.getPrecioHora()+","+e.getPrecioHoraE()+")");
            s.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error : "+ex.getMessage());
            return false;
        }
    }
    
    public boolean deleteEmpleado(String dni){
        try {
            s = con.createStatement();
            s.executeUpdate("DELETE FROM EMPLEADOS WHERE dni = "+dni);
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
