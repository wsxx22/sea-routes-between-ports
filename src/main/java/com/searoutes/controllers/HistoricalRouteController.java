package com.searoutes.controllers;

import com.searoutes.model.HistoricalRoute;
import com.searoutes.services.HistoricalRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("historical-routes")
@RequiredArgsConstructor
public class HistoricalRouteController {

    private final HistoricalRouteService historicalRouteService;

    @GetMapping("search-by")
    public ResponseEntity<HistoricalRoute> findHistoricalRoute(@RequestParam String typeSearch) {

        HistoricalRoute historicalRoute = historicalRouteService.findHistoricalRoute(typeSearch);
        return ResponseEntity.ok(historicalRoute);
    }
}
