import greenfoot.*;

public class BubbleSort extends Actor
{   
     public Card[] ordenar(Card vetor[]) {
        int k, l;
        Card aux;
        Mesa table = (Mesa)getWorld();
        
        for (int i = vetor.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {                
                Card a = new Card(vetor[j].getScale()+0.09, vetor[j].getValue());
                Card b = new Card(vetor[j+1].getScale()+0.09, vetor[j+1].getValue());
                
                getWorld().addObject(a, vetor[j].getX(), vetor[j].getY());
                getWorld().addObject(b, vetor[j+1].getX(), vetor[j+1].getY());
                table.exibirUmaCarta(a);
                table.exibirUmaCarta(b);
                
                //Troca
                if (vetor[j].getValue() > vetor[j + 1].getValue()) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    
                    k = vetor[j+1].getX();
                    l = vetor[j+1].getY();
                    vetor[j+1].setLocation(vetor[j].getX(), vetor[j].getY());
                    vetor[j].setLocation(k, l);
                }
                
                getWorld().removeObject(a);
                getWorld().removeObject(b);
                
                a = new Card(vetor[j].getScale(), vetor[j].getValue());
                b = new Card(vetor[j+1].getScale(), vetor[j+1].getValue());
                
                getWorld().addObject(a, vetor[j].getX(), vetor[j].getY());
                getWorld().addObject(b, vetor[j+1].getX(), vetor[j+1].getY());
                table.exibirUmaCarta(a);
                table.exibirUmaCarta(b);
            }
        }
        
        return vetor;
     }    
}