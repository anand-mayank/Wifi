package wifi.wifi;

import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity  {
	Switch sw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sw=(Switch)findViewById(R.id.switch1);
		
		sw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean status) {
				// TODO Auto-generated method stub
				if(status)
				{
					mywifienable(true);
					Toast.makeText(getApplicationContext(),"wifi on",Toast.LENGTH_LONG).show();
				}
				else
				{
					mywifienable(false);
					Toast.makeText(getApplicationContext(),"wifi off",Toast.LENGTH_LONG).show();
				}
			}
		});
		
		
	}

	public void mywifienable(boolean b) {
		// TODO Auto-generated method stub
		WifiManager wifi=(WifiManager)getSystemService(Context.WIFI_SERVICE);
		if((b==true)&&!(wifi.isWifiEnabled()))
		{
			wifi.setWifiEnabled(true);
			
		}
		else if((b==false)&&(wifi.isWifiEnabled()))
		{
			wifi.setWifiEnabled(false);
		}
		
	}

	

}
