package uts.polsys;

import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;




public class TesterHook {
	
	
	private static Polling polling;

	public static void main(String[] args) throws Exception {
		JAXBContext jc = JAXBContext.newInstance(Polling.class);
		Unmarshaller u = jc.createUnmarshaller();
		FileInputStream fin = new FileInputStream("PolSys/WebContent/WEB-INF/polling.xml");
		polling = (Polling)u.unmarshal(fin);
		fin.close();
	}
}
