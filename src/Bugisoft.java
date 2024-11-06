import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement(name="STEAM")
@XmlType(propOrder={"juegos"})
public class Bugisoft {
    private ArrayList<Juego> juegos = new ArrayList<>();

    @XmlElementWrapper(name="juegos")
    @XmlElement(name = "juego")
    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<Juego> juegos) {
        this.juegos = juegos;
    }
}
