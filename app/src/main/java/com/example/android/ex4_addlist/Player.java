package com.example.android.ex4_addlist;

/**
 * Created by Krivnon on 2016-07-10.
 */
public class Player {
    private String strname;
    private String strteam;

    public void setName(String name) {
        strname = name ;
    }
    public void setTeam(String team) {
        strteam = team ;
    }
    public String getName() {
        return this.strname ;
    }
    public String getTeam() {
        return this.strteam ;
    }
}
