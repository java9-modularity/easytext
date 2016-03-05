./build.sh
mkdir mods/jarred
jar --create --file mods/jarred/javamodularity.easytext.algorithm.api@1.0.jar --module-version=1.0 -C mods/javamodularity.easytext.algorithm.api .
jar --create --file mods/jarred/javamodularity.easytext.algorithm.coleman@1.0.jar --module-version=1.0 -C mods/javamodularity.easytext.algorithm.coleman .
jar --create --file mods/jarred/javamodularity.easytext.algorithm.kincaid@1.0.jar --module-version=1.0 -C mods/javamodularity.easytext.algorithm.kincaid .
jar --create --file mods/jarred/javamodularity.easytext.algorithm.naivesyllablecounter@1.0.jar --module-version=1.0 -C mods/javamodularity.easytext.algorithm.naivesyllablecounter .
jar --create --file mods/jarred/javamodularity.easytext.algorithm.nextgensyllablecounter@1.0.jar --module-version=1.0 -C mods/javamodularity.easytext.algorithm.nextgensyllablecounter .
jar --create --file mods/jarred/javamodularity.easytext.cli@1.0.jar --module-version=1.0 --main-class=javamodularity.easytext.cli.Main -C mods/javamodularity.easytext.cli .
jar --create --file mods/jarred/javamodularity.easytext.gui@1.0.jar --module-version=1.0 --main-class=javamodularity.easytext.gui.Main -C mods/javamodularity.easytext.gui .

java -mp mods/jarred:lib -m javamodularity.easytext.gui
