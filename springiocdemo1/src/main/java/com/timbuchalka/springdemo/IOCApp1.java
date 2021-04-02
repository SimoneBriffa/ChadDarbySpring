package com.timbuchalka.springdemo;
import org.springframework.context.*;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCApp1 {

	public static void main(String[] args) {
		// create application context (container)
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		
		Organization org = (Organization) ctx.getBean("myorg");
		
		org.corporateSlogan();
		
		((FileSystemXmlApplicationContext) ctx).close();
		
		
		/*Il contenitore Spring IoC è un componente di Spring framework
		 * che contiene i beans e si occupa del loro ciclo vitale.
		 * L'interfaccia ApplicationContext rappresenta IoC ed è responsabile
		 * per la sua istanza e per la configurazione e assemblaggio dei beans.
		 * Per fare ciò legge le configurazioni dal file XML
		 */
	}

}
