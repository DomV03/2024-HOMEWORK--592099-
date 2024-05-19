package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
public final static int DEFAULT_PESO_MAX_BORSA = 10;
private Map<String, Attrezzo> attrezzi;
public int numeroAttrezzi;
private int pesoMax;
private int pesoAttuale;
public Borsa() {
this(DEFAULT_PESO_MAX_BORSA);
}

public Borsa(int pesoMax) {
this.pesoMax = pesoMax;
this.attrezzi = new TreeMap<>(); 
this.numeroAttrezzi = 0;
this.pesoAttuale = 0;
}

List<Attrezzo> getContenutoOrdinatoPerPeso(){
	if(attrezzi.isEmpty())
	return null;
	else {
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(attrezzi.values());
		Collections.sort(l, new ComparatoreAttrezziPerPeso());
		return l;
	}
	
}

SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
	return new TreeSet<Attrezzo>(this.attrezzi.values());
}

Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
	Map<Integer, Set<Attrezzo>> map = new TreeMap<>();
	for(Attrezzo a : this.attrezzi.values()) {
		if(map.containsKey(a.getPeso())) {
			map.get(a.getPeso()).add(a);
		}else {
			Set<Attrezzo> s=new TreeSet<Attrezzo>();
			s.add(a);
			map.put(a.getPeso(), s);
		}
	}
	
	return map;
	
}

SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
	if(attrezzi.isEmpty())
		return null;
		else {
			SortedSet<Attrezzo> l = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
			l.addAll(attrezzi.values());
			return l;
		}
	
}

public boolean addAttrezzo(Attrezzo attrezzo) {
if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
return false;

this.attrezzi.put(attrezzo.getNome(),attrezzo);
this.numeroAttrezzi++;
this.pesoAttuale += attrezzo.getPeso();
return true;
}

public int getPesoMax() {
return pesoMax;
}


public Attrezzo getAttrezzo(String nomeAttrezzo) {
Attrezzo a = null;

if (this.attrezzi.containsKey(nomeAttrezzo))
a = attrezzi.get(nomeAttrezzo);

return a;
}

public int getPeso() {
	return this.pesoAttuale;
}

public boolean isEmpty() {
return this.numeroAttrezzi == 0;
}

public boolean hasAttrezzo(String nomeAttrezzo) {
return this.getAttrezzo(nomeAttrezzo)!=null;
}

public Attrezzo removeAttrezzo(String nomeAttrezzo) {
    Attrezzo a = null;
    if(nomeAttrezzo!=null){
		a = attrezzi.remove(nomeAttrezzo);
	}
    return a;
}

public String toString() {
StringBuilder s = new StringBuilder();

if (!this.isEmpty()) {
	s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
	s.append("\n");
	s.append(this.getContenutoOrdinatoPerPeso().toString());
	s.append("\n");
	s.append(this.getSortedSetOrdinatoPerPeso().toString());
	s.append("\n");
	s.append(this.getContenutoOrdinatoPerNome().toString());
	s.append("\n");
	s.append(this.getContenutoRaggruppatoPerPeso().toString());
}
else
s.append("Borsa vuota");
return s.toString();
}




}
