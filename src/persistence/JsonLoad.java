package persistence;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonLoad {

    private final static String URL_PATTERN = "https://cdn.jsdelivr.net/gh/"
            + "fawazahmed0/currency-api@1/latest/currencies/%s/%s.json";

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }

        return sb.toString();
    }


    public static float readJsonFromUrl(String from, String to) {
       
        String url = String.format(URL_PATTERN, from.toLowerCase(), 
                to.toLowerCase());
        
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, 
                    Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json.getFloat(to.toLowerCase());
        } catch (Exception ex) {
            throw new IllegalStateException("", ex);
        }
    }
}