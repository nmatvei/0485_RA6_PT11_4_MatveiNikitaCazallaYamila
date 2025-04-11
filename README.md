Activitat proposada pel professorat de l'asignatura de programació:

Un laboratori d’investigació cultiva una colònia de bacteris dins d’una àrea que es pot
considerar com una superfície quadriculada de dimensió 30 x 30 (considereu la dimensió
una constant). Cada casella pot ser buida o contenir un bacteri. A partir de la seva
configuració inicial, la colònia evoluciona generació rere generació segons unes lleis
genètiques que tot seguit es descriuen i que depenen del nombre de veïns que té cada
casella:

  - **Naixement:** tota casella buida amb exactament tres veïns tindrà un naixement la
    propera generació.
  - **Mort per solitud:** tot bacteri que ocupa una casella amb 0 o 1 veïns morirà per solitud
    la propera generació.
  - **Supervivència:** tot bacteri que ocupa una casella amb 2 o 3 veïns sobreviurà la propera generació.
  - **Mort per asfixia:** tot bacteri que ocupa una casella amb més de 3 veïns morirà per asfixia la següent generació.

Noteu que cada bacteri té com a molt 8 veïns i que en el cas dels bacteris residents a les
vores de la quadrícula el nombre de veïns és menor.

Es considera que la transició entre generacions és simultània en totes les caselles de la
colònia.

Es demana dissenyar un programa que simuli l’evolució de la colònia de bacteris i determini,
a partir d’una situació inicial aleatòria, quantes iteracions es necessiten per tal que la colònia
arribi a una situació estable.

El programa ha de seguir el paradigma de la POO (Programació Orientada a Objectes).
Podeu seguir una estructura de l’estil:

**Classe Bacteris**
    - Paràmetres: matriu, colònia estable, número d’iteracions...
    - Constructor defecte i parametritzat.
    - Mètodes: generar generació inicial, generar generació, mostrar generació, cultivar
      bacteris, veïns...
      
  **Classe Main**
    - Dissenyar un array list que contingui colònies de bacteris.

Aclariments sobre alguns mètodes:
  - **Generar generació inicial:** ha de crear una colònia de forma aleatòria. Retornarà
    valors que seran o bé 0 o bé 1 (podeu considerar per exemple que 1 representa que hi
    ha un bacteri i 0 que no).
  - **Mostrar generació:** simplement mostrarà per pantalla l’estat actual. No cal fer filigranes en
    la presentació, simplement que s’entengui el que hi ha.
  - **Generar generació:** ens crea la nova generació seguint les regles explicades abans. Òbviament per poder-ho fer haurà
    de cridar a una funció veïns que ens indiqui per a cada posició de la matriu, quants veïns n’hi ha.

Es considera que la situació és estable quan després de crear una nova generació ja no hi
ha canvis a la colònia.

Aquest sistema genètic funciona, però per possibles errors de programació podria ser que
entrés en un bucle infinit. També és cert que en algun cas pot entrar en un cicle de dues
voltes i, per tant, entraria en un bucle infinit encara que el codi sigui correcte.

**NOTES:**
Prova cada un dels mètodes per separat i comprova que funciona: pots fer proves amb
dimensions més petites (per exemple 6x6)
*Cal comentar el codi!*

***Activitats adaptades i d’ampliació (AiA).***
**Ampliació:**
  - Mostra per pantalla l’evolució de la colònia a mida que van succeint les generacions.
  - Solucionar el cas en el qual la colònia de bacteris entri en un cicle de dues voltes.
