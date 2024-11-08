package com.bugisoft;
import javax.xml.bind.annotation.XmlAttribute;

public class Precio {
    private float eu;
    private float usa;

    @XmlAttribute(name="EU")
    public float getEu() {
        return eu;
    }

    public void setEu(float eu) {
        this.eu = eu;
    }

    @XmlAttribute(name="USA")
    public float getUsa() {
        return usa;
    }

    public void setUsa(float usa) {
        this.usa = usa;
    }
}
