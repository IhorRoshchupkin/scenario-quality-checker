# IOD-I42-ALPHA-SQC
# scenario-quality-checker
aplikacja do analizy skryptów<br /><br />
<br /><br />
Notacja scenariuszy:<br />
• Scenariusz zawiera nagłówek określający jego tytuł i aktorów (zewnętrznych oraz system)<br />
• Scenariusz składa się z kroków (każdy krok zawiera tekst)<br />
• Kroki mogą zawierać pod-scenariusze (dowolny poziom zagłębień)<br />
• Kroki mogą się zaczynać od słów kluczowych: IF, ELSE, FOR EACH<br />
<br />
Przykład:<br />
Tytuł: Dodanie książki<br />
Aktorzy:  Bibliotekarz<br />
Aktor systemowy: System<br />
<br />
• Bibliotekarz wybiera opcje dodania nowej pozycji książkowej<br />
• Wyświetla się formularz.<br />
• Bibliotekarz podaje dane książki.<br />
• IF: Bibliotekarz pragnie dodać egzemplarze książki<br />
&nbsp; &nbsp; o Bibliotekarz wybiera opcję definiowania egzemplarzy<br />
&nbsp; &nbsp; o System prezentuje zdefiniowane egzemplarze<br />
&nbsp; &nbsp; o FOR EACH egzemplarz:<br />
&nbsp; &nbsp; &nbsp; &nbsp; • Bibliotekarz wybiera opcję dodania egzemplarza<br />
&nbsp; &nbsp; &nbsp; &nbsp; • System prosi o podanie danych egzemplarza<br />
&nbsp; &nbsp; &nbsp; &nbsp; • Bibliotekarz podaje dane egzemplarza i zatwierdza.<br />
&nbsp; &nbsp; &nbsp; &nbsp; • System informuje o poprawnym dodaniu egzemplarza i prezentuje zaktualizowaną listę egzemplarzy.<br />
• Bibliotekarz zatwierdza dodanie książki.<br />
• System informuje o poprawnym dodaniu książki.

## Jak uruchomić naszą aplikację:
Wpisać : "http://localhost:2264/{nazwa funkcji}/{nazwa json plika}"
