import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InputException {

        try (Scanner input = new Scanner(System.in)) {

            System.out.println("Enter 1 for Arabic or 2 for English:");
            System.out.println("أدخل 1 للعربية أو 2 للإنجليزية:");

            String language = input.nextLine().trim();
            Language.setLang(language);

            System.out.println(MessagesLocalization.get("enter_sentence"));
            String text = input.nextLine().trim();

            TextToSpeech.speak(text, 0);

        } catch (InputException e) {
            System.err.println("❌ " + e.getMessage());
        }
    }
}
