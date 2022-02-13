package com.searoutes.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import com.searoutes.config.exceptions.FileNotFoundException;
import com.searoutes.config.exceptions.PathNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class FileLoader {

    public <T> List<T> loadCsvFile(Class<T> responseType, String fileName) {
        String path = getPath(fileName);

        try {
            return new CsvToBeanBuilder(new java.io.FileReader(path))
                    .withType(responseType)
                    .withSkipLines(1)
                    .withIgnoreEmptyLine(true)
                    .build()
                    .parse();
        } catch (java.io.FileNotFoundException exception) {
            log.debug(exception.getMessage());
            throw new FileNotFoundException();
        }
    }

    private String getPath(String fileName) {
        try {
            return getClass().getClassLoader().getResource(fileName).getPath();
        } catch (NullPointerException exception) {
            log.debug(exception.getMessage());
            throw new PathNotFoundException();
        }
    }

}
