import greenfoot.*;

public class SelectionSort extends Actor
{
    public Card[] ordenar(Card vetor[]) {    
        int k, l;
        Mesa table = (Mesa)getWorld();
        
        for (int i = 0; i < vetor.length - 1; i++)  
        {  
            int index = i;                
            
            for (int j = i + 1; j < vetor.length; j++){  
                if (vetor[j].getValue() < vetor[index].getValue()){  
                    index = j;
                }
            }  
            
            Card a = new Card(vetor[i].getScale()+0.08, vetor[i].getValue());
            Card b = new Card(vetor[index].getScale()+0.08, vetor[index].getValue());
            
            getWorld().addObject(a, vetor[i].getX(), vetor[i].getY());
            getWorld().addObject(b, vetor[index].getX(), vetor[index].getY());
            table.exibirCartas();
            
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
            table.exibirCartas();
        }
        
        return vetor;
    }
}
