./build-jar.sh

mkdir mods/coleman-analysis
mkdir mods/kincaid-analysis
mv mods/jarred/easytext.algorithm.coleman@1.0.jar mods/coleman-analysis
mv mods/jarred/easytext.algorithm.kincaid@1.0.jar mods/kincaid-analysis
mv mods/jarred/easytext.algorithm.naivesyllablecounter@1.0.jar mods/kincaid-analysis
mv mods/jarred/easytext.algorithm.nextgensyllablecounter@1.0.jar mods/kincaid-analysis
cp lib/syllable-counter-3.0.1.jar mods/kincaid-analysis

java --module-path mods/jarred -m easytext.gui
