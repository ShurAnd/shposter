package org.andrey.shposter;

import java.net.URISyntaxException;

public class ShposterApp {

    public static void main(String[] args){
        try {
            new ShposterHttpPoster().post("http://localhost:8080/test");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
