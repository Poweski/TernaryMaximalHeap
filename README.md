# TernaryMaximalHeap
Seventh assignment for algorithms and data structures lab.

Zdefiniuj klasę implementujące strukturę ternarnego (węzły z trojgiem
dzieci) kopca maksymalnego (ang. ternary max-heap) Array3Heap<T>
zaimplementowanego na tablicy.

Interfejs kopca powinien udostępniać dwie operacje:  
• void clear() – czyszczącą kopiec (usuwającą wszystkie elementy),  
• void add(T element) – wstawiającą nowy element do kopca,  
• T minimum() – zwracającą minimalny element kopca wraz z jego
usunięciem.

Opis budowy kopca opisano na wykładzie 6.  
Podczas konstrukcji kopca przekaż podstawową pojemność,
a gdy w kopcu nie ma miejsca, należy rozmiar podwoić.
Załóż, że null nie jest poprawną wartością.

Wskazówka:  
Podobnie jak w przypadku kopca binarnego, dla kopca ternarnego można
wyprowadzić wzory na indeksy elementów – dzieci i rodzica – po
wprowadzeniu odpowiedniej numeracji węzłów. Na podstawie rysunku
takiego jak Rysunek 1, rozpisz w tabelkach pary rodzic-dziecko dla lewego,
środkowego i prawego dziecka. Na ich podstawie podaj wzory na indeksy.
Indeks rodzica to: ⌊(𝑖−1)/3⌋ – wykorzystując dzielenie całkowitoliczbowe
można pominąć operację podłogi (⌊∙⌋).
