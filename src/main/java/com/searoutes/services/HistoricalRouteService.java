package com.searoutes.services;

import com.searoutes.model.HistoricalRoute;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoricalRouteService {
//TODO 12
    private final SearchTypeService searchTypeService;

    public HistoricalRoute findHistoricalRoute(String typeSearch) {
        return searchTypeService.getRouteByTypeSearch(typeSearch);
    }

}
