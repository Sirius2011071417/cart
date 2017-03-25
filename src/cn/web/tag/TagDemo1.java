package cn.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagDemo1 extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		//显示标签体
		return Tag.EVAL_BODY_INCLUDE;
		
		//不显示标签体,等价return super.doStartTag();		
//		return Tag.SKIP_BODY;
	}
}
