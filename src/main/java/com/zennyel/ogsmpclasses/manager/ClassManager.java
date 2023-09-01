package com.zennyel.ogsmpclasses.manager;

import com.zennyel.ogsmpclasses.OGSMPClasses;
import com.zennyel.ogsmpclasses.classes.Class;
import com.zennyel.ogsmpclasses.database.ClassDAO;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ClassManager {

    private ClassDAO classDAO;
    private HashMap<Player, Class> playerCache;

    public ClassManager(OGSMPClasses ogsmpClasses) {
        this.classDAO = new ClassDAO(ogsmpClasses);
        this.playerCache = new HashMap<>();
    }

    public void load(Player player) {
        ThreadManager.runAsync(()->{
            if(classDAO.selectClass(player) == null){
                return;
            }
            playerCache.put(player, classDAO.selectClass(player));
        });
    }

    public void save(Player player) {
        ThreadManager.runAsync(()->{
            if(!playerCache.containsKey(player)){
                return;
            }
            if(classDAO.selectClass(player) == null){
                classDAO.insertClass(player, playerCache.get(player));
            }else update(player);
        });
    }

    private void update(Player player) {
            if(!playerCache.containsKey(player)){
                return;
            }
            if(classDAO.selectClass(player) != null){
                classDAO.updateClass(player, playerCache.get(player));
            }
    }

    public void delete(Player player) {
        ThreadManager.runAsync(()->{
            if(!playerCache.containsKey(player)){
                return;
            }
            playerCache.put(player, null);
            if(classDAO.selectClass(player) == null){
                return;
            }
            classDAO.deleteClass(player);


        });
    }
}
