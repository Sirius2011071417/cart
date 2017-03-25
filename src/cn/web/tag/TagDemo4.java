package cn.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TagDemo4 extends BodyTagSupport {

	@Override
	public int doStartTag() throws JspException {
		return BodyTag.EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doEndTag() throws JspException {
		BodyContent bc = this.getBodyContent();
		String str = bc.getString().toUpperCase();
		try {
			this.pageContext.getOut().write(str);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.doEndTag();
	}
}
