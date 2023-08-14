./gradlew --no-daemon :build -x test
mkdir -p run
mv build/libs/marvel-0.0.1-SNAPSHOT.jar ./run/marvel-0.0.1-SNAPSHOT.jar
echo "build - done"