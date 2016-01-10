# Create a new empty module given a module-name like 'my.module.name'
CURDIR=`pwd`
mkdir -p src
cd src
mkdir $1
cd $1
echo "module $1 { }" >> module-info.java

arr=$(echo $1 | tr "." "\n")

for x in $arr
do
    mkdir -p $x;
    cd $x;
done

cd $CURDIR