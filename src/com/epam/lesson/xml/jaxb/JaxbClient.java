package com.epam.lesson.xml.jaxb;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.StringWriter;
import java.lang.reflect.Type;

public class JaxbClient {
    public static void main(String[] args) throws Exception {
        final JAXBContext context = JAXBContext.newInstance(
                Definition.class,
                Transition.class
        );
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        //
        final Definition definition = (Definition) unmarshaller.unmarshal(
                JaxbClient.class.getResourceAsStream("/source.xml")
        );
        System.out.println(definition);

        final Marshaller marshaller = context.createMarshaller();
        final StringWriter writer = new StringWriter();
        marshaller.marshal(definition, writer);

        System.out.println(writer.getBuffer().toString());

        final GsonBuilder builder = new GsonBuilder();
        /*
        builder.registerTypeAdapter(Class.class, new JsonSerializer<Class<?>>() {
            @Override
            public JsonElement serialize(Class<?> aClass,
                                         Type type,
                                         JsonSerializationContext jsonSerializationContext) {
                return new JsonPrimitive(
                        aClass.getName()
                );
            }
        });
        */
        builder.registerTypeAdapter(Transportable.class, new JsonDeserializer<Transportable>() {
            @Override
            public Transportable deserialize(JsonElement jsonElement,
                                             Type type,
                                             JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

                JsonObject object = (JsonObject) jsonElement;
                final String className = object.getAsJsonPrimitive("type").getAsString();
                Class<?> aClass = null;
                try {
                    aClass = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return jsonDeserializationContext.deserialize(
                        jsonElement,
                        aClass
                );
            }
        });
        builder.registerTypeAdapter(Transportable.class, new JsonSerializer<Transportable>() {
            @Override
            public JsonElement serialize(Transportable transition,
                                         Type type,
                                         JsonSerializationContext jsonSerializationContext) {
                final JsonElement element = jsonSerializationContext.serialize(
                        transition,
                        transition.getClass()
                );
                if (element instanceof JsonObject) {
                    JsonObject object = (JsonObject) element;
                    object.add(
                            "type",
                            new JsonPrimitive(
                                    transition.getClass().getName()
                            )
                    );
                }
                return element;
            }
        });
        builder.addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                final ExcludeFromJson annotation = fieldAttributes.getAnnotation(ExcludeFromJson.class);
                return annotation != null;
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        });
        builder.setPrettyPrinting();
        final Gson gson = builder.create();
        final String json = gson.toJson(definition);

        System.out.println(json);

        final Definition newDefinition = gson.fromJson(json, Definition.class);
        System.out.println(newDefinition);
    }
}
