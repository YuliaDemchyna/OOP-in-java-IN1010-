public class Celle {

    boolean levende ;      // default is false (not Boolean!)
    Celle[] naboer ; 
    int antNaboer ;
    int antLevendeNaboer ;


    public Celle(){
        this.levende = false; // not necessary if writen on line three
        this.naboer = new Celle[8]; //neccesary
        this.antNaboer = 0;     // good practice to set these this way for readibility?
        this.antLevendeNaboer = 0;
        
    }
    
    public void settDoed(){
        this.levende = false;
    }

    public void settLevende(){
        this.levende = true;
    }

    public boolean erLevende(){
        return this.levende;
    }

    public char hentStatusTegn(){
        if (this.levende){
            return 'O';
        } else {
            return '.';
        }
    }

    public void leggTilNabo(Celle nabo) {
        if (antNaboer < naboer.length) {  // antNaboer must always be under 8
            naboer[antNaboer] = nabo;
            antNaboer++;
        } 
    }

    public void tellLevendeNaboer() {
        this.antLevendeNaboer = 0;
        for (int i = 0; i < naboer.length; i++) {
            Celle currentCelle = naboer[i];
            if (currentCelle != (null)){
                if (currentCelle.erLevende()) {
                    this.antLevendeNaboer++ ;
                }  
            }
        }
    }

    public void oppdaterStatus() {
        if (this.levende){ 
            this.levende = (this.antLevendeNaboer == 3 || this.antLevendeNaboer == 2);  
            // if neither are true will the cell die
        } else {
                this.levende = (this.antLevendeNaboer == 3);
                // same here, if the statement in brackets is true -> cells status true
            }
        }
    

}

