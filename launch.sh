mvn -X package

start-dfs.sh
start-yarn.sh

hdfs dfs -rm -r output

hadoop fs -copyFromLocal airports.csv
hadoop fs -copyFromLocal flights.csv

export HADOOP_CLASSPATH=./target/lab_03-1.0-SNAPSHOT.jar

hadoop bmstu.ru.Main output

spark --class ru.bmstu.lab3.Main --master yarn-client --num-executors 3 target/spark-examples-1.0-SNAPSHOT.jar

hadoop fs -copyToLocal output ~/labs_output/lab_03