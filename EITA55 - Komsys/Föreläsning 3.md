Föreläsning 3
===

Saker blir bättre trots att vi tar bort information, varför det? Vi behöver inte det vi tar bort, och vi är säkra på att det vi har kvar kommer fram helt.


# Anpassad komprimering
Talöverföring
- Speciella val av samplingsfrekvens och kvantisering. Konsekvens att saker som inte är röst låter sämre.

Musikåtergivning
- Betydligt högre krav än tal


# Hur överför man information tillförlitligt?
## Grundproblemet
- Överlappande röster: Två dator som skickar samtidigt
- Kollisioner: Signaler kolliderar och förvränger varandra
- Resurseffektivitet: Ineffektivt om det ofta blir fel, behöver väldigt mycket "vad sa du"
- Störningar: Signaler kan störa varandra

## Grundprincip
- Vi delar på allt, vägar, rummet vi sitter i, etc
- Burkar bli konflikter när man delar på saker
- Lösning: Ordning och reda - protokoll

## Grundsteg
- Detektera fel
- Hantera fel
- Undvika fel

### Grundkoncept
#### Datapaket (packets)
- "Packetera upp information" (packets), låter en ersätta endast individuella fel, istället för att behöva re-transmitta en hel sändning
- Tre delar, "Huvud (Header)", "Data (Payload)", "Svans (Tail)"
- Huvud och svans innehåller information för routing och etc
- Orsakar "overhead", extra information
- Motivationer: Enskild hantering ger flexibilitet, felkontroll - mindre data per paket förenklar feldetektering

### Tillförlitlighet
- Ett fel är om någon bit inte kommer fram som den det ska vara

### Nätverk
- Blir många olika delar som måste turas om att ge information till den nästa; hur ska man vara säker på att de den sista får rätt information?
- Kan uppstå fel vid alla noder
- **Skilj på** länkprotokoll och nätprotokoll (se presentation)

### Länkprotokoll
- Regler för hur *enheter på ett nätverk* kommunicerar över en gemensam länk
- 

### Multiplexering
- Många enheter som delar en länk
- Multiplexering - Att delar på en länk mellan flera enheter
#### Rumsmultiplexering
- Varje enhet får en viss del av en fysisk länk, kanske en viss tråd i en fiberkabel
#### Frekvensmultiplexering
- En fysisk länk delas in i flera logiska kanaler med olika frekvensband
#### Synkron tidsmultiplexering
- T.ex. Hur människor pratar
- Olika enheter får prata i tur och ordning, kanske får dela upp i små paket (packets) och turas om och skicka ett i tagen
#### Statistisk tidsmultiplexering
- Mottagaren behöver inte veta paketens ordning
- Multiplexaren (den som sänder) kan skicka i vilken ordning som helst
- Paket kan ha olika storlek
- Kräver svans (tail) och huvud (header)
 #### Koduppdelad multiplexering
- Du ändrar bitarna på ett visst sätt
- Ingår halvt i kursen (ingår inte hur exakt det funkar)

### Kontroll av dataöverföring
- Simplex: Endast en sändningsriktning är möjlig
- Halv duplex: Båda riktningar men inte samtidigt (WiFi t.ex.)
- Full duplex: Båda sändningsriktningar samtidigt, kräver uppdelning i två kanaler (dår varje sändare har en egen kanal)

## Att samsas
### Grundproblemet
- Rättvisa och Tillgänglighet: Vad är rättvisa?
- Komplexitet av Rättvisa: Att definera rättvisa är väldigt svårt
- Kännedom av Deltagare: Du måste veta vem som är ansluten och vem som önskar kommunicera
- Dynamisk Miljö: Kommer och går enheter hela tiden, går inte att förutsäga. Elektromagnetisk strålning är väldigt känsligt för miljön, att t.ex. öppna en dörr kan ändra hela miljön

### Hur hittar datorerna varandra?
- Unika adresser (typ IP adresser)
- Finns olika adresser för olika lager (t.ex. IP och MAC)
- Ruttning: Hitta en rätt till slutdestinationen
- Upptäcka: Hur ska man hitta vilka andra datorer finns?

#### Att sända data på ett LAN
- WiFi "strålning" strålar åt alla håll och når alla
- Paket måste ha en andress so endast rätt mottagare vet paketet är till dem

