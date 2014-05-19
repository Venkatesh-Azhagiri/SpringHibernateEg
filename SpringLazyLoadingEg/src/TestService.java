import org.springframework.beans.factory.annotation.Autowired;

import com.pretech.First;
import com.pretech.Second;


public class TestService {
	@Autowired
	public First firstBean;
	
	@Autowired
	public Second secondBean;
	
	public void invokeFirstClass(){
		//firstBean.method();
	}
	
	public void invokeSecondClass(){
		
	}

}
