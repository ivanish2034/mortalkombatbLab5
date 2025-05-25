/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.l555555.fighters;

import javax.swing.ImageIcon;

/**
 *
 * @author ivis2
 */
public abstract class Fighter {
    
    private int level;
    private int health;
    private int maxHealth;
    private int damage;
    private ImageIcon icon;
    private int movesWithDebuff;
    
    public Fighter(int level, int maxhealth, int damage) {
        this.level = level;
        this.health = maxhealth;
        this.maxHealth = maxhealth;
        this.damage = damage;
        movesWithDebuff = 0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(String path) {
        icon = new ImageIcon(path);
    }
    
    public void setIcon(ImageIcon icon) {
        // Новый метод для установки готового ImageIcon
        this.icon = icon;
    }
    
    public void setIconFromResources(String resourcePath) {
        // Метод для загрузки иконки из ресурсов
        try {
            java.net.URL imageUrl = getClass().getResource(resourcePath);
            if (imageUrl != null) {
                icon = new ImageIcon(imageUrl);
            } else {
                System.err.println("Image not found in resources: " + resourcePath);
                icon = null; // или установите иконку по умолчанию
            }
        } catch (Exception e) {
            System.err.println("Error loading image from resources: " + resourcePath);
            e.printStackTrace();
            icon = null;
        }
    }

    public int getMovesWithDebuff() {
        return movesWithDebuff;
    }

    public void setMovesWithDebuff(int movesWithDebuff) {
        this.movesWithDebuff = movesWithDebuff;
    }
    
    public boolean isDebuffed() {
        return movesWithDebuff > 0;
    }
    
    public void loseDebuffTurn() {
        if (movesWithDebuff > 0) {
            movesWithDebuff--;
        }
    }

    public abstract String getName();
}

