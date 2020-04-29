# A HABIT TRACKER / JOURNALING APPLICATION
A Basic Habit Tracker and Journaling Application

## BUILD
### Java
>mvn package
>mvn compile

### Postgres
>docker build -t mydb -f src/main/db/Dockerfile
>docker run --name mydb -d --rm -p 5432:5432 mydb

## Usage
>java -cp target/journal-0.1.0.jar com.github.christiancastillo.journal.MainMenu

## Design

