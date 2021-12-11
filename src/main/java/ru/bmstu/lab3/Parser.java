package ru.bmstu.lab3;

import org.apache.spark.api.java.JavaRDD;

public class Parser {
    private static final String DELIMITER = ",";

    private static final int IS_CANCELLED = 19;
    private static final int DELAY_TIME = 18;
    private static final int AIRPORT_ID = 14;

    private static final int ORIGIN_AIRPORT_ID=11;
//    private static final int AIRPORT_NAME=1;

    private static final String CANCELLED_FLAG = "1.00";


    public static JavaRDD<Flight> parseFlightsRDD(JavaRDD<String> flights){
        return flights.map(str -> str.split(DELIMITER))
                      .map(str -> new Flight(str[IS_CANCELLED].equals(CANCELLED_FLAG),
                                             Float.parseFloat(str[DELAY_TIME]),
                                             Integer.parseInt(str[ORIGIN_AIRPORT_ID]),
                                             Integer.parseInt(str[AIRPORT_ID])));
    }

    public static JavaRDD<String, Airport> parseAirports(JavaRDD<String> airports){

    }
}
