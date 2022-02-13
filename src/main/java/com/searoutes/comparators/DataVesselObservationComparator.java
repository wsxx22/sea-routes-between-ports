package com.searoutes.comparators;

import com.searoutes.model.HistoricalRoute;

import java.util.Comparator;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class DataVesselObservationComparator implements Comparator<HistoricalRoute> {

    @Override
    public int compare(HistoricalRoute o1, HistoricalRoute o2) {
        String pattern = "[0-9]+\\.[0-9]+(?=])";
        Double maxSpeedFirstObject = getMaxDoubleByRegex(o1.getDataOfVesselObservation(), pattern);
        Double maxSpeedSecondObject = getMaxDoubleByRegex(o2.getDataOfVesselObservation(), pattern);

        return maxSpeedFirstObject.compareTo(maxSpeedSecondObject);
    }

    private Double getMaxDoubleByRegex(String valueInput, String pattern) {
        return Pattern.compile(pattern)
                .matcher(valueInput)
                .results()
                .map(MatchResult::group)
                .map(Double::parseDouble)
                .max(Double::compareTo)
                .orElseThrow();
    }
}
