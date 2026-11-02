
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characterList;

    // Constructor
    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    /**
     * Menambahkan karakter baru.
     * Menolak karakter dengan nama yang sudah terdaftar.
     *
     * @param character karakter yang akan ditambahkan
     * @return true jika berhasil, false jika gagal
     */
    public boolean addCharacter(Character character) {
        if (character == null) {
            System.out.println("Gagal: karakter tidak boleh null.");
            return false;
        }

        if (findByName(character.getName()) != null) {
            System.out.println("Gagal: karakter dengan nama '"
                    + character.getName() + "' sudah ada!");
            return false;
        }

        characterList.add(character);

        System.out.println("Karakter '" + character.getName()
                + "' berhasil ditambahkan.");

        return true;
    }

    /**
     * Mencari karakter berdasarkan nama.
     *
     * @param name nama karakter yang dicari
     * @return karakter jika ditemukan, atau null jika tidak ditemukan
     */
    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character c : characterList) {
            if (c.getName().equals(name)) {
                return c;
            }
        }

        return null;
    }

    /**
     * Menghapus karakter berdasarkan nama.
     *
     * @param name nama karakter yang akan dihapus
     * @return true jika berhasil dihapus, false jika tidak ditemukan
     */
    public boolean removeCharacter(String name) {
        Character target = findByName(name);

        if (target == null) {
            System.out.println("Gagal hapus: karakter '"
                    + name + "' tidak ditemukan.");
            return false;
        }

        characterList.remove(target);

        System.out.println("Karakter '" + name
                + "' berhasil dihapus.");

        return true;
    }

    /**
     * Mengembalikan jumlah karakter dalam manager.
     *
     * @return jumlah karakter
     */
    public int getTotalCharacters() {
        return characterList.size();
    }

    /**
     * Mengembalikan salinan daftar karakter.
     * Daftar internal tidak diekspos secara langsung.
     *
     * @return salinan ArrayList berisi karakter
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    /**
     * Menghitung rata-rata level seluruh karakter.
     *
     * @return rata-rata level, atau 0 jika daftar kosong
     */
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0;
        }

        int totalLevel = 0;

        for (Character c : characterList) {
            totalLevel += c.getLevel();
        }

        return (double) totalLevel / characterList.size();
    }

    /**
     * Mencari semua karakter berdasarkan tipe.
     *
     * @param type tipe karakter yang dicari
     * @return ArrayList baru berisi karakter dengan tipe tersebut
     */
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character c : characterList) {
            if (c.getType() == type) {
                result.add(c);
            }
        }

        return result;
    }

    /**
     * Fitur analitik mandiri:
     * mencari karakter dengan attackPower paling tinggi.
     *
     * @return karakter terkuat, atau null jika daftar kosong
     */
    public Character findStrongest() {
        if (characterList.isEmpty()) {
            return null;
        }

        Character strongest = characterList.get(0);

        for (Character c : characterList) {
            if (c.getAttackPower() > strongest.getAttackPower()) {
                strongest = c;
            }
        }

        return strongest;
    }
}
