/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.l555555;

import mephi.b22901.l555555.fighters.Enemy;
import mephi.b22901.l555555.fighters.Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Мария
 */

public class Game {

    public GameActions action = new GameActions();
    public Fight fight = new Fight();
    private final ArrayList<Result> results =  new ArrayList<>();
    private final Enemy enemies[] = new Enemy[5];

    public void setEnemies() {
        enemies[0] = new Enemy("Baraka", 1, 100, 12);
        enemies[1] = new Enemy("Sub-Zero", 1, 60, 16);
        enemies[2] = new Enemy("Liu Kang", 1, 70, 20);
        enemies[3] = new Enemy("Sonya Blade", 1, 80, 16);
        enemies[4] = new Enemy("Boss", 3, 100, 30);
    }

    public Enemy[] getEnemies() {
        return this.enemies;
    }

    public Player newPlayer(Mediator mediator, Item[] items) {
        Player player = new Player(0, 80, 16);
        mediator.setHealthBar(player);
        mediator.setPlayerMaxHealthBar(player);
        player.setItems(items);
        return player;
    }

    public void endGameTop(Player player, JTextField text, JTable table) throws IOException {
        results.add(new Result(text.getText(), player.getPoints()));
        results.sort(Comparator.comparing(Result::getPoints).reversed());
        writeToTable(table);
        writeToExcel();
    }

    public void writeToExcel() throws IOException {
        try (XSSFWorkbook book = new XSSFWorkbook()) {
            XSSFSheet sheet = book.createSheet("Результаты ТОП 10");
            XSSFRow r = sheet.createRow(0);
            r.createCell(0).setCellValue("№");
            r.createCell(1).setCellValue("Имя");
            r.createCell(2).setCellValue("Количество баллов");
            for (int i = 0; i < results.size(); i++) {
                if (i < 10) {
                    XSSFRow r2 = sheet.createRow(i + 1);
                    r2.createCell(0).setCellValue(i + 1);
                    r2.createCell(1).setCellValue(results.get(i).getName());
                    r2.createCell(2).setCellValue(results.get(i).getPoints());
                }
            }
            File f = new File("Results.xlsx");
            book.write(new FileOutputStream(f));
        }
    }

    public ArrayList<Result> getResults() {
        return this.results;
    }
    
    public void readFromExcel() throws IOException {
        File file = new File("Results.xlsx");

        if (!file.exists()) {
            try (XSSFWorkbook book = new XSSFWorkbook()) {
                XSSFSheet sheet = book.createSheet("Результаты ТОП 10");
                XSSFRow header = sheet.createRow(0);
                header.createCell(0).setCellValue("№");
                header.createCell(1).setCellValue("Имя");
                header.createCell(2).setCellValue("Количество баллов");

                try (FileOutputStream out = new FileOutputStream(file)) {
                    book.write(out);
                }
            }
            return;
        }

        try (XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(file))) {
            XSSFSheet sh = book.getSheetAt(0);
            for (int i = 1; i <= sh.getLastRowNum(); i++) {
                XSSFRow row = sh.getRow(i);
                if (row != null && row.getCell(1) != null && row.getCell(2) != null) {
                    String name = row.getCell(1).getStringCellValue();
                    int points = (int) row.getCell(2).getNumericCellValue();
                    results.add(new Result(name, points));
                }
            }
        }
    }

    public void writeToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < results.size(); i++) {
            if (i < 10) {
                model.setValueAt(results.get(i).getName(), i, 0);
                model.setValueAt(results.get(i).getPoints(), i, 1);
            }
        }
    }
}