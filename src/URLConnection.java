import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

class URLConnection {
    public static HttpURLConnection openAudioConnection(String url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(10000);


        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0 Safari/537.36");
        conn.setRequestProperty("Connection", "keep-alive");

        return conn;
    }
}
