for file in `find lastfm_subset -name *.json`
do
	echo "Importing ${file}"
	mongoimport --db music --collection songs --file ${file}
done
