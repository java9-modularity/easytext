rm -rf mods
mkdir mods

# Copy resources
cd src
rsync -Rq $(find . -name *.png -o -name *.gif) ../mods
cd -

# Compile modules
javac -Xlint:unchecked      \
      -mp lib               \
      -modulesourcepath src \
      -d mods $(find src -name '*.java')