package cn.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagAttributeDemo1 extends SimpleTagSupport {
	private int count;

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();
		for(int i=0;i<count;i++) {
			jf.invoke(null);
		}
	}

}
