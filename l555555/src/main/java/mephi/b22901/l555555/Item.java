/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.l555555;

/**
 *
 * @author ivis2
 */
public class Item {

    private String name;
    private int count;

    public Item(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setCount(int count) {
        this.count += count;
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }
}
