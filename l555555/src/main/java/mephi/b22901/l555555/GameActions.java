/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.l555555;

import java.util.ArrayList;
import mephi.b22901.l555555.actions.FightAction;
import mephi.b22901.l555555.fighters.Enemy;
import mephi.b22901.l555555.fighters.Player;
/**
 *
 * @author Мария
 */
public class GameActions {

    private final int experience_for_next_level[] = {40, 90, 180, 260, 410, 1000};

    public FightAction chooseEnemyAction(Enemy enemy, ArrayList<FightAction> list) {
        switch (enemy.getName()) {
            case "Sub-Zero" -> {
                return list.get((int) (Math.random() * 3));
            }
            case "Boss" -> {
                list.remove(2);
                return list.get((int) (Math.random() * 3));
            }
            default -> {
                return list.get((int) (Math.random() * 2));
            }
        }
    }

    public void addPoints(Player player) {
        player.setExperience(20+5*player.getLevel());
        int points = 20 + 5 * player.getLevel() + player.getHealth() / 4;
        player.setPoints(player.getPoints() + points);
    }

    public boolean checkExperience(Player player) {
        return player.getExperience() >= player.getNextLevelExperience();
    }

    public void levelUp(Player player, Enemy[] enemies) {
        player.setLevel(player.getLevel() + 1);
        int i = 0;
        while (player.getNextLevelExperience() >= experience_for_next_level[i]) {
            i = i + 1;
        }
        player.setNextLevelExperience(experience_for_next_level[i]);
        for (int j = 0; j < 5; j++) {
            newHealthEnemy(enemies[j], player);
        }
    }

    public void addPointsBoss(Player player) {
        player.setExperience(50);
        player.setPoints(player.getPoints() + 65 + player.getHealth() / 2);
    }

    public void addItems(int k1, int k2, int k3, Item[] items) {
        double i = Math.random();
        if (i < k1 * 0.01) {
            items[0].setCount(1);
        }
        else if (i >= k1 * 0.01 & i < (k1 + k2) * 0.01) {
            items[1].setCount(1);
        }
        else if (i >= (k1 + k2) * 0.01 & i < (k1 + k2 + k3) * 0.01) {
            items[2].setCount(1);
        }
    }

    public void addHealthPlayer(Player player) {
        player.setMaxHealth(20+5*player.getLevel() + player.getMaxHealth());
    }

    public void addDamagePlayer(Player player) {
        player.setDamage(2+player.getLevel() + player.getDamage());
    }

    public void newHealthEnemy(Enemy enemy, Player player) {
        enemy.setMaxHealth((int) enemy.getMaxHealth() * (35-3*player.getLevel()) / 100 + enemy.getMaxHealth());
        enemy.setDamage((int) enemy.getDamage() *(20+player.getLevel()) / 100 + enemy.getDamage());
        enemy.setLevel(enemy.getLevel() + 1);
    }

    public void useItem(Player player, Item[] items, String name, Mediator mediator) {
        boolean a = false;
        switch (name) {
            case "First item" -> {
                if (items[0].getCount() > 0) {
                    player.setHealth((int) (player.getMaxHealth() * 0.25) + player.getHealth());
                    items[0].setCount(-1);
                } else {
                    a = true;
                    mediator.openCantUseItemDialog();
                }
            }
            case "Second item" -> {
                if (items[1].getCount() > 0) {
                    player.setHealth((int) (player.getMaxHealth() * 0.5) + player.getHealth());
                    items[1].setCount(-1);
                } else {
                    a = true;
                    mediator.openCantUseItemDialog();
                }
            }
            case "Third item" -> {
                a = true;
                mediator.openCantUseItemDialog();
            }
        }
    }
    
    public boolean buyItem(Player player, int itemIndex, int cost) {
        if (player.getPoints() >= cost) {
            player.getItems()[itemIndex].setCount(1);
            player.setPoints(player.getPoints() - cost);
            return true; 
        }
        return false; 
    }

    
    public void resetEnemies(Enemy[] enemiesList) {
        for (Enemy enemy : enemiesList) {
            enemy.setLevel(1);
            switch (enemy.getName()) {
                case "Sub-Zero" -> {
                    enemy.setLevel(1);
                    enemy.setDamage(16);
                    enemy.setMaxHealth(65);
                }
                case "Sonya Blade" -> {
                    enemy.setLevel(1);
                    enemy.setDamage(14);
                    enemy.setMaxHealth(55);
                }
                case "Boss" -> {
                    enemy.setLevel(1);
                    enemy.setDamage(30);
                    enemy.setMaxHealth(100);
                }
                case "Liu Kang" -> {
                    enemy.setLevel(1);
                    enemy.setDamage(20);
                    enemy.setMaxHealth(70);
                }
                case "Baraka" -> {
                    enemy.setLevel(1);
                    enemy.setDamage(12);
                    enemy.setMaxHealth(75);
                }
            }
        }
    }
}