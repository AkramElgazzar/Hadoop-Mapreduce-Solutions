#!/bin/bash
set -e
echo "Create HDFS input dir"
hdfs dfs -mkdir -p /input/inverted
echo "Put data files into HDFS (overwrite if exists)"
hdfs dfs -put -f data/* /input/inverted/
echo "Remove old output if exists"
hdfs dfs -rm -r -f /output/invertedindex || true
echo "Run MapReduce job"
hadoop jar invertedindex.jar InvertedIndexDriver /input/inverted /output/invertedindex
echo "Collecting output to /root/inverted_result/part-r-00000"
mkdir -p /root/inverted_result
# try getmerge first (if multiple parts), otherwise get single file
hdfs dfs -getmerge /output/invertedindex /root/inverted_result/part-r-00000 || hdfs dfs -get /output/invertedindex/part-r-00000 /root/inverted_result/part-r-00000
echo "Done."
