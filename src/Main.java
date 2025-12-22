import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            int speed = 0;
            int controlSpeed;

            System.out.println("\n Enter 1 for Arabic or 2 for English: ");
            System.out.println(" \nأدخل 1  للعربية أو 2 للإنجليزية:");

            String language = input.nextLine().trim();
            VoiceLanguage.setLang(language);

            System.out.println(MessagesLocalization.get("enter_sentence"));
            String text = input.nextLine().trim();

            System.out.println(MessagesLocalization.get("control_speed"));

            controlSpeed = input.nextInt();

            if (controlSpeed == 0) {
                System.out.println(MessagesLocalization.get("speed"));
                speed = input.nextInt();
            }

            TextToSpeech.speak(text, speed);

        } catch (InputException e) {
            System.err.println("❌ " + e.getMessage());
        }
    }
}
