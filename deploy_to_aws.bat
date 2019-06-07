wget https://github.com/sundeepd1991/caterwings.git
unzip master -d /tmp/caterwings_Temp
mkdir -p /tmp/caterwings
cp -paf /tmp/caterwings_Temp/caterwings-master/* /tmp/caterwings
rm -rf /tmp/caterwings_Temp
rm -f master