
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // Membuat pengelola karakter
        CharacterManager manager = new CharacterManager();

        // Menambahkan 5 karakter
        manager.addCharacter(
            new Character("Arjuna", CharacterType.WARRIOR, 5)
        );

        manager.addCharacter(
            new Character("Merlin", CharacterType.MAGE, 3)
        );

        manager.addCharacter(
            new Character("Athena", CharacterType.ARCHER, 4)
        );

        manager.addCharacter(
            new Character("Luna", CharacterType.HEALER, 6)
        );

        manager.addCharacter(
            new Character("Bima", CharacterType.WARRIOR, 8)
        );

        // Membuka GUI pada Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new MainWindow(manager.getAllCharacters());
        });
    }
}
