package com.searoutes.services

import com.searoutes.model.HistoricalRoute
import com.searoutes.utils.DataSourceLoader
import spock.lang.Specification

class SearchTypeServiceTest extends Specification {

    def 'should return correct historical route by param'() {
        given:
        def dataOfVesselObservationFirst = '[[8.489074, 53.615707, 1509423228430, 14.0], [8.476499, 53.621193, 1509423365984, 14.8], [8.463407, 53.626442, 1509423498599, 33.8]]'
        def dataOfVesselObservationSecond = '[[8.489074, 53.615707, 1509423228430, 55.0], [8.476499, 53.621193, 1509423365984, 123.8], [8.463407, 53.626442, 1509423498599, 1.8]]'
        def historicalRouteFirst = new HistoricalRoute("123", 1, 2, "Opole", "Warszawa", 22, 30, dataOfVesselObservationFirst)
        def historicalRouteSecond = new HistoricalRoute("234", 33, 44, "Berlin", "Amsterdam", 55, 11, dataOfVesselObservationSecond)
        def dataSourceLoader = Mock(DataSourceLoader) {
            getHistoricalRoutes() >> List.of(historicalRouteFirst, historicalRouteSecond)
        }
        def typeService = new SearchTypeService(dataSourceLoader)

        when:
        def routeByTypeSearch = typeService.getRouteByTypeSearch(typeSearch)

        then:
        routeByTypeSearch.shipId == result

        where:
        typeSearch                  | result
        'maximum-speed'             | '234'
        'maximum-amount-readings'   | '123'
        'minimum-trip-duration'     | '123'
    }
}
