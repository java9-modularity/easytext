./build.sh
rm -rf mod-test

javac -Xmodule:easytext.algorithm.naivesyllablecounter \
      --add-modules org.junit \
      --add-reads easytext.algorithm.naivesyllablecounter=org.junit \
      --module-path mods:lib-test \
      -d mod-test $(find src-test -name '*.java')

java --patch-module easytext.algorithm.naivesyllablecounter=mod-test \
     --add-reads easytext.algorithm.naivesyllablecounter=org.junit \
     --add-exports easytext.algorithm.naivesyllablecounter/javamodularity.easytext.algorithm.naivesyllablecounter=org.junit \
     --module-path mods:lib-test \
     --add-modules easytext.algorithm.naivesyllablecounter,hamcrest.core \
     -m org.junit/org.junit.runner.JUnitCore javamodularity.easytext.algorithm.naivesyllablecounter.NaiveSyllableCounterTest
