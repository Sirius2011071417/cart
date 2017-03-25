package cn.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagDemo2 extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		//显示该结束标签之后的所有jsp
//		return super.doEndTag();
		return Tag.EVAL_PAGE;
		
		//不显示
//		return Tag.SKIP_PAGE;
	}

}
