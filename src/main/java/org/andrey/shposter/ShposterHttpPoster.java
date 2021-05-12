package org.andrey.shposter;

import org.andrey.shposter.transformer.TestTransformer;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ShposterHttpPoster {

    public void post(String URI) throws URISyntaxException {
        TestTransformer testTransformer = new TestTransformer();
        HttpClient httpClient = HttpClient.newHttpClient();
        for (int i = 0; i < 1000; i++){
            String jsonForSending = "";
            jsonForSending = testTransformer.transform("testFile.json", i);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                        .uri(new URI(URI))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(jsonForSending))
                        .build();
            try {
                httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
