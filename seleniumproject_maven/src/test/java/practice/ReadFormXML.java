package practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadFormXML 
{
@Test
public void showData(XmlTest xmlobj) {
	System.out.println(xmlobj.getParameter("browser"));
	System.out.println(xmlobj.getParameter("url"));
}
}
