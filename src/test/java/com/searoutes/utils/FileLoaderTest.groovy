package com.searoutes.utils


import com.searoutes.config.exceptions.PathNotFoundException
import com.searoutes.model.HistoricalRoute
import spock.lang.Specification

class FileLoaderTest extends Specification {

    def 'should load csv file'() {
        given:
        def filename = 'DEBRV_DEHAM_historical_routes.csv'
        def fileLoader = new FileLoader()

        when:
        def file = fileLoader.loadCsvFile(HistoricalRoute.class, filename)

        then:
        file.size() > 0
    }

    def 'should throw exception if filename is wrong'() {
        given:
        def filename = 'test.csv'
        def fileLoader = new FileLoader()

        when:
        fileLoader.loadCsvFile(HistoricalRoute.class, filename)

        then:
        thrown(PathNotFoundException)
    }

}
