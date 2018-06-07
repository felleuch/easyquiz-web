package com.easyquiz.converter;


import com.easyquiz.controller.DashBoardController;
import com.easyquiz.controller.TestCreationController;
import com.easyquiz.model.Categorie;
import com.easyquiz.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by felleuch on 23/01/2018.
 */


@FacesConverter(value = "categorieConverter")
public class CategorieCoverter implements Converter {




    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {


        FacesContext facesContext = FacesContext.getCurrentInstance();
        TestCreationController testCreationController = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{testCreationController}", TestCreationController.class);

        try {
            Integer parsedValue = Integer.parseInt(value);

            if (parsedValue <= 0) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "The id cannot be zero or negative."));
            }
            Categorie categorie=null;
            for(Categorie c:testCreationController.getAllCategories()){
                if(c.getId().intValue()==parsedValue.intValue()){
                    categorie=c;
                }
            }



            if (categorie == null) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_WARN, "", "The supplied id doesn't exist."));
            }

            return categorie;
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Conversion error : Incorrect id."), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value instanceof Categorie ? ((Categorie) value).getId().toString() : "";
    }




}
