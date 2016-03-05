./build.sh
if [ -z "$1" ]
  then
    FILE=testinput.txt
  else
    FILE=$1
fi

java -mp mods:lib \
     -m javamodularity.easytext.cli/javamodularity.easytext.cli.Main $FILE