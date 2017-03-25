package cn.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo3 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();
		for(int i=1;i<10;i++) {
			jf.invoke(null);
		}
	}

}
