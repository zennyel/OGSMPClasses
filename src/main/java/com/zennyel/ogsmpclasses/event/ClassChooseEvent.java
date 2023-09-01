package com.zennyel.ogsmpclasses.event;

import com.zennyel.ogsmpclasses.classes.Class;
import org.bukkit.entity.Player;

public class ClassChooseEvent extends AbstractEvent{


    private Player player;
    private Class aClass;

    public ClassChooseEvent(Player player, Class aClass) {
        this.player = player;
        this.aClass = aClass;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
