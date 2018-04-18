#!/bin/bash

mvn package
java -cp target/szeregowanie-1.0-SNAPSHOT.jar CriticalPathMethod/Main
