/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Fichaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Ctrl_Fichajes {
    Connection con;
    Statement s;
    PreparedStatement ps;
    ResultSet rs;

    public Ctrl_Fichajes(Connection con) {
        this.con = con;
    }
    
    public ArrayList<Fichaje> devolverFichajes(){
        ArrayList<Fichaje> lista = new ArrayList();
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM FICHAJES ORDER BY idFichaje");
            while (rs.next()) {
                Fichaje f = new Fichaje(rs.getInt("IdFichaje"),rs.getString("dni"),rs.getTimestamp("FecHoraIni"),rs.getTimestamp("FecHoraFin"));
                lista.add(f);
            }
            s.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }
        return lista;
    }
    
    public boolean insertFichaje(Fichaje f){
        try {
            ps = con.prepareStatement("INSERT INTO FICHAJES (IdFichaje,dni,FecHoraIni,FecHoraFin) VALUES (?,?,?,?)");
            ps.setInt(1,f.getIdFichaje());
            ps.setString(2, f.getDni());
            ps.setTimestamp(3, f.getFecHoraIni());
            ps.setTimestamp(4, f.getFecHoraFin());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR : " + ex.getMessage());
            return false;
        }
    }
    
    public boolean deleteFichaje(int idFichaje){
        try {
            s = con.createStatement();
            s.executeUpdate("DELETE FROM FICHAJES WHERE IdFichaje = "+idFichaje);
            s.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR : "+ex.getMessage());
            return false;
        }
    }
    
    public boolean updateFichaje(Fichaje f){
        try {
            ps=con.prepareStatement("UPDATE FICHAJES SET idFichaje = ?, dni = ?, FecHoraIni = ?, FecHoraFin = ? WHERE idFichaje = ?");
            ps.setInt(1, f.getIdFichaje());
            ps.setString(2, f.getDni());
            ps.setTimestamp(3, f.getFecHoraIni());
            ps.setTimestamp(4, f.getFecHoraFin());
            ps.setInt(5, f.getIdFichaje());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR : "+ex.getMessage());
            return false;
        }
    }
}