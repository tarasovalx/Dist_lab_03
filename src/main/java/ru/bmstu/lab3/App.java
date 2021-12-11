package ru.bmstu.lab3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class App {
    private final SparkConf conf;
    private static final  String OUTPUT_FILEPATH = "output";
    private static final String AIRPORTS_DATA_FILENAME="airports.csv";
    private static final String FLIGHTS_DATA_FILENAME="flights.csv";

    public App(SparkConf conf){
        this.conf = conf;
    }

    public void run(){
        JavaSparkContext sc=new JavaSparkContext(conf);
        JavaRDD<String> airports = sc.textFile(AIRPORTS_DATA_FILENAME);
        JavaRDD<String> flights = sc.textFile(FLIGHTS_DATA_FILENAME);
        flights.saveAsTextFile(OUTPUT_FILEPATH);
    }
}
