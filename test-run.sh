./build.sh
rm -rf mods-test

javac -Xmodule:easytext.algorithm.naivesyllablecounter \
      --add-reads easytext.algorithm.naivesyllablecounter=org.junit \
      --module-path mods:lib-test \
      -d mods-test/easytext.algorithm.naivesyllablecounter $(find src-test -name '*.java')

java --patch-module easytext.algorithm.naivesyllablecounter=mods-test \
     --add-reads easytext.algorithm.naivesyllablecounter=org.junit \
     --add-exports easytext.algorithm.naivesyllablecounter/javamodularity.easytext.algorithm.naivesyllablecounter=org.junit \
     --module-path mods:lib-test \
     --add-modules easytext.algorithm.naivesyllablecounter,hamcrest.core \
     -m org.junit/org.junit.runner.JUnitCore javamodularity.easytext.algorithm.naivesyllablecounter.NaiveSyllableCounterTest
