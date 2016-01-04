./build.sh
mkdir mods/jarred
jar --create --file mods/jarred/javamodularity.easytext.algorithm.api@1.0.jar --module-version=1.0 -C mods/javamodularity.easytext.algorithm.api .
jar --create --file mods/jarred/javamodularity.easytext.algorithm.kincaid@1.0.jar --module-version=1.0 -C mods/javamodularity.easytext.algorithm.kincaid .
jar --create --file mods/jarred/javamodularity.easytext.cli@1.0.jar --module-version=1.0 --main-class=javamodularity.easytext.cli.Main -C mods/javamodularity.easytext.cli .

java -mp mods/jarred -m javamodularity.easytext.cli
