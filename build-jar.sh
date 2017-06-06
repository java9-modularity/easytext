./build.sh
rm -rf mods/jarred
mkdir mods/jarred

jar --create --file mods/jarred/easytext.algorithm.api@1.0.jar --module-version=1.0 -C mods/easytext.algorithm.api .
jar --create --file mods/jarred/easytext.algorithm.coleman@1.0.jar --module-version=1.0 -C mods/easytext.algorithm.coleman .
jar --create --file mods/jarred/easytext.algorithm.kincaid@1.0.jar --module-version=1.0 -C mods/easytext.algorithm.kincaid .
jar --create --file mods/jarred/easytext.algorithm.naivesyllablecounter@1.0.jar --module-version=1.0 -C mods/easytext.algorithm.naivesyllablecounter .
jar --create --file mods/jarred/easytext.algorithm.nextgensyllablecounter@1.0.jar --module-version=1.0 -C mods/easytext.algorithm.nextgensyllablecounter .
jar --create --file mods/jarred/easytext.cli@1.0.jar --module-version=1.0 --main-class=javamodularity.easytext.cli.Main -C mods/easytext.cli .
jar --create --file mods/jarred/easytext.gui@1.0.jar --module-version=1.0 --main-class=javamodularity.easytext.gui.Main -C mods/easytext.gui .
