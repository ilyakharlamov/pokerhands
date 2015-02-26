#!/usr/bin/sh
rm -f sources.txt
find . -name "*.java" |grep -v Test> sources.txt
javac @sources.txt
echo "now you can run as\njava -cp src com.ilyakharlamov.pockerhands.Standalone 2C3D4H5S6S 2D3D4D5D6D"
