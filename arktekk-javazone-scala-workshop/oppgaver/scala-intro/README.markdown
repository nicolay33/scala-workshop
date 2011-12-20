Oppgaver: Scala - Intro
=====================

I disse oppgavene skal vi utforske noen grunnleggende konsepter i Scala. Vi skal bli kjent med litt syntax, og jobbe med klasser, objekter, traits, og collection rammeverket. 

Ikke bli sittende fast for lenge - spør instruktøren. Husk, vi skal ha det gøy!

Oppgave 1 - Klasser, traits og objekter
-----
I denne oppgaven skal vi se på Scala's støtte for objekt-orientering. Vi skal definere klasser, gjøre komposisjon med traits, og definere companion objects. En av tingene vi skal se på er hvordan komposisjon kan gi oss løst koblede biter av funksjonalitet. For dette skal vi utvikle en representasjon av en person, som hilser til alle som spør. Personen vil hilse mer vennlig til vennene sine.

Start med å verifiser at du får startet sbt og kjørt tester som forventet. 

1) Start sbt med start-scriptet som ligger i roten av oppgaven. 
2) Foreløpig vil ingen tester kjøre, men sjekk med `test-only oppgave1.PersonSuite`. 

Nå skal vi gradvis implementere alt som skal til for å få alle testene i `oppgave1.PersonSuite` til å kjøre grønt. Foreløpig er ingen av testene kommentert inn. 

3) Vi skal implementere alt i filen oppgave1.Person (ligger i src/main/scala/oppgave1/Person.scala). Følg instruksene som ligger i denne filen. Kommenter inn en og en test i PersionSuite for hvert av stegene

Tips:

* Se på slidene dere har fått utdelt
* Spør instrukstørene

Diskusjonspunkter:

* Hvordan ville man gjort dette i Java?

Oppgave 2 - Map og Option
-----
Nå skal vi se nærmere på Map i Scala, og hvordan denne bruker Option for å sikre korrekt håndtering av både kjente og ukjente nøkler. Vi skal også utforske hvordan vi kan jobbe med Option.

Vi skal jobbe med noen sultne dyr, sjekke hva de sier og hva de spiser. Vi tar utgangspunkt i en full suite av tester, og skal implementere tjenesten SultneDyr.

1) I klassen oppgave2.SultneDyr er det et sett av metoder som ikke er ferdig implementert. Det står beskrevet i kommentarer hva de er ment å gjøre. Se også på test-suiten oppgave2.SultneDyrSuite
2) Kjør testene med `test-only oppgave2.SultneDyrSuite`. Oppgaven er ferdig når alle testene kjører grønt

Diskusjonspunkter:

* Option vs null
* Hva har dette å si for typesikkerheten?

Oppgave 3 - Lister
-----
I denne oppgaven skal vi utforske Scala's rike collection-rammeverk. Som en del av dette skal vi jobbe med higher-order functions; funksjoner som tar funksjoner. Vi skal lete etter "idiomatiske" løsninger på problemene. Collection-rammeverket har mye å by på, og det er ofte en enklere måte å løse problemet på enn du kanskje først antar.

Vi skal ta utgangspunkt i et sett av tester, som dessverre ikke kjører. Målet er å få testene til å kjøre grønt. Stedene man skal gjøre endringer er markert med TODOs.

1) Testene kan kjøres med `test-only oppgave3.ListerSuite`
2) Løs oppgavene som er definert i oppgave3.ListerSuite

Tips:

* I hver test ligger det en imperativ variant av løsningen
* http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.List

Diskusjonspunkter:

* Funksjonell vs imperativ 
* Immutable vs mutable
