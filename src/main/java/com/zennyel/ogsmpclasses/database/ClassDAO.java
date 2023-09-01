package com.zennyel.ogsmpclasses.database;

import com.zennyel.ogsmpclasses.classes.Class;
import com.zennyel.ogsmpclasses.classes.ClassType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassDAO extends AbstractDatabase{
    public ClassDAO(JavaPlugin instance) {
        super(instance);
    }


    public void createClassTable(){
        String sql = "CREATE TABLE IF NOT EXISTS class(uuid VARCHAR(36), classType VARCHAR(12),level SHORT)";
        try(Connection connection = getConnetion(); PreparedStatement stm = connection.prepareStatement(sql)){
            stm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Class selectClass(Player player){
        String sql = "SELECT * FROM class WHERE uuid = ?";
        try(Connection connection = getConnetion(); PreparedStatement stm = connection.prepareStatement(sql); ResultSet rs = stm.executeQuery()){
            stm.setString(1, player.getUniqueId().toString());
            if(rs.next()){
                ClassType classType = ClassType.valueOf(rs.getString("classType"));
                int level = rs.getInt("level");
                return new Class(classType, level);
            }
            stm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void insertClass(Player player, Class aClass){
        String sql = "INSERT INTO class VALUES (?,?,?)";
        try(Connection connection = getConnetion(); PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setString(1, player.getUniqueId().toString());
            stm.setString(2, aClass.getClassType().toString());
            stm.setInt(3, aClass.getLevel());
            stm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteClass(Player player){
        String sql = "DELETE FROM class WHERE uuid = ?";
        try(Connection connection = getConnetion(); PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setString(1, player.getUniqueId().toString());
            stm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateClass(Player player, Class aClass){
        String sql = "UPDATE class SET classType = ?, level = ? WHERE uuid = ?";
        try(Connection connection = getConnetion(); PreparedStatement stm = connection.prepareStatement(sql)){
            stm.setString(1, aClass.getClassType().toString());
            stm.setInt(2, aClass.getLevel());
            stm.setString(3, player.getUniqueId().toString());
            stm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnetion(){
        return getConnection("class.db");
    }


}
