package ru.otus.dataprocessor;

import ru.otus.model.Measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProcessorAggregator implements ru.otus.dataprocessor.Processor {
    private ru.otus.dataprocessor.ResourcesFileLoader resourcesFileLoader;


    @Override
    public Map<String, Double> process(List<Measurement> data) {
        //группирует выходящий список по name, при этом суммирует поля value
        Map<String, Double> map = data.stream().collect(
                Collectors.toMap(Measurement::getName, Measurement::getValue, Double::sum));
        return map;
    }
}
