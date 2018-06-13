#Zadanie: BrokerTransakcji

##Uruchomienie 

gradle fatJar

cd build/libs/

java -jar transaction-generator.jar -itemsFile ~/items.csv -customerIds 1:1 -dateRange "2018-03-08T00:00:00.000-0100":"2018-03-08T23:59:59.999-0100" -itemsCount 1:2 -itemsQuantity 1:2 -outDir ./output -eventsCount 1 -format xml -broker tcp://localhost:32768 -queue transactions-queue -topic transaction-topics
