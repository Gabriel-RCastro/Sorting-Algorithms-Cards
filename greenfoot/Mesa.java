import greenfoot.*;

public class Mesa extends World
{
    public Card[] cards = new Card[52];
    
    BubbleSort bubble = new BubbleSort();
    InsertionSort insertion = new InsertionSort();
    SelectionSort selection = new SelectionSort();
    MisturarCartas misturarCartas = new MisturarCartas();
    
    public Mesa() {   
        super(1100, 580, 1);
        criarCartas();
        exibirCartas();
        criarBotoes();
    }
    
    public void act() {
        if (cards[0].getValue() != 0) {
            if (Greenfoot.mouseClicked(bubble)) {
                cards = bubble.ordenar(cards);
            }
            if (Greenfoot.mouseClicked(insertion)) {
                cards = insertion.ordenar(cards);
            }
            if (Greenfoot.mouseClicked(selection)) {
                cards = selection.ordenar(cards);
            }
        }
        if (Greenfoot.mouseClicked(misturarCartas)) {
            criarCartas(misturarCartas.misturar());
            exibirCartas();
        }
    }
    
    public void criarCartas() {
        for (int x = 0; x < cards.length; x++) {
            cards[x] = new Card();
        }
    }
    public void criarCartas(int vetor[]) {
        for (int x = 0; x < vetor.length; x++) {
            cards[x] = new Card(0.4, vetor[x]);
        }
    }
    
    public void exibirCartas() {
        int posicaoY = 150, x = 0;
        while (x < 52) {
            for (int j = 0; j < 13; j++) {
                addObject(cards[x++], (70 * (j+2)), posicaoY);
                repaint();
            }
            posicaoY += 100;
        }
    }
    
    private void criarBotoes() {
        addObject(bubble, 190, 53);
        addObject(insertion, 360, 53);
        addObject(selection, 535, 53);
        addObject(misturarCartas, 915, 53);
    }
    
    public void exibirUmaCarta(Card c) {
        addObject(c, c.getX(), c.getY());
        Greenfoot.delay(2);
    }
}
