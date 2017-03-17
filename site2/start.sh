#!/bin/bash

pushd ../listener
gradle assemble
popd

gfsh run --file=start.gfsh

