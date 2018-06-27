#!/bin/bash
cd `dirname $0`
echo "====================== stop adc-boot service ================================"
./stop.sh
echo "====================== start adc-boot service ==============================="
./start.sh
