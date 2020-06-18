import greenfoot.*;

public class Card extends Actor
{
    private int width;
    private int height;
    private String cardName;
    private int value;
    private double scale;
    
    public Card() {
        width = this.getImage().getWidth();
        height = this.getImage().getHeight();
        this.getImage().scale((int)(0.4 * width) , (int)(0.4 * height));   
    }
    
    public Card(double _scale, int _value){
        this.value = _value;
        this.scale = _scale;
        String path = "images/";
        cardName = _value+".png";
        this.setImage(path+cardName);
        width = this.getImage().getWidth();
        height = this.getImage().getHeight();
        this.getImage().scale((int)(_scale * width) , (int)(_scale * height));        
    }
    
    public int getValue() {
        return this.value;
    }
    
    public double getScale() {
        return this.scale;
    }
}