public class Rutenett {
    int antRader;
    int antKolonner;
    Celle[][] rutene; 

    Rutenett(int rad, int kol){
        this.antRader = rad;
        this.antKolonner = kol;
        this.rutene = new Celle[rad][kol];
    }

    public void lagCelle(int rad, int kol){
        rutene[rad][kol] = new Celle();
        if (Math.random()<=0.3333){
            rutene[rad][kol].settLevende();
        }
    }

    public void fyllMedTilfeldigeCeller(){
        for (int rad = 0; rad < antRader; rad++){
            for (int kol = 0; kol < antKolonner; kol++){
                this.lagCelle(rad, kol);
            }
        }
    }

    public Celle hentCelle(int rad, int kol){
        if (rad >= 0 && kol >=0 && rad < this.antRader && kol < this.antKolonner){
            return rutene[rad][kol];
        }
        return null;
    }

    public void tegnRutenett(){
        for (int rad = 0; rad < this.antRader; rad++){
            System.out.println();
            System.out.println("+--+ ".repeat(this.antKolonner));
            for (int kol = 0; kol < this.antKolonner; kol++){
                System.out.print("| " + rutene[rad][kol].hentStatusTegn() +" |");
            }
         
        } 
        System.out.println();    
        System.out.println("+--+ ".repeat(this.antKolonner));           
        System.out.println();
    }

    public void settNaboer(int rad, int kol){ // sets the neightbors to each cell
        Celle cell = this.hentCelle(rad, kol);
        Celle[] naboer = new Celle[8];
        if (cell != null){
            naboer = new Celle[] {this.hentCelle(rad + 1, kol + 1), this.hentCelle(rad + 1, kol), 
            this.hentCelle(rad, kol + 1), this.hentCelle(rad - 1, kol - 1), 
            this.hentCelle(rad, kol - 1), this.hentCelle(rad - 1, kol), 
            this.hentCelle(rad + 1, kol - 1), this.hentCelle(rad - 1, kol + 1)};}
            
            for (int naboCelle = 0; naboCelle < 8; naboCelle++) {
                if (naboer[naboCelle] != null){
                    cell.leggTilNabo(naboer[naboCelle]);
                }
            } 

    }

    public void kobleAlleCeller(){     //sets all neighbors to each cell in the whole grid 
        for (int rad = 0; rad < antRader; rad++){
            for (int kol = 0; kol < antKolonner; kol++){
                this.settNaboer(rad, kol);
            }
        }        
    }

    public int antallLevende(){
        int teller = 0;
        for (int rad = 0; rad < antRader; rad++){
            for (int kol = 0; kol < antKolonner; kol++){
                Celle cell = this.hentCelle(rad, kol);
                if (cell != null && cell.erLevende()){
                    teller++ ;
                }
            }
        }
        return teller ;
    }

}
