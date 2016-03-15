/**
 * Created by user on 15.03.2016.
 */
public class Pen {
    private int inkContainerValue;
    private double sizeLetter;
    private String color;

    public Pen(int inkContainerValue) {
        this.inkContainerValue = 1000;
        this.sizeLetter = 1.0D;
        this.color = "BLUE";
        this.inkContainerValue = inkContainerValue;
    }

    public Pen(int inkContainerValue, double sizeLetter) {
        this(inkContainerValue);
        this.sizeLetter = sizeLetter;
    }

    public Pen(int inkContainerValue, double sizeLetter, String color) {
        this(inkContainerValue, sizeLetter);
        this.color = color;
    }

    public String write(String word) {
        if(!this.isWork().booleanValue()) {
            return "";
        } else {
            double sizeOfWord = (double)word.length() * this.sizeLetter;
            if(sizeOfWord <= (double)this.inkContainerValue) {
                this.inkContainerValue = (int)((double)this.inkContainerValue - sizeOfWord);
                return word;
            } else {
                String partOfWord = word.substring(0, this.inkContainerValue);
                this.inkContainerValue = 0;
                return partOfWord;
            }
        }
    }

    public String getColor() {
        return "BLUE";
    }

    public Boolean isWork() {
        return Boolean.valueOf(this.inkContainerValue > 0);
    }

    public void doSomethingElse() {
        System.out.println(this.color);
    }
}