#### Multipel access
- Om alla skickar samtidigt så förstår strålningen för alla andra
- Polling: "Polla" (fråga) om någon annan sänder, om ingen annan gör, då sänder man
- Token Ring: Skicka runt en staffetpinne (token) i en förutbestämd ordning. Att svara på meddelande tar väldigt lång tid, staffetpinnen måste gå ett helt varv

#### ALOHA
- Centraliserad Arkitektur: Finns en centraldator som berättar vem som får lov att skicka
- Två olika kanaler för att skicka och ta emot data
- Direkt sändning: Alla skickar samtidigt
- Kollisoner leder till ~18% maximal utnyttjning av länken

#### Slotted ALOHA
- Tidsindelning, alla får skicka samtidigt men i diskreta "slots"
- Leder till att kollisioner alltid sker "fullt overlappande", d.v.s. hela paket kolliderar alltid med hela paket (ist. för att )

#### CSMA/CD - Carrier Sense Multiple Access with Collision Detection
- Carrier Sensing - Enheter lyssnar och skickar inte om de hör något
- Sändning - Om nätverket ser ut att vara ledigt så skickar den, annars väntar (Collison Avoidance)
- Kollisionsdetektering - Om en kollision upptäcks så avbryts sändningen och ett nytt försök görs efter slumpmässig väntetid
- **Slumpmässigt är viktigt**: Om alla väntar lika länge blir det kollisioner, om slumpmässig väntetid så är det sannolikt att det till slut blir ledigt
- Effektivitet & Rättvisa: CSMA/CD

### Att upptäcka bitfel
- Viktigt att kunna upptäcka bitfel
- Sändaren lägger på några bitar på slutet som kan användas för att kontrollera innehållet

#### Paritetsbit
- En paritetsbit berättar om innehållet har ett jämt eller ojämt antal ettor i paketet
- Snabb och enkel, väldigt så
- Kan inte upptäcka *två* felaktiga bitar, endast effektiv för enkla fel

#### Kontrollsumma (checksum)
- Princip vid sändning: Man summerar datan med en bestämd teknik

- **Exempel:**
1. Dela upp bitströmmet i lika stora segment
2. Summera segmenten; överskjutande ettor adderas till summan
3. Gör ett-komplement på den nya summan
4. Skicka segmenten tillsammans med komplementet av summan.

- Mottagaren gör det samma med datan, om summan är densamma är datan korrekt (med största sannolikhet)

#### Cyklisk Redundanscheck (CRC)
- Kommer inte gå in för djupt
- Läggs på i slutet
- Kan identifier var och hur stort felet är

Sändaren: skickar M(x) * x^k + R(x)

Mottagaren: Delar: M(x)/R(x), om resten blir 0 (binärt) är det korrekt mottaget

#### CRC: Hur?
1. Låt bitarna i paketet representeras av ett polynom M(x)

10011010 => M(x) = x⁷ + x⁴ + x³ + x

2. Använd ett generatorpolynom C(x) av grad k (Finns kurser på hur man hittar det, samma för dig och för mottagaren)

C(x) = x³+x²+1 (k=3)

3. Räkna paritetsbitarna R(x) som är resten vid polynomdivisionen

R(x) = (M(x) * x^k) / C(x)

=> (x^10+x^7+x^6+x^4) / (x^3+x^2+1)

Vid polynomdivisionen försvinner en term on den adderas med sig själv istället för att bli t.ex. 2x^10

