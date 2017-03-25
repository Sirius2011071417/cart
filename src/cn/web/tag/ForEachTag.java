package cn.web.tag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;



public class ForEachTag extends SimpleTagSupport {
	private Object items;
	private String var;
	private Collection collection;
	public void setItems(Object items) {
		this.items = items;
		if(items instanceof Map) {
			collection = ((Map)items).entrySet();
		} else if(items instanceof Collection) {
			collection = (Collection) items;
		} else if(items instanceof Object[]) {
			collection = Arrays.asList((Object[])items);
		} else if(items.getClass().isArray()) {
			collection = new ArrayList();
			int length = Array.getLength(items);
			for(int i=0;i<length;i++) {
				collection.add(Array.get(items, i));
			}
		}
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public void doTag() throws JspException, IOException {
		Iterator iterator = collection.iterator();
		while(iterator.hasNext()) {
			this.getJspContext().setAttribute(var, iterator.next());
			this.getJspBody().invoke(null);
		}
	}
}
