package com.epam.lesson.xml.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "transition")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transition implements Transportable {
    @XmlAttribute
    private String from;
    @XmlAttribute
    private String to;
    @XmlAttribute
    private String on;
    @XmlAttribute
    private String call;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", on='" + on + '\'' +
                ", call='" + call + '\'' +
                '}';
    }
}
