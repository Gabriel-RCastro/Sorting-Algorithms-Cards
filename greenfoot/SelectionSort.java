
import greenfoot.*;

public class SelectionSort extends Actor
{
    public Card[] ordenar(Card vetor[]) {    
        int k, l;
        Mesa table = (Mesa)getWorld();
        
        for (int i = 0; i < vetor.length - 1; i++)  
        {  
            int index = i;          
            
            Card a = new Card(vetor[i].getScale()+0.09, vetor[i].getValue()); 
            getWorld().addObject(a, vetor[i].getX(), vetor[i].getY());
            table.exibirUmaCarta(a);
            
            Card b = new Card(1,1);
            Card c = new Card(1,1);
            
            for (int j = i + 1; j < vetor.length; j++) {  
                b = new Card(vetor[j].getScale()+0.09, vetor[j].getValue());

                getWorld().addObject(b, vetor[j].getX(), vetor[j].getY());
                table.exibirUmaCarta(b);
                
                getWorld().removeObject(b);
                
                b = new Card(vetor[j].getScale(), vetor[j].getValue());
                
                getWorld().addObject(b, vetor[j].getX(), vetor[j].getY());
                table.exibirUmaCarta(b);
                
                if (vetor[j].getValue() < vetor[index].getValue()){  
                    index = j;
                    
                    getWorld().removeObject(c);
                    
                    c = new Card(vetor[index].getScale()+0.09, vetor[index].getValue());
                    getWorld().addObject(c, vetor[index].getX(), vetor[index].getY());
                    table.exibirUmaCarta(c);
                }
            }     
            getWorld().removeObject(c);
            
            //Troca
            Card maiorNumero = vetor[index];   
            vetor[index] = vetor[i];  
            vetor[i] = maiorNumero;
            
            k = vetor[index].getX();
            l = vetor[index].getY();
            vetor[index].setLocation(vetor[i].getX(), vetor[i].getY());
            vetor[i].setLocation(k, l);
            
            getWorld().removeObject(a);
            getWorld().removeObject(b);
            
            a = new Card(vetor[i].getScale(), vetor[i].getValue());
            b = new Card(vetor[index].getScale(), vetor[index].getValue());
            
            getWorld().addObject(a, vetor[i].getX(), vetor[i].getY());
            getWorld().addObject(b, vetor[index].getX(), vetor[index].getY());
            
            table.exibirUmaCarta(a);
            table.exibirUmaCarta(b);
        }
      
        return vetor;
    }
}
