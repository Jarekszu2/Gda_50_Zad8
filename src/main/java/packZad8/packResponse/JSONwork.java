package packZad8.packResponse;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class JSONwork {
    private static final Gson GSON = new Gson();

    public List<DaneApi> loadDataByStream(String sourceUrl) {
        List<DaneApi> apiResponse = null;

        try {
            URL url = new URL(sourceUrl);
            InputStream inputStream = url.openStream();
            apiResponse = GSON.fromJson(new InputStreamReader(inputStream), List.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return apiResponse;
    }

    public List<DaneApi> loadURLbyString(String requestURL) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            URL url = new URL(requestURL);
            InputStream inputStream = url.openStream();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                bufferedReader.lines().forEach(stringBuilder::append);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<DaneApi> nbPresponse = GSON.fromJson(stringBuilder.toString(), List.class);
        return nbPresponse;
    }

}
