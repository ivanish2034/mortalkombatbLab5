/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.l555555;

import java.io.File;
import mephi.b22901.l555555.fighters.Enemy;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author ivis2
 */



public class Location {
    public int currentLocation = 1;
    public int currentEnemyNumber = 0;
    ArrayList<Enemy> currentEnemiesList = new ArrayList<>();
    Enemy[] fullEnemiesList = null;
    public int locationSize;

    public void setFullEnemiesList(Enemy[] list) {
        fullEnemiesList = list;
    }

    public ArrayList<Enemy> getEnemiesAtLocation() {
        return currentEnemiesList;
    }
//    private void setEnemyIcon(Enemy enemy, String imageName) {
//    try {
//        File imageFile = new File(imageName);
//        if (imageFile.exists()) {
//            enemy.setIcon(new ImageIcon(imageFile.getAbsolutePath()));
//        } else {
//            System.err.println("Image not found: " + imageFile.getAbsolutePath());
//        }
//    } catch (Exception e) {
//        System.err.println("Error loading image: " + imageName);
//        e.printStackTrace();
//    }
//}
    private void setEnemyIcon(Enemy enemy, String imageName) {
    String imagePath = AppPathHelper.getPathForResource(imageName);
    File imageFile = new File(imagePath);
    
    if (imageFile.exists()) {
        enemy.setIcon(new ImageIcon(imageFile.getAbsolutePath()));
    } else {
        System.err.println("Не найден файл врага: " + imageFile.getAbsolutePath());
    }
}
//     public void setEnemiesAtLocation(int i) {
//        currentEnemiesList = new ArrayList<>();
//        Enemy enemy = null;
//        locationSize = 1 + (int) (Math.random() * i);
//        for (int j = 0; j < locationSize; j++) {
//            int k = (int) (Math.random() * 4);
//            switch (k) {
//                case 0 -> {
//                    enemy = fullEnemiesList[0];
////                    enemy.setIconFromResources("/images/result_Baraka.jpg");
//                    enemy.setIcon("result_Baraka.jpg"); 
//                }
//                case 1 -> {
//                    enemy = fullEnemiesList[1];
////                    enemy.setIconFromResources("/images/result_SubZero.jpg");
//                    enemy.setIcon("result_SubZero.jpg"); 
//                }
//                case 2 -> {
//                    enemy = fullEnemiesList[2];
////                    enemy.setIconFromResources("/images/result_liu.png");
//                    enemy.setIcon("result_liu.jpg"); 
//                }
//                case 3 -> {
//                    enemy = fullEnemiesList[3];
////                    enemy.setIconFromResources("/images/result_Sonia.png");
//enemy.setIcon("result_Sonia.jpg"); 
//                }
//            }
//            currentEnemiesList.add(enemy);
//        }
//    }
    public void setEnemiesAtLocation(int i) {
    currentEnemiesList = new ArrayList<>();
    Enemy enemy = null;
    locationSize = 1 + (int) (Math.random() * i);
    
    for (int j = 0; j < locationSize; j++) {
        int k = (int) (Math.random() * 4);
        switch (k) {
            case 0 -> {
                enemy = fullEnemiesList[0];
                setEnemyIcon(enemy, "result_Baraka.jpg");
            }
            case 1 -> {
                enemy = fullEnemiesList[1];
                setEnemyIcon(enemy, "result_SubZero.jpg");
            }
            case 2 -> {
                enemy = fullEnemiesList[2];
                setEnemyIcon(enemy, "result_liu.png");
            }
            case 3 -> {
                enemy = fullEnemiesList[3];
                setEnemyIcon(enemy, "result_Sonia.png");
            }
        }
        currentEnemiesList.add(enemy);
    }
}

    public void resetLocation(boolean toNextLocation, int locationNumber) {
        if (toNextLocation) {
            currentLocation += 1;
        } else {
            currentLocation = locationNumber; 
        }   
        currentEnemyNumber = 0;
        setEnemiesAtLocation(locationNumber); 
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public int getCurrentEnemyNumber() {
        return currentEnemyNumber;
    }
    
//    public Enemy getCurrentEnemy() {
//        Enemy enemy = null;
//        if (currentEnemyNumber != locationSize) {
//            currentEnemyNumber += 1;
//            return currentEnemiesList.get(currentEnemyNumber - 1);
//        } else {
//            currentEnemyNumber = 0;
//            enemy = fullEnemiesList[4];
////            enemy.setIconFromResources("/images/result_Boss.jpg");
//            enemy.setIcon("result_Boss.jpg"); 
//            return enemy;
//        }
//    }
    public Enemy getCurrentEnemy() {
    Enemy enemy = null;
    if (currentEnemyNumber != locationSize) {
        currentEnemyNumber += 1;
        return currentEnemiesList.get(currentEnemyNumber - 1);
    } else {
        currentEnemyNumber = 0;
        enemy = fullEnemiesList[4];
        setEnemyIcon(enemy, "result_Boss.jpg");
        return enemy;
    }
}
}