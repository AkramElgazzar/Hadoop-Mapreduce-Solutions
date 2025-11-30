#!/bin/bash
set -e
mkdir -p classes
echo "Compiling Java sources..."
javac -classpath "`hadoop classpath`" -d classes src/*.java
echo "Creating JAR..."
jar -cvf invertedindex.jar -C classes/ .
echo "Build finished: invertedindex.jar"
