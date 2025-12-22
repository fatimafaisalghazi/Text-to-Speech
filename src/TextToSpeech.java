import javazoom.jl.player.Player;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class TextToSpeech {

    private static final String API_URL =
            "https://voice.reverso.net/RestPronunciation.svc/v1/output=json/GetVoiceStream/voiceName=%s?voiceSpeed=%s&inputText=%s";

    private static String encodeToBase64(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
    }

    private static String buildUrl(String text, int speed) {
        speed = Math.max(-10, Math.min(10, speed));
        String voiceName = VoiceLanguage.getVoiceLang();
        return String.format(API_URL, voiceName, speed, encodeToBase64(text));
    }


    private static InputStream getAudioStream(String text, int speed) throws IOException, NetworkException {
        String url = buildUrl(text, speed);
        HttpURLConnection conn = URLConnection.openAudioConnection(url);

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new NetworkException("Response code: " + responseCode);
        }

        return conn.getInputStream();
    }

    public static void speak(String text, int speed) {
        if (text == null || text.trim().isEmpty()) {
            System.err.println(MessagesLocalization.get("empty_text"));
            return;
        }

        try (InputStream audioStream = getAudioStream(text, speed)) {
            System.out.println(MessagesLocalization.get("playing") + text);

            Player player = new Player(audioStream);
            player.play();

            System.out.println(MessagesLocalization.get("finished"));

        } catch (NetworkException e) {
            System.err.println("❌ " + e.getMessage());

        } catch (UnknownHostException e) {
            System.err.println("❌ " + MessagesLocalization.get("error_no_internet"));

        } catch (IOException e) {
            System.err.println("❌ " + MessagesLocalization.get("error_connection") + ": " + e.getMessage());

        } catch (Exception e) {
            System.err.println("❌ " + MessagesLocalization.get("error_playing") + e.getMessage());

        }
    }
}