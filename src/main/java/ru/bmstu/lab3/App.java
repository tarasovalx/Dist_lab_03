package ru.bmstu.lab3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import scala.Tuple2;

import java.util.Map;

public class App {
    private final SparkConf conf;
    private static final  String OUTPUT_FILEPATH = "output";
    private static final String AIRPORTS_DATA_FILENAME="airports.csv";
    private static final String FLIGHTS_DATA_FILENAME="flights.csv";

    public App(SparkConf conf){
        this.conf = conf;
    }

    public void run(){
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaPairRDD<Integer, Airport> airports = Parser.parseAirports(sc.textFile(AIRPORTS_DATA_FILENAME));
        JavaPairRDD<Tuple2<Integer, Integer>, Flight> flights = Parser.parseFlightsPairRDD(sc.textFile(FLIGHTS_DATA_FILENAME));
        flights.mapToPair(f -> new Tuple2<Tuple2<Integer, Integer>, Float>(f._1, f._2.getDelayTime())).reduceByKey(Math::max);
        Map<Integer, Airport> airportMap = airports.collectAsMap();

    }
}
