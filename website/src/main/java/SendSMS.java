/*
import com.clockworksms.ClockWorkSmsService;
import com.clockworksms.ClockworkException;
import com.clockworksms.ClockworkSmsResult;
import com.clockworksms.SMS;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean (name = "sendSMS")
@RequestScoped
public class SendSMS implements Serializable {
	private Long number;
	private String name;

	public Long getNumber () {
		return number;
	}

	public void setNumber (Long number) {
		this.number = number;
	}

	public String getName () {
		return name;
	}



	public void setName (String name) {
		this.name = name;
	}

//	public String sendSMStest () {
//		try {
//			ClockWorkSmsService clockWorkSmsService = new ClockWorkSmsService("APIKEY");
//			SMS sms = new SMS(number.toString(), "Hello " + name + ", welcome to ITVM! Your password is CAVf3k");
//			sms.setFrom("ITVM Inc.");
//			ClockworkSmsResult result = clockWorkSmsService.send(sms);
//
//			if (result.isSuccess()) {
//				System.out.println("Sent with ID: " + result.getId());
//			} else {
//				System.out.println("Error: " + result.getErrorMessage());
//			}
//		} catch (ClockworkException e) {
//			e.printStackTrace();
//		}
//		return "sms";
//	}
}*/
