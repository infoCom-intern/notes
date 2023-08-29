Föreläsning 1 - Introduktion - Kommunikationssystem
===
- Varför läsa kursen? Allting är uppkopplat.

## Vi ska lära oss om kommunikationssystem
- Överblick om hur kommunikationssystem
- Mindre teknisk kurs, mer förståelse
- Räkna på *vad behövs* för att t.ex. streama en video

## Kunskaper som krävs
- Fysik och matte: Trigonometri, hur ljus rör sig
- Elektronik: begrepp
- Programmering: till labbar

## Struktur
- 9+1 föreläsningar
- 5 övningar
- 1 fördjupningsuppgift
- 4 laborationer - Hur det teoretiska vi lärt oss fungerar
- 1 examination - En tenta i oktober

## Telekommunkation - Kommunikationssystem
- Ska gå snabbt
- Ska gå åt båda håll
- Ska gå rätt <=> Inte trasiga meddelande
- etc

### Vad är information? - Filosofisk fråga
- **Idag**: Bild, ljud, text
- **Framtiden**: ???
---
### Sensorer & ställdon(?) analoga
- Värme, lukt, etc
- Uppfattas (tolkas) olika

### Sensorer & ställdon(?) digitala
- Kameror, mikrofoner, etc
- Uppfattas (tolkas, snarare uppfattas) oftast lika,


### Analog vs Digital

- Olika sätt att representera information

**Analogt**
- Analog är kontinuerligt, inte kvantiserat, måste behållas analog hela vägen för att inte förlora information. 
- Analog utrustning förvränger informationen annorlunda till skillnad från digital.

**Digitalt**
- Digitalt är diskret, kvantiserat, det finns en "middle man" som onvandlar den analoga indatan till digital form. 
- Mycket information förloras när analog indata kvantiseras. 
- **I teori** förloras ingen information där digital information överförs.
- Kan vara väldigt svårt att kvantisera vissa saker, till exempel känslor.
- När analog information kvantiseras måste man avgöra hur mycket information man behöver behålla. Finns nästintill oändligt men detalj, kan inte behålla all. Liknelse: Approximera kurva med diskreta punkter
- Finns många fördelar att kommunicera digitalt


### Informationsöverföring

**Utbredningsmedel**
- Elektrisitet: Koppar sladd, aluminium, etc
- Ljudvågor, luft med visst tryck, etc
- Elektromagnetiska vågor: Radar, LiFi, WiFi, 5G, etc

**Exempel: nätadapter**
- Nätadaptern gör om den digitala informationen till en analog signal (som representerar digital information)
- Vi måste alltid behandla information i analog form i den fysiska världen, även om den representerar digital information

### Kommunikations-protokoll / standarder
- Protokoll anger hur information ska tolkas
- Protokoll behövs för att veta vad t.ex. en signal betyder

#### 6G (avspårat)
- Istället för basstation
- Antenner lite överallt, inbyggt i möbler, projektorer, etc
- Många antenner mycket närmre => Mindre energi för att skicka
- Mer tillförlitligt -> Snabbare (Nuvarande teknologi behöver re-requesta information som förloras [tänk tcp])

#### Dialog (dator & människa) - TCP (:
1. Dialogstart / New connection
2. Information / Request
3. Acknowledgement
4. Repeat step 2, 3
5. Dialogslut / Close connection

#### Olika lager - TCP/IP Stack (:
- Applikation -> Nätadapter

#### Sammanfatta protokoll
- Beskriver: hur, när, var
- Standardiserar, är ett krav för digital kommunkation
- Alla parter hur det fungerar från början, måste inte lista ut, extremt effektivare