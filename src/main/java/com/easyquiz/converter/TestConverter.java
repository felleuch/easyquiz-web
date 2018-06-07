package com.easyquiz.converter;

/**
 * Created by felleuch on 30/01/2018.
 */
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.WeakHashMap;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "testConverter")
public class TestConverter implements Converter {

    private static Map<Object, String> tests = new WeakHashMap<Object, String>();

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object entity) {
        synchronized (tests) {
            if (!tests.containsKey(entity)) {
                String uuid = UUID.randomUUID().toString();
                tests.put(entity, uuid);
                return uuid;
            } else {
                return tests.get(entity);
            }
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String uuid) {
        for (Entry<Object, String> entry : tests.entrySet()) {
            if (entry.getValue().equals(uuid)) {
                return entry.getKey();
            }
        }
        return null;
    }

}