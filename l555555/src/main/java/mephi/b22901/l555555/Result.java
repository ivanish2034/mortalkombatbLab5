/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.l555555;
/**
 *
 * @author Мария
 */
public class Result {

    private String name;
    private int points;

    public Result(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }
}