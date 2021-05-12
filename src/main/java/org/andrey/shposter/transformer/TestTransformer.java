package org.andrey.shposter.transformer;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class TestTransformer implements Transformer{
    @Override
    public String transform(String path, int i) {
            String jsonForSending = "";
        try {
            File file = new File(getClass().getClassLoader().getResource(path).toURI());
            jsonForSending = Files.lines(file.toPath()).collect(Collectors.joining("\n"));
            jsonForSending = jsonForSending.replaceAll("<testObject>", "\"testObject"+i+"\"");
            jsonForSending = jsonForSending.replaceAll("<price>", ""+i+".0");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return jsonForSending;
    }
}
