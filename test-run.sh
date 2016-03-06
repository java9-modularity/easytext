./build.sh
rm -rf mods-test

javac -Xmodule:javamodularity.easytext.algorithm.naivesyllablecounter \
      -XaddReads:javamodularity.easytext.algorithm.naivesyllablecounter=org.junit \
      -mp mods:lib-test \
      -d mods-test/javamodularity.easytext.algorithm.naivesyllablecounter $(find src-test -name '*.java')

java -Xpatch:mods-test \
     -XaddReads:javamodularity.easytext.algorithm.naivesyllablecounter=org.junit \
     -XaddExports:javamodularity.easytext.algorithm.naivesyllablecounter/javamodularity.easytext.algorithm.naivesyllablecounter=org.junit \
     -mp mods:lib-test \
     -addmods javamodularity.easytext.algorithm.naivesyllablecounter,hamcrestcore \
     -m org.junit/org.junit.runner.JUnitCore javamodularity.easytext.algorithm.naivesyllablecounter.NaiveSyllableCounterTest