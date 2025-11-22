import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static final String outPutBath ="output_arabic.mp3";
    public static void main(String[] args) {
        System.out.println("enter a sentence");
        Scanner input = new Scanner(System.in);
        String text = input.next();
        TextToSpeech.speak(text, 0);
//            TextToSpeech.downloadAudio(text, 0, outPutBath);

    }
}

