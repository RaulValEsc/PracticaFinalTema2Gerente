/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Ctrl_BD {

    Connection con;
    DatabaseMetaData metaData;

    ResultSet rs;

    BufferedReader br;
    FileReader fr;
    File f;
    String servidor, puerto, id, usuario, password;

    public Ctrl_BD() {

    }

    public boolean conectarBD() {
        conectarFichero();
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@" + servidor + ":" + puerto + ":" + id, usuario, password);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
            return false;
        }
    }

    public void conectarMetaData() {
        try {
            metaData = con.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void conectarFichero() {
        f = new File("./src/CredencialesBD/CredencialesBD.txt");
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            servidor = br.readLine();
            puerto = br.readLine();
            id = br.readLine();
            usuario = br.readLine();
            password = br.readLine();
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public Connection getConexion() {
        return this.con;
    }

    public void cerrarConexion() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String hola(){
        String tipo = "hola";
        try{
            rs = metaData.getColumns(null, metaData.getUserName(), "Empleados", "dni");
            while(rs.next()){
            tipo = rs.getString(6);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return tipo;
    }

    public ArrayList<String> devolverConsultas() {
        ArrayList<String> listaConsultas = new ArrayList();
        try {
            Statement s = con.createStatement();
            rs = s.executeQuery("SELECT DESCRIPCION FROM CAMPOS");
            while (rs.next()) {
                listaConsultas.add(rs.getString("DESCRIPCION"));
            }
            rs.close();
            s.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return listaConsultas;
    }

    public int conocerTipoColumna(String descripcion) {
        String tipo = "";
        String tabla, campo;
        try {
            Statement s = con.createStatement();
            rs = s.executeQuery("SELECT TABLA, CAMPO FROM CAMPOS WHERE DESCRIPCION = '" + descripcion + "'");
            rs.next();
            tabla = rs.getString("TABLA");
            campo = rs.getString("CAMPO");
            rs.close();
            s.close();
            rs = metaData.getColumns(null, metaData.getUserName(), tabla, campo);
            System.out.println(tabla + " " + campo + " " + metaData.getUserName());
            rs.next();
            tipo = rs.getString(6);
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        switch (tipo) {
            case "VARCHAR2":
                return 1;
            case "NUMBER":
                return 2;
            case "BOOLEAN":
                return 3;
            default:
                return -1;
        }
    }

    public String redactarSelect(String descripcion, String operador, String valor, boolean LIKE) {
        String select;
        String tabla = "", campo = "";
        try {
            Statement s = con.createStatement();
            rs = s.executeQuery("SELECT TABLA, CAMPO FROM CAMPOS WHERE DESCRIPCION = '" + descripcion + "'");
            rs.next();
            tabla = rs.getString("TABLA");
            campo = rs.getString("CAMPO");
            rs.close();
            s.close();
        } catch (SQLException ex) {
            System.out.println("ERROR : "+ex.getMessage());
        }
        if (LIKE) {
            select = ("SELECT * FROM " + tabla + " WHERE " + campo + " " + operador + " \'%" + valor + "%\'");
        } else {
            select = ("SELECT * FROM " + tabla + " WHERE " + campo + " " + operador + " \'" + valor + "\'");
        }
        return select;

    }

    public ArrayList<String> nombresColumnas(String select) {
        ArrayList<String> listaColumnas = new ArrayList();
        int numColumnas = 0;
        Statement s = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery(select);
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                listaColumnas.add(rsmd.getColumnName(i));
            }
            rs.close();
            s.close();

        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return listaColumnas;
    }

    public ArrayList<String[]> devolverRegistros(String select) {
        ArrayList<String[]> listaRegistros = new ArrayList();
        String[] registro;
        ArrayList<String> auxiliar = new ArrayList();
        int numColumnas = 0;
        Statement s = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery(select);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                auxiliar.clear();
                registro = new String[rsmd.getColumnCount()];
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    auxiliar.add(rs.getString(rsmd.getColumnName(i)));
                }
                auxiliar.toArray(registro);
                listaRegistros.add(registro);
            }
            rs.close();
            s.close();

        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return listaRegistros;
    }

}
