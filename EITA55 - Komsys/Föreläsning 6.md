Föreläsning 6
===
DNS, DHCP etc


## Protokoll i flera skikt
- OSI Modellen
- En nod på internet har minst 3 adresser, Lager 2: mac address, Lager 3: IP Address, Lager 4: TCP/UDP Port
- Nätverket ser ut olika på olika lager

### Lager 1 - Fysiska
- Bara en massa kablar osv.

### Lager 2 - Länk
- Varje port har en unik MAC Address

### Lager 3 - Nät
- Varje enhet i nätverket har en IP adress på det nätverket


## Varför har vi så många nät?
- Det ska vara skalbart
- Säkerhet: Alla paket flyger runt överallt
- Optimerad Trafik: Man kan ansluta relevanta delar
- Enklare Administration
- Effektiv Routing

## Inkapsling, Sändersidan
- Läggs på ytterligare metadata vid varje lager
- Varje lager sköter sitt jobb utan att oroa sig så mycket om resterande

## Inkapsling, Mottagarsidan
- Skalar av lager på lager medan det går genom lagerna

# MTU
- Maximum Transmission Unit
- Ethernet MTU = 1500
- PPP Länk över modem = 256/512
- Gigabit Ethernet Jumbo Frames = 9600
- IPv4 = 65553(?) inkl header
- IPv6 = 65553(?) excl header

## Vad gör man om ett paket är för stort?
- Fragmentering: Dela upp paketet och lägg en ny header på varje del
- Originella headern hanteras som data
- Defragmenteras vid mottagaren
- Mer data totalt, men mindre i varje, mindre effektivt
- Svårare och långsamare att hantera för mottagaren

# Routing
- Vägvalsalgoritmer (Routing algorithms)
- Syftet med vägvalsalgoritmer är att hitta den bästa möjliga vägen genom nätet för varje sänder-mottagarpar
- Vägvalsalgoritmer måste klara av nätverks dynamiska natur (saker ändras hela tiden)

## Nät-grafer
- Vad är det? Är en matematisk graf.
- Nod: En punkt i grafen som representerar en enhet i nätverket
- Kant: En kant/edge ansluter två noder och representerar en fysisk eller virituell förbindelse mellan dem
- Liknelse: Stadskarta

### Representera en nätverksgraf som en matris/tabell
- "Adjecency matrix"
- Har rader och kolumner
- Varje rad symboliserar en nod
- Varje kolumn symboliserar en rad
- Om två noder är anslutna med en kant så är det en 1 i tabellen

### Kanter kan ha olika egenskaper
- Kapacitet
- Begränsningar
- Sträcka
- Utbredningshastighet

## Enklaste vägvalsalgoritm - Flooding
- Varje router skickar ut paketet på alla sina länkar (utom där det kom in)
- Använder TTL (ipv4) / hop-count (ipv6) för att inte skapa loopar
- TTL/hop-count anger hur många noder/routrar ett paket får gå igenom
- Om TTL är 0 kastas paketet (först plockar routern bort 1 innan den kollar)
- 8 Bitar TTL/hop-count fält => En destination kan aldrig vara mer än 2^8 hopp bort

## Bättre val
### Två grundkoncept
- Least-hop vs Least-cost
- Least-hop = minst antal hopp
- Least-cost = minst kostnad (metrics antar jag)

### Hur funkar det?
- Routrar pratar med varandra och berättar vilka nät det är anslutna till

### Least-hop
- Väljer den vägen som har minst antal hopp
- Fördelar: Snabb och enkel att räkna ut
- Nackdel: Tar inte hänsyn till nätverksbelastning eller kvalitet

### Least-cost
- Väljer den "billigaste" vägen
- Varje kant har en viss kostnad
- Fördelar: Ger en mer optimerad och effektiv väg
- Nackdelar: Kräver mer beräkningskraft och data för att hitta den bästa vägen

### Djikstra
- Vad är det? En vedertagen strukturerad metod för att hitta den kortaste vägen

#### Hur används den? (? - Aningen inkomplett/odetaljerad)
1. Starta med "startnoden", sätt dess kostnad till 0 (vad betyde det?)
2. Uppdatera kostnaden till all grannnoder
3. Välj noden med minst kostnad och upprepa (kan gå tillbaka till förra så klart)

#### Var används det?
- Typ överallt, nätverksrouting, kartappar, spelprogrammering


## Vad finns i en Routers Routingtabell?

### Hur långt kan en router "se"?
- Oftast detaljerad information om sitt lokala nätverk
- 
## Hur hittar man på internet?
- DNS - "Domain Name Server"

### DNS
- Domäner, underdomäner
- Finns en massa DNS Servar / Name servers med stora ip--domän tabeller

## Hur får en dator en IP address?
- DHCP - Dynamic Host Configuration Protocol

### DHCPv4
- IP Address
- Subnet mask
- Default gateway
- DNS server(s)

### DHCPv6
- Network Discovery
- Datorn "hittar på" egen address
- ...