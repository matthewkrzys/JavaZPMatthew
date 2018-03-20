# JavaZPMatthew

## Zajęcia organizacyjne, warunki zaliczenia. Narzędzia do budowania.

### Zadanie : Fat jar 
Rozwiązanie znajduje się w katalogu simple.project
Zadanie uruchamiamy komendą
gradle build
Rezultat możemy zobaczyć w katalogu build/libs/

### Zadanie : Filtrowanie na modłę Mavena w Gradle'u
Rozwiązanie znajduje się w katalogu simple.project.two
Zadanie uruchamiamy komendą
gradle myTask -Pprofile=dev
lub
gradle myTask -Pprofile=test
Po wykonaniu jednej z komend powinien zostać stworzony db.properties 
Zawartość pliku jest zależna od wykonanej komendy

## Narzędzia do testowania.

### Zadanie : Naprawa SellingService 
Rozwiązanie znajduje się w katalogu w2-test-tools
Rozwiązanie zadania możemy znaleźć w katalogu
w2-test-tools/src/main/java/uj/jwzp/w2/e3
oraz
w2-test-tools/src/test/java/uj/jwzp/w2/e3

### Zadanie : Generator transakcji
Rozwiązanie znajduje się w katalogu project.exercise.two.two
Uruchomienie odbywa się przez wykonanie komendy
gradle shadowJar
Rezultat znajdziemy w katalogu build/libs
W tym katalogu należy wykonać komendę podaną w teści zadania
Po wykonaniu komendy w aktualnym katalogu pojawi się plik z rozwązaniem 
(zalecane umieszczenie pliku items.csv w katalogu z wygenerowanym plikiem jar)

