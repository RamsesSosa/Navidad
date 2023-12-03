/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.navidad.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itson.navidad.persistence.MySQLConnection;

/**
 *
 * @author PROPIETARIO
 */
public class Function {

    private String movie;
    private String hall;
    private String function;
    
    public static List<Function> getAll(String filtro) {
        List<Function> functions = new ArrayList();
        try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("SELECT pelicula_id, sala_id, horario_id FROM TheGalactics_funciones WHERE name LIKE ?");
            statement.setString(1, "%" + filtro + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Function fun = new Function();
                fun.setMovie(resultSet.getString(1));
                fun.setHall(resultSet.getString(2));
                fun.setFunction(resultSet.getString(3));
                functions.add(fun);

            }
        } catch (SQLException ex) {
            System.err.print("Error: " + ex.getMessage());
        }
        return functions;

    }
    

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
    
}
