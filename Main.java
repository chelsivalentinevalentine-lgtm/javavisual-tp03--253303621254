
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.3 - TP5 ===\n");

        CharacterManager manager = new CharacterManager();

        // ===== 1. MENAMBAHKAN KARAKTER =====
        System.out.println("--- Tambah Karakter ---");

        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
        manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 4));

        // ===== 2. MENGUJI NAMA DUPLIKAT =====
        System.out.println("\n--- Uji Duplikat ---");

        manager.addCharacter(new Character("Arjuna", CharacterType.HEALER, 1));

        // ===== 3. MENAMPILKAN TOTAL KARAKTER =====
        System.out.println("\nTotal karakter: "
                + manager.getTotalCharacters());

        // ===== 4. MENCARI KARAKTER =====
        System.out.println("\n--- Pencarian ---");

        Character hasil = manager.findByName("Merlin");

        if (hasil != null) {
            System.out.println("Karakter ditemukan: " + hasil);
        } else {
            System.out.println("Karakter tidak ditemukan.");
        }

        Character tidakAda = manager.findByName("Zeus");

        if (tidakAda == null) {
            System.out.println("Zeus tidak ditemukan (sesuai harapan).");
        }

        // ===== 5. MENGHAPUS KARAKTER =====
        System.out.println("\n--- Penghapusan ---");

        manager.removeCharacter("Athena");

        System.out.println("Total setelah hapus: "
                + manager.getTotalCharacters());

        // ===== 6. MENAMPILKAN KARAKTER TERSISA =====
        System.out.println("\n--- Daftar Karakter Tersisa ---");

        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // ===== 7. MINI-CHALLENGE: RATA-RATA LEVEL =====
        System.out.println("\n--- Analisis Rata-rata Level ---");

        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        // ===== 8. MINI-CHALLENGE: CARI BERDASARKAN TIPE =====
        System.out.println("\n--- Cari Berdasarkan Tipe ---");

        ArrayList<Character> warriors =
                manager.findByType(CharacterType.WARRIOR);

        System.out.println("Karakter bertipe WARRIOR:");

        for (Character c : warriors) {
            System.out.println(c);
        }

        // ===== 9. FITUR MANDIRI: KARAKTER TERKUAT =====
        System.out.println("\n--- Karakter Terkuat ---");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println("Karakter dengan attackPower tertinggi: "
                    + strongest.getName());

            System.out.println("Attack Power: "
                    + strongest.getAttackPower());
        } else {
            System.out.println("Belum ada karakter.");
        }

        // ===== 10. EKSPERIMEN OBJECT REFERENCE =====
        System.out.println("\n--- Eksperimen Object Reference ---");

        Character asli = manager.findByName("Arjuna");
        Character duplikatReferensi = asli;

        System.out.println("Level Arjuna sebelum: "
                + asli.getLevel());

        duplikatReferensi.setLevel(99);

        System.out.println("Level Arjuna sesudah lewat 'asli': "
                + asli.getLevel());

        System.out.println("asli == duplikatReferensi? "
                + (asli == duplikatReferensi));

        // ===== 11. EKSPERIMEN DEFENSIVE COPY =====
        System.out.println("\n--- Eksperimen Defensive Copy ---");

        ArrayList<Character> salinanList =
                manager.getAllCharacters();

        salinanList.add(new Character("Hantu", CharacterType.MAGE, 1));

        System.out.println("Total di manager asli: "
                + manager.getTotalCharacters());

        System.out.println("Total di salinan list: "
                + salinanList.size());
    }
}
