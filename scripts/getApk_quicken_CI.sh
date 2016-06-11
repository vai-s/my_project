source ~/.bash_profile
BASEDIR=$(dirname $0)
echo $BASEDIR
cd $BASEDIR
mkdir ../output

echo "in android automation script"
#export ANDROID_HOME=/Users/bnimmagadda/android/adt-bundle-mac-x86_64/sdk

python getApk_quicken_CI.py $1 $2
sleep 10

for file in '*.apk';
do
 FILENAME=$file
done
echo "File name is : " $FILENAME

$ANDROID_HOME/build-tools/20.0.0/zipalign 4 $FILENAME Temp.apk
sleep 5
cp -a Temp.apk Quickencom.apk 
rm Temp.apk

mv *.apk ../output