/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.webapp.cine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import my.webapp.database.Database;
import java.sql.*;

/**
 *
 * @author Administrador
 */
public class cineDAO {

    public List<ClasePelicula> getall() {

        try {
            Database db = new Database();
            Connection conn = db.getConnection();

            PreparedStatement pstat = conn.prepareStatement("Select * FROM peliculas;");
            ResultSet rs = pstat.executeQuery();

            List<ClasePelicula> movieList = new ArrayList<>();

            while (rs.next()) {

                movieList.add(new ClasePelicula(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getInt("year"),
                        rs.getString("imageUrl")));

            }

            return movieList;

        } catch (SQLException ex) {

            System.getLogger(cineServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);

            return null;
        }

    }
    
    
    
    
    
    public ClasePelicula getallbyId(int id) {

        try {
            Database db = new Database();
            Connection conn = db.getConnection();

            PreparedStatement pstat = conn.prepareStatement("Select * FROM peliculas WHERE id= ?;");
             pstat.setInt (1, id);
            
            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {

                return new ClasePelicula(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getInt("year"),
                        rs.getString("imageUrl"));

            }

            return null;

        } catch (SQLException ex) {

            System.getLogger(cineServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);

            return null;
        }

    }
    
    
     public void update(ClasePelicula pelicula) {

        try {
            Database db = new Database();
            Connection conn = db.getConnection();

            PreparedStatement pstat = conn.prepareStatement("UPDATE peliculas SET title=?, director=?, year=?, imageUrl=? WHERE id = ?;");

            pstat.setString(1, pelicula.getTitle());
            pstat.setString(2, pelicula.getDirector());
            pstat.setInt(3, pelicula.getYear());
            pstat.setString(4, pelicula.getImageUrl());
            pstat.setInt(5, pelicula.getId());

            pstat.executeUpdate();

        } catch (SQLException ex) {

            System.getLogger(cineDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);

        }

    }
    
    
    
    
    
    
    
    
    
    

    public void save(ClasePelicula pelicula) {

        try {
            Database db = new Database();
            Connection conn = db.getConnection();

            PreparedStatement pstat = conn.prepareStatement("INSERT INTO peliculas (title, director, year, imageUrl)VALUES (?, ?, ?,?);");

            pstat.setString(1, pelicula.getTitle());
            pstat.setString(2, pelicula.getDirector());
            pstat.setInt(3, pelicula.getYear());
            pstat.setString(4, pelicula.getImageUrl());

            pstat.executeUpdate();

        } catch (SQLException ex) {

            System.getLogger(cineDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);

        }

    }

    public void delete(int id) {

        try {
            Database db = new Database();
            Connection conn = db.getConnection();
            PreparedStatement pstat = conn.prepareStatement("Delete from peliculas where id =?");

            pstat.setInt(1, id);

            pstat.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(cineDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
}
