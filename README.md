# Allegro Summer e-Xperience 2022 
Mail użyty w procesie rekturacji: <b>adrian.budka134@gmail.com</b> <br />
Zadanie <b>nr. 1</b> Mobile Software Engineer

# Uruchomienie aplikacji
Zainstalować aplikację z załączonego w repozytorium pliku .apk

# Poruszanie się po aplikacji
Główny ekran aplikacji zawiera wyszukiwarke repozytoriów, po wpisaniu w pole tekstowe nazwy użytkownika GitHub oraz wciśnięciu przycisku "Search" zostanie wyświetlona lista wczytanych repozytoriów z profilu wyszukanego użytkownika. Po kliknięciu w element listy z nazwą repozytorium przechodzimy do szczególowych informacji. <br />
Ekran szczegółowy zawiera pełną nazwę repozytorium, nazwę autora, datę utworzenia oraz listę użytych języków wraz z ilością bajtów kodu w danym języku.

# Informacje
Aplikacja oparta jest na wzorcu MVVM, wykorzystuje GitHub API oraz Retrofit do pobierania danych repozytoriów. Przy tworzeniu aplikacji wykorzystałem ViewBinding, wstrzykiwanie zależności przy użyciu Hilt oraz komponent nawigacyjny Navigation (będący częścią biblioteki Jetpack) do przechodzenia między fragmentami. 

# Uproszczenia
Niestety nie zdążyłem zaimplementować paginacji, która ograniczyłaby ilość początkowo wczytywanych danych - aktualne ograniczenie API to 100 pozycji wczytanych z jednego zapytania. <br />
W celu przekazania listy językow do wyświetlenia mapuję ConcurrentHashMapę na ArrayListe - można zastanowić się nad lepszym rozwiązaniem.

# Rozbudowanie aplikacji
paginacja <br />
Jetpack Compose <br />
dodatkowe informacje na temat repozytorium <br />
wyszukiwarka wyszukująca użytkowników na podstawie podanej wartości <br />
sprawdzanie stanu połączenia z internetem <br />
uatrakcyjnienie UI <br />
możliwość dodania repozytorium do listy ulubionych <br />
