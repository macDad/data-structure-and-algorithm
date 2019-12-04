package com.mac.dna;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class JSONApi {
    public static void main(String[] args) throws IOException {
        JSONObject json = readJsonFromUrl("http://registry.npmjs.org/forever/latest");
//        System.out.println(json.toString());
        System.out.println(getAllDependencies(json, "dependencies"));
//        System.out.println(json.get("cliff"));
    }

    private static String getAllDependencies(JSONObject json, String packName) {
        Set<String> dependencies = new HashSet<>();
        JSONObject object = (JSONObject) json.get(packName);
        getKeys(dependencies, object);
        return dependencies.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
    }

    private static void getKeys(Set<String> dependencies, JSONObject object) {
        Iterator<String> keys = object.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            if (object.get(key) instanceof JSONObject) {
                getKeys(dependencies, (JSONObject) object.get(key));
            } else {
                dependencies.add(key);
            }
        }
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException {
        InputStream stream = new URL(url).openStream();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, Charset.forName("UTF-8")));
            String jsonText = readAll(reader);
            JSONObject jsonObject = new JSONObject(jsonText);
            return jsonObject;
        } finally {
            stream.close();
        }
    }

    private static String readAll(BufferedReader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1) {
            builder.append((char) cp);
        }
        return builder.toString();
    }
}
