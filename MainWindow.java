
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private final ArrayList<Character> characterList;

    public MainWindow(ArrayList<Character> characterList) {
        this.characterList = characterList;

        setTitle("Character Manager - TP8");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel("Daftar Karakter");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(15));

        // Menampilkan karakter secara dinamis menggunakan loop
        for (Character character : characterList) {
            JLabel characterLabel = new JLabel(
                character.getName()
                + " | Tipe: " + character.getType()
                + " | Level: " + character.getLevel()
                + " | HP: " + character.getHitPoints()
                + " | ATK: " + character.getAttackPower()
            );

            characterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(characterLabel);
            panel.add(Box.createVerticalStrut(8));
        }

        // Menghitung rata-rata level karakter
        double averageLevel = 0;

        if (!characterList.isEmpty()) {
            int totalLevel = 0;

            for (Character character : characterList) {
                totalLevel += character.getLevel();
            }

            averageLevel = (double) totalLevel / characterList.size();
        }

        panel.add(Box.createVerticalStrut(10));

        JLabel averageLabel = new JLabel(
            String.format("Rata-rata Level: %.2f", averageLevel)
        );

        averageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        averageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(averageLabel);

        add(panel);
        setVisible(true);
    }
}
