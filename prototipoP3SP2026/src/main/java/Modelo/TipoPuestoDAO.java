/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.clsBitacora;
import Controlador.clsPerfil;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlador.clsTipoPuesto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mishel
 */
public class TipoPuestoDAO {
    private static final String SQL_SELECT = "SELECT ID_TIPO_PUESTO, NOMBRE_PUESTO,SALARIO FROM tipo_puesto";
    private static final String SQL_INSERT = "INSERT INTO tipo_puesto(NOMBRE_PUESTO) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE tipo_puesto SET NOMBRE_PUESTO=?,SALARIO=? WHERE ID_TIPO_PUESTO = ?";
    private static final String SQL_DELETE = "DELETE FROM tipo_puesto WHERE ID_TIPO_PUESTO=?";
    private static final String SQL_QUERY = "SELECT ID_TIPO_PUESTO, NOMBRE_PUESTO,SALARIO FROM tipo_puesto WHERE ID_TIPO_PUESTO = ?";

    public List<clsTipoPuesto> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsTipoPuesto empresa = null;
        List<clsTipoPuesto> empresas = new ArrayList<clsTipoPuesto>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoempresa = rs.getInt("ID_TIPO_PUESTO");
                String nombrePuesto = rs.getString("NOMBRE_PUESTO");
                double salario = rs.getDouble("SALARIO");
                
                empresa = new clsTipoPuesto();
                empresa.setIdTipoPuesto(codigoempresa);
                empresa.setNombrePuesto(nombrePuesto);
                empresa.setSalario(salario);
                                
                empresas.add(empresa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return empresas;
    }

    public int insert(clsTipoPuesto empresa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empresa.getNombrePuesto());
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(clsTipoPuesto empresa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empresa.getNombrePuesto());
            stmt.setInt(2, empresa.getIdTipoPuesto());
            stmt.setDouble(3, empresa.getSalario());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(clsTipoPuesto empresa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empresa.getIdTipoPuesto());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
  public clsTipoPuesto query(clsTipoPuesto empresa) {    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    clsTipoPuesto resultado = null;

    try {
        conn = Conexion.getConnection();
        System.out.println("Ejecutando query:" + SQL_QUERY);
        stmt = conn.prepareStatement(SQL_QUERY);
        stmt.setInt(1, empresa.getIdTipoPuesto());
        rs = stmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("ID_TIPO_PUESTO");
            String nombre = rs.getString("NOMBRE_PUESTO");
            double salario = rs.getDouble("SALARIO");

            resultado = new clsTipoPuesto();
            resultado.setIdTipoPuesto(id);
            resultado.setNombrePuesto(nombre);
            resultado.setSalario(salario);
        }

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return resultado;
}
}
