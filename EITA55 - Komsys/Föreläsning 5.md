Föreläsning 5
===

# Större nätverk

## Grundproblem
- Olika utbredningsmedium
- Många enheter

## Lösning: Nätprotokoll
- Ett lager av protokoll ovanför länkprotokollen
- MAC-adressen räcker inte om datorn är i ett annat nät
- Alla datorer behöver en nätadress för att kunna kommunicera
- Nätadressen talar även om vilket nät som mottagaren befinner sig i
- Är inte rimligt att leta genom alla världens enheter för att hitta rätt MAC-adress

### Analogi: Brev
- Om personen bor när kan man bara gå dit och ge dem det
- Om personen bor långt borta behöver man använda posten, i det fallet är ditt ansvar att gå över "din länk" till brevlådan och lägga brevet där.

### Vad är ett protokoll?
- En header
- Regler för hur det ska hanteras

## IP
- Header: Lär vi oss på övningar

#### IPv4 adresser
- IPv4-adresser: Flera olika steg som avgränsar
- Skrivs som fyra tal med punkter emellan: 192.168.172.134
- Består av 32 bitar
- Två delar: Nät-id och Värd-id
- Finns adress, subnet-mask, kan skrivas kortfattat med CIDR
- Subnet-mask avgör vilken del som är nät-id samt värd-id
- Nät-id avgör vilket nätverk man är på
- Värd-id avgör vem man är på nätverket
##### Exempel
- Adress: 222.23.67.68
- Mask:   255.255.192.0
- CIDR:   222.23.67.68 / 18


### Varför IPv6?
- Adressbrist: 32-bit vs 128-bit
- IoT: Kräver fler adresser
- Säkerhet: Inbyggda säkerhetsfunktioner
- Effektivitet: Förenklad header-struktur för snabbare routing1
- Bättre stöd för realtids-data via "Traffic class" header fält
- Adress skrivs: XXXX:XXXX:XXXX:XXXX:XXXX:XXXX:XXXX:XXXX

### Från IP-adress till MAC-adress
- Om destinationen är på samma nätverk så kan sändaren troligtvis leverera det själv
- Annars behöver det gå till en router
### ARP - Adress Resolution Protocol
- Hitta hur man hittar till en MAC-adress
- Hittas ingen så skickas paketet till en vägväljare (Router)
- Om IP adressen ser ut att vara på samma nätverk, så används ARP för att hitta MAC-adressen, sen skickas det dit
- Om ingen MAC-adress finns, så skickas paketet till en router

### Problem: IP är inte tillförlitligt
- Lösning: Transportprotokoll

## Tranportprotokoll

### Fördelar med lager
- Modularitet: Lättare att designa, implementera och felsöka
- Transportprotokoll: UDP & TCP
- Har portadresser: Låter en adressera en specifik applikation

### TCP
- Förbindelseorienterad dataöverföring
- Man skapar och använder förbindelser (connections)
- Tillförlitligt

### UDP
- Förbindelsefri dataöverföring
- Inte tillförlitlig
- "Best Effort"

### Varför finns ARQ på båda ställen?
- Båda delar bryr sig, oväntade saker kan använda
- ARQ på länklagert kan inte alltid garantera att ett paket kommer fram

## Överblick

### Fysiska lagret
- Standard för att överföra signaler på ett utbredningslager
- Kan vara vilken frekvens, vilken amplitud, vilket material kabeln är av

### Länk lagret
- Information paketeras i ramar, varje ram har en specifik mottagare på den länken
- Tillförlitlig över länken
- Ethernet protokoll

### Nät lagret
- Möjliggör kommunikation mellan nätverk
- MAC-adress-tabeller hade varit orimligt stora, därför behövs routing etc
- IP protokoll

### Tranport lagret
- Gör möjlighet att adressera applikationer
- Skapar tillförlitlig överföring över nätverk/internet
- TCP & UDP Protokoll

### Applikation lagret
-  Applikations-specifika protokoll, som t.ex. HTTP

### Andra lager, OSI 5-6
- Pratar vi inte om i kursen
- Inte relevanta

### Vägväljare
- Hubb: Fysiska lagret, replicator signaler exakt i alla andra anslutna länkar (Förstorar Collision Domain)
- Switch (Brygga): Är en medveten av länklagret, kan lära sig var noder finns och vilken port de är anslutna på
- Router: Är medveten av nät-lagret, vet var paket ska beroende på IP adress

# Nästa föreläsning
- Protokoll i flera skikt, fragmentering, vägval, DNS