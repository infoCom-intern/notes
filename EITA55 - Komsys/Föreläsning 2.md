Föreläsning 2
===
# Hur man representerar information
- Första binära: Morskod - Väldigt tillförlitligt

# ASCII vs Unicode
- ASCII: Färre symboler men färre bitar krävs per symbol, nästan bara amerikanska symboler
- UNICODE: Många många symboler, men många gånger fler bitar per symbol

# Bilder - Bitmap
## Delar - (Inte exakt förmodligen)
- Huvud (Header) "RGB BITMAP 3x3"
- Data (Payload) "011000101 0111010101 1100101"
- Svans (Tail) "Slut!"

# Mätfel finns i allt
- Mer indata (kanske fler sensorer, fler antennor) hjälper att minimera mätfel genom att låta t.ex. 3x3=9 sensorer i en kamera agera för att spara 1 pixel

# Bits vs Bytes
- Bit = minsta informationsenheten (atom), 0 eller 1
- Byte = grupp av 8 bitar, historiskt varit praktiskt
- **Gör alltid skillnad, speciellt på tentor**

# Digitalisering av ljud (digitsering enligt diggen)
## Pulse Code Modulation (PCM)
- Sampling
- Kvantisering
- Kodning

## Sampling
- Ta "snapshots" vid vissa tidsintervall
- Händer ofta nog att frekvens passar bättre, 1 Hz = 1 per sekund
- Ljudvågor består av många olika *superimposed* (superpositionsprincipen) ljudvågor med olika frekvens
- Nyquists Teorem - Måste sampla vid iallafall dubbelt så hög frekvens som den högsta i signalen

### Nyquist teorem
- Demonstration med sinus våg, om du samplar vid *samma frekvens* får du bara en rak linje. Du "träffar" bara samma ställe på vågen i perioden.
- Men om du samplar dubbelt så mycket så "tvingar" du att träffa på olika ställen i perioden, då får du *någon* precision

## Kvantisering
- Avrunding: Måste avrunda till närmasta amplitudnivå (kvantiseringsnivå)
- Bitdjup: Antalet tillgängliga *bitar till* amplitudnivåer, 8 bitar => 256 nivåer
- Kvantiseringsfel: Skillnaden mellan den sanna frekvensen och den avrundade frekvensen

## Kodning
- Vilka bitar ska representera vilken nivå
- Måste berätta hur du kodat, hur många bps (bitar per sekund), hur många bitar till amplitudnivåer (vilket bitdjup), vilken frekvens?
- Tradeoffs! Är det värt att inkludera möjligheten att byta bps/frekvens/sampling-rate i ett protokoll? Eller kostar det mer än det hade gjort att bara sampla hela filen i den högre frekvensen/sampling-raten/bps:n?

# Digital (och analog) kommunikation

## Analog kommunikation
- Analog telekommunikation finns
- Nuvarande analoga är bara analoga tills en låda i kvarteret som omvandlar signalen
- Analog kommunikation färdas genom ett medium, informationen förvrängs och skadas alltid på vägen till destinationen
- Information digitaliseras (digitiseras)
- Det blir olika fel (dämpning, störningar) vid alla ställen under transmissionen, går inte att reparera fel (till skillnad från digital kommunikation)

## Digital kommunikation
- Exakt kommunikation
- Möjligt att försöka återskapa skadad information (checksums, parity, etc)
- Mycket mer lämpad för långa avstånd, p.g.a. bland annat ovan

### Internet trivia
- Internet gick från början via analoga telefonlinjer
- Modem ringde (bokstavligen ringde) upp internetleverantören, sen skickades den digitala datan i analog form, i form av ljud

### Översättning från bitar till signaler
- Enklaste sätt: *linjekoding*: Använder olika spänningsnivåer
- Exempel. Non-return to zero (NRZ): Hög/Positiv spänning är 1, Låg/Negativ spänning är 0
- **Problem med NRZ:** Synkronisering: Svårt att urskilja långa långa rader nollor/ettor, små fel i tid blir stora, kan bli fel

