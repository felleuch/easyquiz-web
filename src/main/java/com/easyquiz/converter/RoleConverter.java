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

@FacesConverter(value = "roleConverter")
public class RoleConverter implements Converter {

    private static Map<Object, String> roles = new WeakHashMap<Object, String>();

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object entity) {
        synchronized (roles) {
            if (!roles.containsKey(entity)) {
                String uuid = UUID.randomUUID().toString();
                roles.put(entity, uuid);
                return uuid;
            } else {
                return roles.get(entity);
            }
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String uuid) {
        for (Entry<Object, String> entry : roles.entrySet()) {
            if (entry.getValue().equals(uuid)) {
                return entry.getKey();
            }
        }
        return null;
    }

}