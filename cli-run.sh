./build.sh
if [ -z "$1" ]
  then
    FILE=testinput.txt
  else
    FILE=$1
fi

java --module-path mods:lib \
     -m easytext.cli/javamodularity.easytext.cli.Main $FILE
