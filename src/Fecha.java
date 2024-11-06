import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="fecha")
@XmlType(propOrder={"anyo", "mes", "dia"})
public class Fecha {
    private int anyo;
    private int mes;
    private int dia;

    @XmlAttribute(name="anyo")
    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    @XmlAttribute(name="mes")
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @XmlAttribute(name="dia")
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}
