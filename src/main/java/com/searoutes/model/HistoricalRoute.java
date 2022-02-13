package com.searoutes.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HistoricalRoute {

    @CsvBindByPosition(position = 0)
    private String shipId;

    @CsvBindByPosition(position = 1)
    private Integer routeIdFrom;

    @CsvBindByPosition(position = 2)
    private Integer routeIdTo;

    @CsvBindByPosition(position = 3)
    private String routeOrigin;

    @CsvBindByPosition(position = 4)
    private String routeDestination;

    @CsvBindByPosition(position = 5)
    private Integer tripDuration;

    @CsvBindByPosition(position = 6)
    private Integer totalNumberReadings;

    @CsvBindByPosition(position = 7)
    private String dataOfVesselObservation;
}
