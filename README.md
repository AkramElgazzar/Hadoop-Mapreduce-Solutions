# Hadoop MapReduce Tasks

This repository includes two Hadoop MapReduce projects executed on a fully functional Hadoop cluster deployed using Docker Compose.  
Both tasks were implemented, compiled, and tested on Hadoop 3.2+ with YARN and HDFS running across NameNode, DataNode, ResourceManager, and NodeManager containers.

---

## ✔️ Task 1 — Average Temperature
A MapReduce application that calculates the **average temperature for each city** from a CSV dataset containing city–temperature pairs.

📌 Key Features:
- Java implementation of Driver, Mapper, and Reducer.
- Processes structured temperature data stored in HDFS.
- Computes aggregated averages per key (city).
- End-to-end execution verified on YARN.
- Final results retrieved directly from HDFS output.

---

## ✔️ Task 2 — Inverted Index
A MapReduce job that builds an **Inverted Index**, a fundamental search-engine structure mapping each word to the documents in which it appears.

📌 Key Features:
- Java-based Driver, Mapper, and Reducer.
- Tokenizes multiple input text files stored on HDFS.
- Produces sorted `(word → document list)` mappings.
- Includes build and run scripts for automated execution.
- Output verified on HDFS and tracked through ResourceManager logs.

---

Both projects demonstrate practical, production-style Hadoop development—covering data ingestion, distributed processing using MapReduce, job scheduling through YARN, and data retrieval using HDFS.  
This repository serves as a solid reference for core Hadoop programming and cluster-based batch processing.
