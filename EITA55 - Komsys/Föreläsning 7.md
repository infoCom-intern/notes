Föreläsning 7 - Internet i verkligheten
===


# NAT - Nätverksadressöversättning
- Problem: Inte tillräckligt med IPv4 adresser
- Lösning: Använd lokala ip adresser inom ett nätverk med en offentlig IP-adress som proxy
- Problem: Mycket bokföring (Var ska ett paket gå?)
- Bonus: Säkerhetsfördelar

## Hur vet NAT-servern var ett inkommande paket ska gå?
- Varier ar hur de lister ut det
- Försöker hålla koll på (http/etc/etc) konversationer osv.

# Traceroute
- Skickar helt vanliga ICMP echo paket med TTL = 1, 2, 3, osv.
- Allra flesta routerar berättar "Hej, jag är XYZ och slängde ditt paket" när de slänger ett paket

# Vad är internet?

## En nods självinsikt
- Per nätverk: IP-adress, Nätmask, DNS, MAC-address
- Delat mellan alla anslutna nätverk: Default gateway

## Routing
- Routrar pratar med varandra via t.ex. BGP, för att berätta för varandra vilka nätverk de är anslutna till direkt/indirekt


# Modeller

## Client/Server modellen
- Finns klient och server
- Klienter pratar endast med varandra via servern
- Centraliserat

## Peer 2 Peer
- Klienter pratar med varandra

# Cloud
- En annan persons dator
- Oftast i speciella datacenter
- Delar datorn med andra

## Virtualisering
- Låtsas datorer inuti en fysisk dator
- Många instanser med olika operativsystem
- Fungerar som en vanlig dator men delar samma fysiska hårdvara
- På Engelska: Virtual Machine (VM)

## Cloud från början
- Hyr en eller flera VM
- Får IP-adress av moln-leverantröen
- Kostnad baserad på tid och typ
- Enkelt att skaffa flera VM när det behövs: Skalbart

## Cloud-native
- Containers (ist. för VM)
- Monolitisk
- Container: En monolit med allt den behöver för att köra
- Delar upp stora program i många små delar, låter en skala olika delar av program individuellt