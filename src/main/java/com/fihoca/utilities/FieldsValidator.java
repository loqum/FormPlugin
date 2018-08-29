package com.fihoca.utilities;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.fihoca.utilities.FieldsValidator")
public class FieldsValidator implements Validator {

	public FieldsValidator() {

	}

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		if (value.equals(null)) {

			FacesMessage msg = new FacesMessage();
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}

}
