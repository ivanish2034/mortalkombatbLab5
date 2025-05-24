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
public class Debuff extends FightAction {

    @Override
    public String getType() {
        return "Debuff";
    }

    @Override
    public void realisation(Fighter fighter1, Fighter fighter2, String fighter2ActionType) {
        switch (fighter2ActionType) {
            case "Hit" -> {
            }
            case "Block" -> {
                if (Math.random()<0.75){
                    fighter2.setMovesWithDebuff(fighter1.getLevel());
                }
            }
            case "Debuff" -> {
            }
            case "Heal" -> {
            }
        }
    }
}

