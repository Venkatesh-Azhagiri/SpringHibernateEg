import org.springframework.beans.factory.annotation.Autowired;

import com.pretech.First;
import com.pretech.Second;


public class TestService {
	@Autowired
	First firstBean;
	
	@Autowired
	public Second secondBean;
	
	
	public void invokeFirstClass() throws Exception{
		System.out.println("test invokeFirst class***"+firstBean);
		firstBean.method();
		//throw new Exception();
	}
	
	public void invokeSecondClass(){
		
	}

}
