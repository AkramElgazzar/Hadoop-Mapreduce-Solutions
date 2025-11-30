#!/bin/bash
hadoop com.sun.tools.javac.Main *.java
jar cf avgtemp.jar *.class
echo "Build completed: avgtemp.jar"
