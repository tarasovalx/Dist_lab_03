mvn -X package

hdfs dfs -rm -r output

hadoop fs -copyFromLocal airports.csv
hadoop fs -copyFromLocal flights.csv


rm -r output

spark-submit --class ru.bmstu.lab3.Main --master yarn-client --num-executors 2 target/lab_03-1.0-SNAPSHOT.jar

hadoop fs -copyToLocal output ~/labs_output/lab_03