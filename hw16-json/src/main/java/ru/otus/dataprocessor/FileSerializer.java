package ru.otus.dataprocessor;


//import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class FileSerializer implements ru.otus.dataprocessor.Serializer {
    private String fileName;

    public FileSerializer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void serialize(Map<String, Double> data) {
        //формирует результирующий json и сохраняет его в файл
        var gson = new Gson();
        var newData = new TreeMap<>(data);
        String json = gson.toJson(newData);
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(json);
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
