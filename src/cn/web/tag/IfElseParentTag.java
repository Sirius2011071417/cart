package cn.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfElseParentTag extends SimpleTagSupport {
	private boolean isDo = false;

	public boolean isDo() {
		return isDo;
	}

	public void setDo(boolean isDo) {
		this.isDo = isDo;
	}

	@Override
	public void doTag() throws JspException, IOException {
		this.getJspBody().invoke(null);
	}
}
