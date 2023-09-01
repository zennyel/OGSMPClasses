package com.zennyel.ogsmpclasses.classes;

import com.zennyel.ogsmpclasses.classes.ability.Ability;
import com.zennyel.ogsmpclasses.classes.effect.Effect;

public class Class {
    private ClassType classType;
    private int level;

    public Class(ClassType classType, int level) {
        this.classType = classType;
        this.level = level;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
