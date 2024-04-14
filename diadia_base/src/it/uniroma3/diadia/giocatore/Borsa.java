package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
public final static int DEFAULT_PESO_MAX_BORSA = 10;
public Attrezzo[] attrezzi;
public int numeroAttrezzi;
private int pesoMax;
public Borsa() {
this(DEFAULT_PESO_MAX_BORSA);
}

public Borsa(int pesoMax) {
this.pesoMax = pesoMax;
this.attrezzi = new Attrezzo[10]; // speriamo bastino...
this.numeroAttrezzi = 0;
}

public boolean addAttrezzo(Attrezzo attrezzo) {
if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
return false;
if (this.numeroAttrezzi==10)
return false;
this.attrezzi[this.numeroAttrezzi] = attrezzo;
this.numeroAttrezzi++;
return true;
}

public int getPesoMax() {
return pesoMax;
}


public Attrezzo getAttrezzo(String nomeAttrezzo) {
Attrezzo a = null;
for (int i= 0; i<this.numeroAttrezzi; i++)
if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
a = attrezzi[i];

return a;
}

public int getPeso() {
int peso = 0;
for (int i= 0; i<this.numeroAttrezzi; i++)
peso += this.attrezzi[i].getPeso();

return peso;
}

public boolean isEmpty() {
return this.numeroAttrezzi == 0;
}

public boolean hasAttrezzo(String nomeAttrezzo) {
return this.getAttrezzo(nomeAttrezzo)!=null;
}

public Attrezzo removeAttrezzo(String nomeAttrezzo) {
Attrezzo a = null;
// ---> TODO (implementare questo metodo) <---
if(!isEmpty()) {
	for (int i= 0; i<this.numeroAttrezzi; i++) {
		if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
			a=this.attrezzi[i];
			this.numeroAttrezzi--;
			if(this.numeroAttrezzi>0 ) {
				for (int k=i; k<this.numeroAttrezzi-1; k++) {
					this.attrezzi[k]=this.attrezzi[k+1];
				}
				return a;
			}else {
				this.attrezzi[0]=null;
				return a;
			}
		}
	}
      
}
return a;
}

public String toString() {
StringBuilder s = new StringBuilder();

if (!this.isEmpty()) {
s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
for (int i= 0; i<this.numeroAttrezzi; i++)
s.append(attrezzi[i].toString()+" ");
}
else
s.append("Borsa vuota");
return s.toString();
}


}
