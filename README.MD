#JMX test
Autor: Jakub Karolczak

###Uruchomienie serwera
Przed uruchomieniem serwera, musimy dodaæ nastêpuj¹ce argumenty:

```
-Dcom.sun.management.jmxremote
-Dcom.sun.management.jmxremote.port=9999 
-com.sun.management.jmxremote.authenticate=false 
-Dcom.sun.management.jmxremote.ssl=false
```

###Klienci
#####Klient 1 - jconsole
#####Klient 2 - poprzez localhost:8080
#####Klient 3 - w konsoli terminala
uruchamiany poleceniem:
```
java -cp bin/ com.jakub.myjmx.Client
```