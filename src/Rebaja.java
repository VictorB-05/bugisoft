import javax.xml.bind.annotation.XmlAttribute;

public class Rebaja {
    private int descuento;

    @XmlAttribute(name="descuento")
    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
