import greenfoot.*;

public class MisturarCartas extends Actor
{
    public int[] misturar() {
        int[] numeros = new int[52];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i+1;
        }
        
        for (int i = 0; i < numeros.length; i++) {
            int j = (int)(Math.random() * numeros.length);
            int temp = numeros[j];
            numeros[j] = numeros[i];
            numeros[i] = temp;
        }
        
        return numeros;
    }
}