#!/bin/bash

mvnw clean package
docker build -t todo-api .
