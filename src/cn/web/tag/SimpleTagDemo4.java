package cn.web.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo4 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment  df = this.getJspBody();
		StringWriter sw = new StringWriter();
		df.invoke(sw);
		
		String content = sw.toString().toUpperCase();
		this.getJspContext().getOut().write(content);
	}
}
