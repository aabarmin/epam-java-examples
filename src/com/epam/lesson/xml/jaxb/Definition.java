package com.epam.lesson.xml.jaxb;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "definition")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class Definition {
    @XmlAttribute
    private String startEvent;
    @XmlAttribute
    private String startState;
    // @Expose(serialize = false, deserialize = false)
    @ExcludeFromJson
    @XmlAttribute(name = "handler")
    @XmlJavaTypeAdapter(JavaXmlClassTypeAdapter.class)
    private Class<?> handlerClass;
    // @XmlElement(name = "transition")
    @XmlElements({
            @XmlElement(type = Transition.class, name = "transition"),
            @XmlElement(type = Transport.class, name = "transport")
    })
    @XmlElementWrapper(name = "transitions")
    private Collection<Transportable> transitions = new ArrayList<>();

    public Collection<Transportable> getTransitions() {
        return transitions;
    }

    public void setTransitions(Collection<Transportable> transitions) {
        this.transitions = transitions;
    }

    public String getStartEvent() {
        return startEvent;
    }

    public void setStartEvent(String startEvent) {
        this.startEvent = startEvent;
    }

    public String getStartState() {
        return startState;
    }

    public void setStartState(String startState) {
        this.startState = startState;
    }

    public Class<?> getHandlerClass() {
        return handlerClass;
    }

    public void setHandlerClass(Class<?> handlerClass) {
        this.handlerClass = handlerClass;
    }

    @Override
    public String toString() {
        return "Definition{" +
                "startEvent='" + startEvent + '\'' + "\n" +
                ", startState='" + startState + '\'' + "\n" +
                ", handlerClass=" + handlerClass + "\n" +
                ", transitions=" + transitions + "\n" +
                '}';
    }
}
