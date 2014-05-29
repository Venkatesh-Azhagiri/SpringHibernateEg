import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pretech.First;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("venkatesh.xml");

		//System.out.println("Calling Second Bean");
		//context.getBean("secondBean");
		TestService t  = (TestService)context.getBean("testService");
		try {
			t.invokeFirstClass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