#### Manchester
- Kombinerar NRZ och en klockpuls
- Inga problem med synkronisering
- Funkar: Spänningsförändringar: Högt till lågt = 0, Lågt till högt = 1
- Dubblet så hög frekvens

#### Differential Manchester
- Läs om i boken

### Modulering
- Sinusvåg representerar ettor eller nollor beroende på hur den är.
- Olika kombinationer med frekvens och amplitud och fas kan betyda olika kombinationer av ettor och noller
- Kräver mycket mer komplicerad hårdvara
- Kan bli mycket fel (många frekvenser/amplitud kombinationer gör det svårare)

#### Varför sinus?
- Råkar vara så att de är enkla att plocka upp

#### Frekvensmodulering
- (Läs i bok)

#### Fasmodulering
- (Läs i bok)

#### Amplitud
- (Läs i bok)

#### Exempel: Bithastighet för telefoni
- Röst: Analog signal i frekvensbandet 0 - 4kHz
- Nyquist => samplingsfrekvensen = (eller större) 8kHz = 8000 sample per sekund
- 8 bitar kodning per sample (mer/mindre ger bättre kvalité men behöver kunna förstås så klart)
- => Bithastighet = 64kbps

#### Signalkvalitet
- Dämpning (attenuation): (square-cube law, effekt sjunker med roten ur avståndet(?))
- Distorsion (distortion): Störning, signaler nära 
- Brus (noise)
- Överhörning (Cross-talk)
- Bitfelsfrekvens (Bit Error Rate)

# Fördjupningsuppgift
- Välj ett eller flera av FN:s hållbar-utvecklings mål
- Utforska hur telekommunikationsteknologi kan hjälpa lösa det? Var går gränsen? Hypas det upp (mycket teknologi görs)?
- Vilken teknologi behövs? Vad kan den lösa? Vad kan den inte lösa, vad mer behövs (samhällstruktur, etc)?
- Välj en/en grupp av teknologi, smalna av så det får plats i rapporten. Ska inte saknas något väsentligt, men kan inte gå djupgående på hundra elva saker

## Hur?

### Grupper
- Grupper på 4
- Varje grupp får en handledare, en annan grupp är handledare
- Det är gruppernas ansvar att hålla möten och utbyta feedback (handledar möten)
- Mötesfrekvens - Iallafall ett per vecka rekommenderas
- Dokumentation: Mötesanteckningar ska lämnas in via CANVAS efter varje möte
- Närvarokrav - Alla ska vara med på mötena, om någon inte kan komma, skriv varför i mötesanteckningarna

### Responsgrupper (Obligatoriska)
- Lära sig av andra gruppers arbete
- Dela med av erfarenhet och feedback
- Datum: Kommer på canvas

### Rapporten

#### Inlämningsdatum
- Utkast 6/10 kl 12:00
- Slutlig Version: 14/10 kl 12:00

#### Språk och Format
- Rapporten ska vara på svenska
- Max 4 sidor, IEEE-format

#### Organlitetskontroll
- PDF-filen kontrolleras automatiskt via Urkund
- Ej tillåtet att använda ChatGPT eller liknande

#### Peer Review
- Varje rapport granskas av fyra kamratgranskare

#### Studentkonferans
- Datum och Tid: 17 eller 18 Oktober, kl 9:00 - 16:00
- Obligatoriskt deltagande: Kontakta i nödfall
- Presentationstid: 20min/grupp där 15min/presentation och 5min/feedback

#### Allt via Canvas
- Kamratgranskning, etc


#### För att få godkänt som grupp
- Samarbete med Handledaren
- Responsgruppmöten
- Möta deadlines
- Rapportkvalitet
- Kamratgranskning
- Presentation

#### För att få godkänt som individ
- Gruppdynamik - Var aktiv
- Handledarmöten - Var med


### Exempel
- Nummer 3: Tillgodose god hälsa till alla
- Projekt: Mobilnät för att förbättra akutsjukvård i avlägsna områden
- Mål: Undersöka hur telekommunikation (mobil och satellit) kan hjälpa
- Vilken teknik behövs? 3G? 4G?
- Metod: Litteraturstudie, Teknologianalys, Begränsningsanalys och Kompletterande Åtgärder