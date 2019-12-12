package edu.neu.csye6200;
import java.net.URI;
import java.net.URISyntaxException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
public class Caller {
	
	public static final String ACCOUNT_SID = "ACacef95bb923c25c0f70f928c7289a068";
    public static final String AUTH_TOKEN = "ad59b22234a711980b4d141806376ccf";

	public static void demo() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String from = "+1 269 301 1089";
        String to = "+1 857-294-5709";
        //2015846351
        Call call = null;
		try {
			call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
			        new URI("http://demo.twilio.com/docs/voice.xml")).create();
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println(call.getSid());
	}
}