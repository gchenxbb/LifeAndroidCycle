package com.lifecycle.ponent.fragment;

public class BottomBarEntity {

    public BottomBarEntity(int index, int iconNormal, int iconSelcet, String title) {
        this.iconNormal = iconNormal;
        this.iconSelcet = iconSelcet;
        this.title = title;
        this.index = index;
    }

    public int iconNormal;
    public int iconSelcet;
    public String title;
    public int index;
}
