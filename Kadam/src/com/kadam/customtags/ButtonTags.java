package com.kadam.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.kadam.util.PropertyUtil;

/**
 * This is the tag handler for button tags
 * 
 * @author t-renjith
 * 
 */
public class ButtonTags extends SimpleTagSupport {
	/**
	 * Error logger for Button tags class
	 */

	private transient String type;
	private transient String value;
	private transient String name;
	private transient String onClick;

	/**
	 * Sets the button type
	 * 
	 * @param type
	 *            - the button type attribute from the calling jsp
	 */
	public void setType(final String type) {
		this.type = type;
	}

	/**
	 * Sets the button text attribute
	 * 
	 * @param value
	 *            - The value attribute of the button.The text corresponding to
	 *            this value is to be fetched from the property files
	 */
	public void setValue(final String value) {
		this.value = value;
	}

	/**
	 * This method sets the name of the button
	 * 
	 * @param name
	 *            - name of the button
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Sets the name of the java script method whcih is to be called on the
	 * button click
	 * 
	 * @param onClick
	 *            -The javascript method name
	 * 
	 */
	public void setOnclick(final String onClick) {
		this.onClick = onClick;
	}

	public void doTag() {
		final String buttonText = PropertyUtil.getUIText(value); // Gets the text from
		// the property
		// files
		final JspWriter out = getJspContext().getOut(); // Gets the out put stream to
		// write

		try {
			if ("submit".equalsIgnoreCase(type)) { // if type is submit a submit
				// submit button is created 
				out.println("<input type='submit' value='"
						+ buttonText + "'name='" + name
						+ "' onclick='" + onClick + "'/>");
				
			} 
			/*else if ("button".equalsIgnoreCase(type)) {
				//a simple button is created
				System.out.println("in button" +onClick +"name isn"+name);
				out.println("<input type='button' value='"
						+ buttonText + "'name='" + name+ "' onclick='" + onClick + "'/>");
				
			}
			*/
			else {
				out
						.println("<input type='reset' value='"
								+ buttonText + "' name='" + name
								+ "'/>");
			}
		} catch (IOException e) {
		
		}

	}
}
