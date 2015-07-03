package dbwork;

import asia.sejong.web.eazimemo.util.ResourceUtil;

public class JavaBeanTemplate {

	public static String getBeanTemplate() {
		return ResourceUtil.read(JavaBeanTemplate.class, "BeanTemplate.txt");
	}
	
	public static String getBeanGSetterTemplate() {
		return ResourceUtil.read(JavaBeanTemplate.class, "BeanGSetterTemplate.txt");
	}
}
