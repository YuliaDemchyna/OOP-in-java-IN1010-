public class Verden {
    Rutenett rutenett;
    int genNr;
    int antRader;
    int antKolonner;

    Verden(int rad, int kol){
        rutenett = new Rutenett(rad, kol);
        genNr = 0;
        this.rutenett.fyllMedTilfeldigeCeller();
        antRader = rad;
        antKolonner = kol;
    }

    public void tegn(){
        this.rutenett.tegnRutenett();
        System.out.println("Generation number: " + genNr);
        System.out.println("Number of alive cells: " + this.rutenett.antallLevende());
    }

    public void oppdatering() {
        this.rutenett.kobleAlleCeller(); 
        for (int rad = 0; rad < this.antRader; rad++) {
            for (int kol = 0; kol < this.antKolonner; kol++) {
                Celle celle = this.rutenett.hentCelle(rad, kol);
                celle.tellLevendeNaboer(); 
            }
        }
    
        for (int rad = 0; rad < this.antRader; rad++) {
            for (int kol = 0; kol < this.antKolonner; kol++) {
                Celle celle = this.rutenett.hentCelle(rad, kol);
                celle.oppdaterStatus(); 
            }
        }
    
        this.genNr++; 
    }
    


}
