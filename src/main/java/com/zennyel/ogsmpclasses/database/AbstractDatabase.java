package com.zennyel.ogsmpclasses.database;


import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDatabase {

    private Connection connection;
    private JavaPlugin instance;
    private MySQL mySQL;


    public AbstractDatabase(JavaPlugin instance) {
        this.instance = instance;
        this.mySQL = new MySQL(instance.getConfig());
    }

    public Connection getConnection(String file){
        File dataFolder = new File(instance.getDataFolder(), "/database");

        if(!dataFolder.exists()){
            dataFolder.mkdir();
        }
        File dbFile = new File(dataFolder, file);

        if(!dbFile.exists()){
            try {
                dbFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        if(mySQL.getFileConfiguration().getBoolean("Database.use-mysql")){
            try {
                mySQL.connect();
                return mySQL.getConnection();
            }catch (SQLException | ClassNotFoundException ignore){
            }
        }

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
