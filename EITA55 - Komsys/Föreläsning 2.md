Föreläsning 2
===
## Hur man representerar information
- Första binära: Morskod - Väldigt tillförlitligt

## ASCII vs Unicode
- ASCII: Färre symboler men färre bitar krävs per symbol, nästan bara amerikanska symboler
- UNICODE: Många många symboler, men många gånger fler bitar per symbol

## Bilder - Bitmap
### Delar - (Inte exakt förmodligen)
- Huvud (Header) "RGB BITMAP 3x3"
- Data (Payload) "011000101 0111010101 1100101"
- Svans (Tail) "Slut!"

## Mätfel finns i allt
- Mer indata (kanske fler sensorer, fler antennor) hjälper att minimera mätfel genom att låta t.ex. 3x3=9 sensorer i en kamera agera för att spara 1 pixel

## Bits vs Bytes
- Bit = minsta informationsenheten (atom), 0 eller 1
- Byte = grupp av 8 bitar, historiskt varit praktiskt
- **Gör alltid skillnad, speciellt på tentor**

## Digitalisering av ljud (digitsering enligt diggen)
### Pulse Code Modulation (PCM)
- Sampling
- Kvantisering
- Kodning

### Sampling
- Ta "snapshots" vid vissa tidsintervall
- Händer ofta nog att frekvens passar bättre, 1 Hz = 1 per sekund
- Ljudvågor består av många olika *superimposed* (superpositionsprincipen) ljudvågor med olika frekvens
- Nyquists Teorem - Måste sampla vid iallafall dubbelt så hög frekvens som den högsta i signalen

#### Nyquist teorem
- Demonstration med sinus våg, om du samplar vid *samma frekvens* får du bara en rak linje. Du "träffar" bara samma ställe på vågen i perioden.
- Men om du samplar dubbelt så mycket så "tvingar" du att träffa på olika ställen i perioden, då får du *någon* precision

### Kvantisering
- Avrunding: Måste avrunda till närmasta amplitudnivå (kvantiseringsnivå)
- Bitdjup: Antalet tillgängliga *bitar till* amplitudnivåer, 8 bitar => 256 nivåer
- Kvantiseringsfel: Skillnaden mellan den sanna frekvensen och den avrundade frekvensen

### Kodning
- Vilka bitar ska representera vilken nivå
- Måste berätta hur du kodat, hur många bps (bitar per sekund), hur många bitar till amplitudnivåer (vilket bitdjup), vilken frekvens?
- Tradeoffs! Är det värt att inkludera möjligheten att byta bps/frekvens/sampling-rate i ett protokoll? Eller kostar det mer än det hade gjort att bara sampla hela filen i den högre frekvensen/sampling-raten/bps:n?

