#!/usr/bin/env bash

echo $0
echo $1
echo $2

mkdir -p src/aoc/$1
echo >> src/aoc/$1/day$2.clj
mkdir -p test/aoc/$1
echo >> test/aoc/$1/day$2_test.clj
mkdir -p resources/$1
touch resources/$1/day$2.txt
