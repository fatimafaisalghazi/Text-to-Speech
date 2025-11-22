import javazoom.jl.player.Player;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Base64;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class TextToSpeech {

    private static final String API_URL =
            "https://voice.reverso.net/RestPronunciation.svc/v1/output=json/GetVoiceStream/voiceName=%s?voiceSpeed=%s&inputText=%s";

    static final String ARABIC_VOICE = "Mehdi22k";
    private static URLConnection api = new URLConnection();

    private static String encodeToBase64(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
    }

    private static String buildUrl(String text, int speed) {
        speed = Math.max(-10, Math.min(10, speed));

        return String.format(API_URL, ARABIC_VOICE, speed, encodeToBase64(text));
    }


    public static InputStream getAudioStream(String text, int speed) throws IOException {
        String url = buildUrl(text, speed);
        HttpURLConnection conn = api.openAudioConnection(url);

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("فشل الاتصال: " + responseCode);
        }

        return conn.getInputStream();
    }

    public static void speak(String text, int speed) {
        try {
            System.out.println("🔊 =============== " + text);

            Player player = new Player( getAudioStream(text, speed));
            player.play();
            getAudioStream(text, speed).close();

            System.out.println("✓ انتهى التشغيل");
        } catch (Exception e) {
            System.err.println("خطأ في التشغيل: " + e.getMessage());
            e.printStackTrace();
        }
    }


//    public static void speakAsync(String text, int speed) {
//        new Thread(() -> speak(text, speed)).start();
//    }


//    public static void downloadAudio(String text, int speed, String outputPath)
//            throws IOException {
//
//        String url = buildUrl(text, speed);
//        System.out.println("الرابط: " + url);
//
//        HttpURLConnection conn = null;
//        try {
//            conn = api.openAudioConnection(url);
//            int responseCode = conn.getResponseCode();
//            System.out.println("Response Code: " + responseCode);
//
//            if (responseCode != 200) {
//                InputStream errorStream = conn.getErrorStream();
//                if (errorStream != null) {
//                    try (BufferedReader reader = new BufferedReader(
//                            new InputStreamReader(errorStream, StandardCharsets.UTF_8))) {
//                        String line;
//                        while ((line = reader.readLine()) != null) {
//                            System.err.println("Error response: " + line);
//                        }
//                    }
//                }
//                throw new IOException("فشل الاتصال: " + responseCode);
//            }
//
//            try (InputStream in = conn.getInputStream();
//                 FileOutputStream out = new FileOutputStream(outputPath)) {
//
//                byte[] buffer = new byte[4096];
//                int bytesRead;
//                int total = 0;
//                while ((bytesRead = in.read(buffer)) != -1) {
//                    out.write(buffer, 0, bytesRead);
//                    total += bytesRead;
//                }
//                System.out.println("✓ تم التحميل: " + total + " bytes");
//            }
//
//            System.out.println("✓ تم الحفظ في: " + outputPath);
//
//        } finally {
//            if (conn != null) conn.disconnect();
//        }
//    }

}
