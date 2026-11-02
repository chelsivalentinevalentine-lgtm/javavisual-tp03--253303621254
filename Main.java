import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        // Membuat 3 karakter menggunakan constructor pertama
        Character arjuna = new Character("Arjuna", CharacterType.ARCHER, 5);
        Character merlin = new Character("Merlin", CharacterType.MAGE, 7);
        Character gatotkaca = new Character("Gatotkaca", CharacterType.WARRIOR, 10);

        // Menampilkan data karakter
        System.out.println("=== CHARACTER MANAGER ===");
        System.out.println(arjuna);
        System.out.println(merlin);
        System.out.println(gatotkaca);

        // Menguji fitur level up
        System.out.println("\n=== LEVEL UP ===");

        arjuna.setLevel(arjuna.getLevel() + 1);

        System.out.println("Arjuna naik level!");
        System.out.println(arjuna);

        // Menguji fitur mana dan isAlive()
        System.out.println("\n=== MINI CHALLENGE ===");

        Character healer = new Character("Luna", CharacterType.HEALER, 3);

        healer.setMana(50);

        System.out.println(healer);
        System.out.println("Apakah Luna masih hidup? " + healer.isAlive());
    }
}