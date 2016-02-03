package Modelo;

import Comunes.Ciclista;
import Comunes.CiclistaMaillotEtapa;
import Comunes.Equipo;
import Comunes.Etapa;
import Comunes.Maillot;
import Comunes.Puerto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConexionBD {

    private static final ConexionBD cbd = new ConexionBD();
    private Connection con;

    private ConexionBD() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al iniciar la conexión a la base de datos.");
        }
    }

    public static ConexionBD getInstance() {
        return cbd;
    }

    public boolean insert(Object o) {
        boolean response = true;
        PreparedStatement ps;
        if (o instanceof Ciclista) {
            ps = insertarCiclista((Ciclista) o);
        } else if(o instanceof Equipo){
            ps = insertarEquipo((Equipo)o);
        } else {
            ps = null;
        }
        if (ps == null) {
            response = false;
        } else {
            try {
                ps.execute();
            } catch (SQLException ex) {
                response = false;
            }
        }
        return response;
    }

    public boolean update(Object o) {
        boolean response = true;
        PreparedStatement ps;
        if (o instanceof Ciclista) {
            ps = updateCiclista((Ciclista) o);
        } else if(o instanceof Equipo){
            ps = updateEquipo((Equipo) o);
        } else {
            ps = null;
        }
        if (ps == null) {
            response = false;
        } else {
            try {
                ps.execute();
            } catch (SQLException ex) {
                response = false;
            }
        }
        return response;
    }

    public boolean delete(Object o) {
        boolean response = true;
        PreparedStatement ps;
        if (o instanceof Ciclista) {
            ps = deleteCiclista((Ciclista) o);
        } else if(o instanceof Equipo){
            ps = deleteEquipo((Equipo) o);
        } else {
            ps = null;
        }
        if (ps == null) {
            response = false;
        } else {
            try {
                ps.execute();
            } catch (SQLException ex) {
                System.out.println("Fallo en la eliminación");
                response = false;
            }
        }
        return response;
    }

    private PreparedStatement insertarCiclista(Ciclista c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("Insert into \"Ciclista\" values(?, ?, ?, ?)");
            ps.setInt(1, getIdNuevoCiclista());
            ps.setString(2, c.getNombre());
            ps.setInt(3, c.getNumDorsal());
            ps.setInt(4, c.getIdEquipo());
        } catch (SQLException ex) {
            System.out.println("Error al insertar el ciclista: " + c.toString());
            return null;
        }
        return ps;
    }

    private PreparedStatement updateCiclista(Ciclista c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("Update \"Ciclista\" set \"Nombre\" = ?, \"NumDorsal\" = ?, \"IdEquipo\" = ? where \"IdCiclista\" = ?");
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getNumDorsal());
            ps.setInt(3, c.getIdEquipo());
            ps.setInt(4, c.getIdCiclista());
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el ciclista con id: " + c.getIdCiclista());
            return null;
        }
        return ps;
    }

    private PreparedStatement deleteCiclista(Ciclista c) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("Delete from \"Ciclista\" where \"IdCiclista\" = ?");
            ps.setInt(1, c.getIdCiclista());
        } catch (SQLException ex) {
            System.out.println("Error al elimiar el ciclista con id: " + c.getIdCiclista());
            return null;
        }
        return ps;
    }

    private int getIdNuevoCiclista() {
        String query = "SELECT \"IdCiclista\" FROM \"Ciclista\" ORDER BY \"IdCiclista\" desc";
        int id = 0;
        try {
            ResultSet rs = con.createStatement().executeQuery(query);
            if (rs.next()) {
                id = rs.getInt("IdCiclista");
                id += 1;
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir el un nuevo id para el ciclista");
            return id;
        }
        return id;
    }

    public ArrayList<Ciclista> getCiclistas() {
        ArrayList<Ciclista> cs = new ArrayList();
        String query = "Select \"Ciclista\".*, \"Equipo\".\"Nombre\" from \"Ciclista\", \"Equipo\" where \"Equipo\".\"IdEquipo\" = \"Ciclista\".\"IdEquipo\"";
        ResultSet rs;
        try {
            rs = con.createStatement().executeQuery(query);
            while (rs.next()) {
                cs.add(new Ciclista(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir los ciclistas: " + ex.toString());
            return null;
        }
        return cs;
    }
    
    public ArrayList<Ciclista> getCiclistasEquipo(String nombreEquipo) {
        ArrayList<Ciclista> cs = new ArrayList();
        String query = "Select \"Ciclista\".*, \"Equipo\".\"Nombre\" from \"Ciclista\", \"Equipo\" where \"Equipo\".\"IdEquipo\" = \"Ciclista\".\"IdEquipo\" and \"Equipo\".\"Nombre\" = '"+nombreEquipo+"'";
        ResultSet rs;
        try {
            rs = con.createStatement().executeQuery(query);
            while (rs.next()) {
                cs.add(new Ciclista(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir los ciclistas: " + ex.toString());
            return null;
        }
        return cs;
    }

    public Ciclista getCiclista(int id) {
        String query = "Select \"Ciclista\".*, \"Equipo\".\"Nombre\" from \"Ciclista\", \"Equipo\" where \"Equipo\".\"IdEquipo\" = \"Ciclista\".\"IdEquipo\" and \"IdCiclista\" = " + id;
        Ciclista c = null;
        try {
            ResultSet rs = con.createStatement().executeQuery(query);
            while (rs.next()) {
                c = new Ciclista(id, rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el ciclista con id " + id + "; " + ex.toString());
            return null;
        }
        return c;
    }
    
    public Ciclista getCiclista(String nombre) {
        String query = "Select \"Ciclista\".*, \"Equipo\".\"Nombre\" from \"Ciclista\", \"Equipo\" where \"Equipo\".\"IdEquipo\" = \"Ciclista\".\"IdEquipo\" and \"Ciclista\".\"Nombre\" = \'" + nombre+"\'";
        Ciclista c = null;
        try {
            ResultSet rs = con.createStatement().executeQuery(query);
            while (rs.next()) {
                c = new Ciclista(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el ciclista con nombre " + nombre + "; " + ex.toString());
            return null;
        }
        return c;
    }

    private PreparedStatement insertarEquipo(Equipo e){
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("Insert into \"Equipo\" values(?, ?, ?)");
            ps.setInt(1, getIdNuevoEquipo());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getDirector());
        } catch (SQLException ex) {
            System.out.println("Error al insertar el ciclista: " + e.toString());
            return null;
        }
        return ps;
    }
    
    private PreparedStatement updateEquipo(Equipo e) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("Update \"Equipo\" set \"Nombre\" = ?, \"Director\" = ? where \"IdEquipo\" = ?");
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getDirector());
            ps.setInt(3, e.getIdEquipo());
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el ciclista con id: " + e.getIdEquipo());
            return null;
        }
        return ps;
    }

    private PreparedStatement deleteEquipo(Equipo e) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("Delete from \"Equipo\" where \"IdEquipo\" = ?");
            ps.setInt(1, e.getIdEquipo());
        } catch (SQLException ex) {
            System.out.println("Error al elimiar el ciclista con id: " + e.getIdEquipo());
            return null;
        }
        return ps;
    }
    
    public int getIdNuevoEquipo(){
        String query = "SELECT \"IdEquipo\" FROM \"Equipo\" ORDER BY \"IdEquipo\" desc";
        int id = 0;
        try {
            ResultSet rs = con.createStatement().executeQuery(query);
            if (rs.next()) {
                id = rs.getInt("IdEquipo");
                id += 1;
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir el un nuevo id para el equipo");
            return id;
        }
        return id;
    }
    
    public Equipo getEquipoCiclista(String nombre){
        PreparedStatement ps;
        ResultSet rs;
        Equipo e = null;
        try {
            ps = con.prepareStatement("Select * from \"Equipo\" where \"IdEquipo\" IN (Select \"IdEquipo\" from \"Ciclista\" where \"Nombre\" like ?)");
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                e = new Equipo(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir el equipo de un ciclista.");
            return null;
        }
        return e;
    }
    
    public ArrayList<Equipo> getEquipos(){
        ArrayList<Equipo> cs = new ArrayList();
        String query = "Select * from \"Equipo\"";
        ResultSet rs;
        try {
            rs = con.createStatement().executeQuery(query);
            while (rs.next()) {
                cs.add(new Equipo(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir los equipos: " + ex.toString());
            return null;
        }
        return cs;
    }
    
    public ArrayList<Puerto> getPuertos(){
        ArrayList<Puerto> ps = new ArrayList();
        String query = "SELECT \"Puerto\".*, \"Ciclista\".\"NumDorsal\", \"Categoria\".\"TipoCategoria\" FROM \"Puerto\", \"Ciclista\", \"Categoria\" WHERE \"Puerto\".\"IdCiclista\" = \"Ciclista\".\"IdCiclista\" AND \"Puerto\".\"IDCategoria\" = \"Categoria\".\"IDCategoria\"";
        ResultSet rs;
        try {
            rs = con.createStatement().executeQuery(query);
            while (rs.next()) {
                ps.add(new Puerto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(7), rs.getInt(5), rs.getString(8), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir los puertos: " + ex.toString());
            return null;
        }
        return ps;
    }
    
    public ArrayList<Puerto> getPuertosCategoria(int idCat){
        ArrayList<Puerto> ps = new ArrayList();
        PreparedStatement prs;
        ResultSet rs;
        try {
            prs = con.prepareStatement("SELECT \"Puerto\".*, \"Ciclista\".\"NumDorsal\", \"Categoria\".\"TipoCategoria\" FROM \"Puerto\", \"Ciclista\", \"Categoria\" WHERE \"Puerto\".\"IdCiclista\" = \"Ciclista\".\"IdCiclista\" AND \"Puerto\".\"IDCategoria\" = \"Categoria\".\"IDCategoria\" AND \"Puerto\".\"IDCategoria\" = ?");
            prs.setInt(1, idCat);
            rs = prs.executeQuery();
            while (rs.next()) {
                ps.add(new Puerto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(7), rs.getInt(5), rs.getString(8), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir los puertos con la categoría: " + ex.toString());
            return null;
        }
        return ps;
    }
    
    public ArrayList<Puerto> getPuertosPicos(){
        ArrayList<Puerto> ps = new ArrayList();
        PreparedStatement prs;
        ResultSet rs;
        try {
            prs = con.prepareStatement("SELECT \"Puerto\".*, \"Ciclista\".\"NumDorsal\", \"Categoria\".\"TipoCategoria\" FROM \"Puerto\", \"Ciclista\", \"Categoria\" WHERE \"Puerto\".\"IdCiclista\" = \"Ciclista\".\"IdCiclista\" AND \"Puerto\".\"IDCategoria\" = \"Categoria\".\"IDCategoria\" AND \"Puerto\".\"AltMax\" > (SELECT AVG(\"AltMax\") FROM \"Puerto\")");
            rs = prs.executeQuery();
            while (rs.next()) {
                ps.add(new Puerto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(7), rs.getInt(5), rs.getString(8), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir los puertos mas altos: " + ex.toString());
            return null;
        }
        return ps;
    }
    
    public ArrayList<Etapa> getEtapas(){
        ArrayList<Etapa> ps = new ArrayList();
        PreparedStatement prs;
        ResultSet rs;
        try {
            prs = con.prepareStatement("SELECT \"Etapa\".\"NumEtapa\", \"Etapa\".\"CiudadSalida\", \"Etapa\".\"CiudadEntrada\" FROM \"Etapa\"");
            rs = prs.executeQuery();
            while (rs.next()) {
                ps.add(new Etapa(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir los las etapas: "+ ex.toString());
            return null;
        }
        return ps;
    }
    
    public ArrayList<Maillot> getMaillot(){
        ArrayList<Maillot> ps = new ArrayList();
        PreparedStatement prs;
        ResultSet rs;
        try {
            prs = con.prepareStatement("SELECT \"Maillot\".\"Codigo\", \"Maillot\".\"Color\", \"Maillot\".\"TipoClasificacion\" FROM \"Maillot\"");
            rs = prs.executeQuery();
            while (rs.next()) {
                ps.add(new Maillot(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir los maillots: "+ ex.toString());
            return null;
        }
        return ps;
    }
    
    public ArrayList<CiclistaMaillotEtapa> getPorEtapa(int etapa){
        ArrayList<CiclistaMaillotEtapa> ps = new ArrayList();
        PreparedStatement prs;
        ResultSet rs;
        try {
            prs = con.prepareStatement("SELECT \"Ciclista\".\"Nombre\", \"Etapa\".\"NumEtapa\", \"Maillot\".\"Color\" FROM \"Ciclista\", \"Etapa\", \"Maillot\", \"CiclistaMaillotEtapa\" WHERE \"CiclistaMaillotEtapa\".\"IdCiclista\" = \"Ciclista\".\"IdCiclista\" AND \"CiclistaMaillotEtapa\".\"NumEtapa\" = \"Etapa\".\"NumEtapa\" AND \"CiclistaMaillotEtapa\".\"Codigo\" = \"Maillot\".\"Codigo\" AND \"CiclistaMaillotEtapa\".\"NumEtapa\" = ?");
            prs.setInt(1, etapa);
            rs = prs.executeQuery();
            while (rs.next()) {
                ps.add(new CiclistaMaillotEtapa(rs.getString(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir los puertos de la etapa: "+etapa+" -> "+ ex.toString());
            return null;
        }
        return ps;
    }
    
    public ArrayList<CiclistaMaillotEtapa> getPorMaillot(String maillot){
        ArrayList<CiclistaMaillotEtapa> ps = new ArrayList();
        PreparedStatement prs;
        ResultSet rs;
        try {
            prs = con.prepareStatement("SELECT \"Ciclista\".\"Nombre\", \"Etapa\".\"NumEtapa\", \"Maillot\".\"Color\" FROM \"Ciclista\", \"Etapa\", \"Maillot\", \"CiclistaMaillotEtapa\" WHERE \"CiclistaMaillotEtapa\".\"IdCiclista\" = \"Ciclista\".\"IdCiclista\" AND \"CiclistaMaillotEtapa\".\"NumEtapa\" = \"Etapa\".\"NumEtapa\" AND \"CiclistaMaillotEtapa\".\"Codigo\" = \"Maillot\".\"Codigo\" AND \"CiclistaMaillotEtapa\".\"Codigo\" = ?");
            prs.setString(1, maillot);
            rs = prs.executeQuery();
            while (rs.next()) {
                ps.add(new CiclistaMaillotEtapa(rs.getString(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir los puertos con el maillot: "+maillot+" -> "+ ex.toString());
            return null;
        }
        return ps;
    }
    
    public ArrayList<CiclistaMaillotEtapa> getPorCiclista(int ciclista){
        ArrayList<CiclistaMaillotEtapa> ps = new ArrayList();
        PreparedStatement prs;
        ResultSet rs;
        try {
            prs = con.prepareStatement("SELECT \"Ciclista\".\"Nombre\", \"Etapa\".\"NumEtapa\", \"Maillot\".\"Color\" FROM \"Ciclista\", \"Etapa\", \"Maillot\", \"CiclistaMaillotEtapa\" WHERE \"CiclistaMaillotEtapa\".\"IdCiclista\" = \"Ciclista\".\"IdCiclista\" AND \"CiclistaMaillotEtapa\".\"NumEtapa\" = \"Etapa\".\"NumEtapa\" AND \"CiclistaMaillotEtapa\".\"Codigo\" = \"Maillot\".\"Codigo\" AND \"CiclistaMaillotEtapa\".\"IdCiclista\" = ?");
            prs.setInt(1, ciclista);
            rs = prs.executeQuery();
            while (rs.next()) {
                ps.add(new CiclistaMaillotEtapa(rs.getString(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println("Error al pedir los puertos que ganó el ciclista: "+ciclista+" -> "+ ex.toString());
            return null;
        }
        return ps;
    }
}