x^10 + x^7 + x^6 + x^4 **/** x^3 + x^2 + 1

(*x^7) -> +x^10 + x^9 + x^7

= x^9 + x^6 + x^4

*(x^6) -> +x^9 + x^8 + x^6

= x^8 + x^4

*(x^5) -> +x^8 + x^7 + x^5

= x^7 + x^5 + x^4

*(x^4) -> x^7 + x^6 + x^4

= x^6 + x^5

*(x^3) -> x^6 + x^5 + x^3

= x^3

*(1) -> x^3 + x^2 + 1

= x^2 + 1 = 101



Lägg sen till R(x) som svans (tail) på meddelandet
-> "10011010" + "101" = "10011010101"

# Introduktion till ARQ (Automatic Repeat Request)
- Grundkoncept: Bekräfta och skicka information för att säkerställa korrektöverföring
- Analogi: "Har du förstått?

## Generellt neråt
- Större fönster => Mer paket "in-flight"
- Fönsterstorlek anger vilka paket som får skickas / tas emot
- Fönster "slidas vidare" när paket i "början på fönstert" har fått ACK

## Stop-and-wait
- Grundprincip: Ett paket i taget
- Skicka paket, vänta på bekräftelse, skicka nästa.
- Om inte bekräftelse kommer, skicka igen
- Nackdel: Tar lång tid p.g.a. väntande och time-out.
- Använder bara 2 sekvensnummer: 0 och 1. Detta fungerar endast eftersom ett enda paket väntas på i taget, **VIKTIGT**.
- Otroligt primitivt sätt

## Go-back-N
- Flera Paket: Skickas flera paket parallelt
- Sändarfönster (window) anger vilka många paket som får skickas
- Mottagaren har endast ett fönster med endast ett enda paket, väntar på först paket 0, sen paket 1, sen paket 2, etc
- Mottagaren skickar ingen ACK om det är fel på något paket
- Effektivare än Stop-and-wait
- Nackdel: Om ett paket förloras så måste all paket efter det i sändarfönster skickas om, blir problem med stora sönderfönster

## Selective repeat
- Både mottagare och sändare har ett fönster
- Har både ACK och **NAK**
- Behöver inga timeouts
- Om ett paket tas emot ur ordning, alltså typ Frame 3 före Frame 2, så skickas en "NAK 2" för att be sändaren att skicka det
- Fönstert får inte vara större än hälften av sekvensnummern, annars kan sändare fönstert "glida(slida) över" till nästa "0:a", vilket hade lurat mottagaren (som förväntade sig förra 0:n) (0 är bara ett exempel, kan ske med annan siffra)

# Hidden Node Problem"
- Två noder kommunicerar med en mellannod via samma medium men kan inte se varandra. Kan orsaka svår-upptäckta kollisioner

# Överföringstid
- Överföringstid = Transmissionstid + Propageringstid
- Transmissionstid: Tiden det tar att skicka paketet (alla bitarna av paketet)
- Propageringstid - Tiden det tar för själva signalen att resa från sändaren till mottagaren

## Transmissiontid (Transmission Time)
- Definition: Tiden det tar att skicka all bitar av ett datapaket på länken från sändare till mottagare. (Till skillnad från propogationstid)
- Transmissionshastighet: bitar per sekund
- Faktorer: Beror på paketets storlek och länkens överföringshastighet (bandbredd)
- Enhet: Tid, ofta millisekunder eller sekunder

## Propageringstid (Propogation Time)
- Definition: Tiden det tar för en signal att färdas från sändaren till mottagaren över en kommunikationssignal
- Propageringshastighet: meter per sekund
- Faktorer: Medium

# Hur upptäcks kollisioner
- Om paketen kolliderar (överlagras) mitt på länken kan vi inte se det
- Om mottagaren får ett paket samtidigt som den skickar ett, har det med all sannolikhet skett en kollision

## Upptäckt av kollisioner och dess begränsningar

### Hur kollisioner upptäcks
- Enheter lyssnar och skickar data samtidigt
- Jämförelse: Om den mottagna signalen inte matchar den sända, har en kollision skett (man lyssnar och förväntar sig höra sitt egna paket medan man sänder det, om man inte hör det så har en kollision skett)

### Faktorer som påverkar Kollisioner
- Sändningstid
- Propageringstid
- Om sändingstiden är mindre än propageringstiden, så tilllåter det att ett paket sänds helt innan någon del av det har tagits emot, då kan det kollidera med ett annat paket mitt på länken, där ingan av vardera enheter kan "höra", och därmed kan kollisionen inte upptäckas. (Kan så klart upptäcka via CRC/Checksum/paritetsbit/etc men det är mycket långsamare att vänta på att ett helt fel paket kommer fram och sen hantera den)

### Åtgärder
- Kablar har oftast maxlängd (enligt standarder)
- Minimal längd på paket (du vill ockupera hela länken med ett paket, eftersom om någon annan börjar skicka precis när din första bit kommer fram, så kommer du alltid märka att du tar emot den biten medan du fortfarande skickar ditt paket)