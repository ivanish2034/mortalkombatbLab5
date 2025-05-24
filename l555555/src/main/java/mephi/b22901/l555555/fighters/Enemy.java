/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.l555555.fighters;

/**
 *
 * @author ivis2
 */
public class Enemy extends Fighter{

    private String name;

    public Enemy(String name, int level, int maxhealth, int damage) {
        super(level, maxhealth, damage);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
