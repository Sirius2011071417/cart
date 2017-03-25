package cn.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfElseTag2 extends SimpleTagSupport {
	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		IfElseParentTag parent= (IfElseParentTag) this.getParent();
		if(test && !parent.isDo()) {
			this.getJspBody().invoke(null);
			parent.setDo(true);
		}
	}
}
