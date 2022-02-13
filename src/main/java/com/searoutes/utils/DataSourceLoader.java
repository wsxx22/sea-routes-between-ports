package com.searoutes.utils;

import com.searoutes.config.YamlProperties;
import com.searoutes.model.HistoricalRoute;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSourceLoader {

    private final FileLoader fileLoader;
    private final YamlProperties yamlProperties;

    public List<HistoricalRoute> getHistoricalRoutes() {
        return fileLoader.loadCsvFile(HistoricalRoute.class, yamlProperties.getHistoricalRoutesFileName());
    }
}
