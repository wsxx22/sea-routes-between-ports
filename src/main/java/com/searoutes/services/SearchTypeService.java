package com.searoutes.services;

import com.searoutes.comparators.DataVesselObservationComparator;
import com.searoutes.config.exceptions.HistoricalRouteNotFoundException;
import com.searoutes.model.HistoricalRoute;
import com.searoutes.utils.DataSourceLoader;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Service
public class SearchTypeService {

    private final DataSourceLoader dataSourceLoader;
    private final HashMap<String, Supplier<HistoricalRoute>> searchTypes;

    public SearchTypeService(DataSourceLoader dataSourceLoader) {
        this.dataSourceLoader = dataSourceLoader;
        searchTypes = new HashMap<>();
        loadSearchTypes();
    }

    public HistoricalRoute getRouteByTypeSearch(String typeSearch) {
        return searchTypes.entrySet().stream()
                .filter(filterTypes -> typeSearch.equals(filterTypes.getKey()))
                .findFirst()
                .map(Map.Entry::getValue)
                .map(Supplier::get)
                .orElseThrow(HistoricalRouteNotFoundException::new);
    }

    private void loadSearchTypes() {
        List<HistoricalRoute> routes = dataSourceLoader.getHistoricalRoutes();
        searchTypes.put("minimum-trip-duration", sortByMinimumTripDuration(routes));
        searchTypes.put("maximum-amount-readings", sortByMaximumTotalNumberReadings(routes));
        searchTypes.put("maximum-speed", sortByMaximumSpeed(routes));
    }

    private Supplier<HistoricalRoute> sortByMinimumTripDuration(List<HistoricalRoute> historicalRoutes) {
        return () -> historicalRoutes.stream()
                .min(Comparator.comparing(HistoricalRoute::getTripDuration))
                .orElseThrow(HistoricalRouteNotFoundException::new);
    }

    private Supplier<HistoricalRoute> sortByMaximumTotalNumberReadings(List<HistoricalRoute> historicalRoutes) {
        return () -> historicalRoutes.stream()
                .min((o1, o2) -> o2.getTotalNumberReadings().compareTo(o1.getTotalNumberReadings()))
                .orElseThrow(HistoricalRouteNotFoundException::new);
    }

    private Supplier<HistoricalRoute> sortByMaximumSpeed(List<HistoricalRoute> historicalRoutes) {
        return () -> historicalRoutes.stream()
                .max(new DataVesselObservationComparator())
                .orElseThrow(HistoricalRouteNotFoundException::new);
    }
}
