import javax.xml.bind.annotation.XmlAttribute;

public class Precio {
    private int eu;
    private int usa;

    @XmlAttribute(name="EU")
    public int getEu() {
        return eu;
    }

    public void setEu(int eu) {
        this.eu = eu;
    }

    @XmlAttribute(name="USA")
    public int getUsa() {
        return usa;
    }

    public void setUsa(int usa) {
        this.usa = usa;
    }
}
