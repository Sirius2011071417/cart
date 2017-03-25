package cn.web.tag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagAttributeDemo2 extends SimpleTagSupport {
	private Date date;

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().write(date.toString());
	}
	
}
