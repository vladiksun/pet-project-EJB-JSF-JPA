package com.testTask.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Base class for controller objects.
 * 
 * @author Vladislav Bondarchuk
 * 
 */
public abstract class AbstractController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4862069600034765532L;

	protected transient Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Adds a global error message to the response.
	 * 
	 * @param summary
	 * The message summary.
	 */
	protected void addErrorMessage(String summary) {
		FacesMessage msg = new FacesMessage(summary);
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

        /**
	 * Adds a message. As a message uses strings from resource bundle.
	 * 
	 * @param str
	 * The message summary.
	 */
        protected void addInfoMessage(String str) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
		String message = bundle.getString(str);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
	}

}
