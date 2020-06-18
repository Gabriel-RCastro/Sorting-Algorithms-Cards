import greenfoot.*;

public class InsertionSort extends Actor
{
    public Card[] ordenar(Card vetor[]) {    
        int k, l;
        Mesa table = (Mesa)getWorld();
        
        for (int i = 0; i < vetor.length; i++) {
            Card aux = vetor[i]; 
            for (int j = i - 1; j >= 0 && vetor[j].getValue() > aux.getValue(); j--) {
                Card a = new Card(vetor[j].getScale()+0.08, vetor[j].getValue());
                Card b = new Card(vetor[j+1].getScale()+0.08, vetor[j+1].getValue());
                
                getWorld().addObject(a, vetor[j].getX(), vetor[j].getY());
                getWorld().addObject(b, vetor[j+1].getX(), vetor[j+1].getY());
                table.exibirCartas();
                
                //Troca
                vetor[j + 1] = vetor[j];
                vetor[j] = aux;
                
                k = vetor[j+1].getX();
                l = vetor[j+1].getY();
                vetor[j+1].setLocation(vetor[j].getX(), vetor[j].getY());
                vetor[j].setLocation(k, l);
                
                getWorld().removeObject(a);
                getWorld().removeObject(b);
                
                a = new Card(vetor[j].getScale(), vetor[j].getValue());
                b = new Card(vetor[j+1].getScale(), vetor[j+1].getValue());
                
                getWorld().addObject(a, vetor[j].getX(), vetor[j].getY());
                getWorld().addObject(b, vetor[j+1].getX(), vetor[j+1].getY());
                table.exibirCartas();
            }
        } 

        return vetor;
    }
}
