/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.l555555.actions;

import mephi.b22901.l555555.fighters.Fighter;

/**
 *
 * @author ivis2
 */
public class Hit extends FightAction {

    @Override
    public String getType() {
        return "Hit";
    }

    @Override
    public void realisation(Fighter fighter1, Fighter fighter2, String fighter2ActionType) {
        switch (fighter2ActionType) {
            case "Hit" -> {
                if (fighter2.isDebuffed() & fighter1.isDebuffed()) {
                    fighter2.setHealth((int) (-fighter1.getDamage() * 1.25 / 2) + fighter2.getHealth());
                }
                if (fighter2.isDebuffed() & !fighter1.isDebuffed()) {
                    fighter2.setHealth((int) (-fighter1.getDamage() * 1.25) + fighter2.getHealth());
                }
                if (!fighter2.isDebuffed() & fighter1.isDebuffed()) {
                    fighter2.setHealth((int) (-fighter1.getDamage() / 2) + fighter2.getHealth());
                }
                if (!fighter2.isDebuffed() & !fighter1.isDebuffed()) {
                    fighter2.setHealth((int) (-fighter1.getDamage()) + fighter2.getHealth());
                }
            }
            case "Block" -> {
                fighter1.setHealth(-fighter2.getDamage() / 2 + fighter1.getHealth());
            }
            case "Debuff" -> {
                fighter2.setHealth((int) (-fighter1.getDamage() * 1.15) + fighter2.getHealth());
            }
            case "Heal" -> {
                fighter2.setHealth(-fighter1.getDamage() * 2 + fighter2.getHealth());
            }
        }
    }
}
