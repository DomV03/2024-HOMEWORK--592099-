package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {

	static final private int CFU_INIZIALI = 20;
    public int cfu;
    public Borsa borsa = new Borsa();

    
    public Giocatore(){
    	this.cfu = CFU_INIZIALI;
    }
    
    public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		// TODO da implementare
	
			if(borsa.addAttrezzo(attrezzo)) {	
				
			return true;
			}
			else
			return false;

	}
	
	public boolean removeAttrezzo(String attrezzo) {
		// TODO da implementare
	        if(attrezzo!=null) {
	        
			if(borsa.removeAttrezzo(attrezzo)!=null) {	
				
			return true;
			}
			else
			return false;
	        }
	        return false;
	}
	
	public void Stampa() {
		 borsa.toString();
	}

	public boolean hasAttrezzo(String string) {
		// TODO Auto-generated method stub
		return this.hasAttrezzo(string);
	}

}
