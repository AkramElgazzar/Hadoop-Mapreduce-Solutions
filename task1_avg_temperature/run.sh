#!/bin/bash
hdfs dfs -rm -r /output/avgtemp 2>/dev/null
hadoop jar avgtemp.jar AvgTempDriver /input/task_data.txt /output/avgtemp
hdfs dfs -cat /output/avgtemp/part-r-00000
