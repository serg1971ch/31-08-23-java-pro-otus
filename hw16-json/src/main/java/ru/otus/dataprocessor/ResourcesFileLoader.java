package ru.otus.dataprocessor;

//import jakarta.json.Json;
//import jakarta.json.JsonStructure;
import ru.otus.model.Measurement;
import ru.otus.dataprocessor.Loader;
import java.util.List;

import java.util.stream.Collectors;

public class ResourcesFileLoader implements Loader {
    private final String fileName;

    public ResourcesFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Measurement> load(){
        //читает файл, парсит и возвращает результат
        List<Measurement> measurementList;
        try (var jsonReader = Json.createReader(ResourcesFileLoader.class.getClassLoader().getResourceAsStream(fileName))) {
            JsonStructure jsonStructure = jsonReader.read();
            measurementList = jsonStructure.asJsonArray().getValuesAs(JsonStructure::asJsonObject)
                    .stream()
                    .map(jsonObject ->
                            new Measurement(
                                    jsonObject.get("name").toString().replace("\"", ""),
                                    Double.parseDouble(jsonObject.get("value").toString())
                            ))
                    .collect(Collectors.toList());
        }
        return measurementList;
    }
}

