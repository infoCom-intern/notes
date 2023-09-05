Föreläsning 4
===
#### Tenta: Måndagen den 23:e Oktober, kl 14-19

# Hur man kopplar ihop nät

# OSI-modellen (konstig?)
1. Applikation - applikationsprotokoll
2. Transport - transportprotokoll
3. Nät - nätprotokoll
4. Länk - länkprotokoll
5. Fysisk - (inga protokoll, fysiken gör det åt oss)
- Lager av regler

## Nätprotokoll
- Hur ser noden till att den kan prata med den nästa noden (inte slutdestination nödvändigtvis)


### Grundproblem
- Hur binder man samman flera nät?
- Hur finner datorer varandra över nät?
- Hur kan man göra kommunikation tillförlitlig över flera nät?

### Grundkoncept
- Hur fysiskt delar flera datorer på en kabel? (Man kan inte bara knyta ihop dem)
- Använder en Hubb/Switch (vägväljare), som sparar paket och skickar dem vidare
- "Inga" problem på trådlösa nätverk, finns redan koppling

### Lokala nät (LAN, Local Area Network)
#### Grundläggande egenskaper
- Begränsad storlek
- Enkel konfiguration
- Advancerade möjligheter

#### Kollisionsdomäner och bryggor
- Kollisionsdomän: Alla värdar som delar samma överföringsmedium tillhör samma kollisionsdömän

#### Hub
- Återskapar elektriska signaler i realtid, på grund av detta förstorar den en kollisionsdomän

#### Brygga / Switch
- Har en tabell över vilken adress är ansluten på vilken länk
- Ett paket har en adress, bryggan kollar adressen och skickar sen paketet den länken 
- Behöver hålla en tabellen 
- Noderna (datorerna) vet inte om bryggan/switchen, den bara förmedlar deras paket (till skillnad från t.ex. router)

#### Ethernet
- Utvecklades av Xerox, Intel, och DEC redan 1976
- IEEE 802.3 bygger på Ethernet, däri ingår Ethernet II
- Använder MAC-protokollet CSMA/CD
-
- Ethernet ram(frame), siffror i bytes: [Preamble: 7][SFD: 1][DA: 6][S: 6][Type: 2][Data: 46-1500][CRC: 4]
- Legend: DA - Destination Adress, SA - Source Adress
- Preamblen har ett unikt mönster, som på så sätt används för att veta var ett nytt paket börjar

### Stora nät
- LAN har begränsad storlek
- Behov: Man vill kunna kommunicera mellan olika noder oavsett hur långt ifrån varandra