package com.ios7jbpro.gputuner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;

public class MainActivity extends AppCompatActivity {
	
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private TextView textview1;
	private LinearLayout linear1;
	private Button button1;
	private Button button2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private TextView textview2;
	private TextView textview3;
	private ImageView imageview1;
	private ImageView imageview2;
	private TextView textview4;
	private Button button3;
	
	private Intent jx = new Intent();
	private SharedPreferences rem;
	private Intent jxm = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview4 = (TextView) findViewById(R.id.textview4);
		button3 = (Button) findViewById(R.id.button3);
		rem = getSharedPreferences("rem", Activity.MODE_PRIVATE);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				String[] cmdline = { "sh", "-c", "su -c \"settings put global GPUTUNER_SWITCH true\"" }; 
								try {
										Runtime.getRuntime().exec(cmdline);
					           
								} catch (Exception s) {					
										finishAffinity();
								}
				rem.edit().putString("rem", "enable").commit();
				SketchwareUtil.showMessage(getApplicationContext(), "Saved. The app will enable it automatically every boot.");
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				String[] cmdline = { "sh", "-c", "su -c \"settings put global GPUTUNER_SWITCH false\"" }; 
								try {
										Runtime.getRuntime().exec(cmdline);
					           
								} catch (Exception s) {					
										finishAffinity();
								}
				rem.edit().putString("rem", "disable").commit();
				SketchwareUtil.showMessage(getApplicationContext(), "Saved. The app will automatically disable every reboot.");
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				jxm.setAction(Intent.ACTION_VIEW);
				jxm.setData(Uri.parse("https://t.me/Nuiwios_projects"));
				startActivity(jxm);
			}
		});
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =MainActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFFFFFFFF);
		}
		_rippleRoundStroke(button1, "#2196F3", "#FFFFFF", 15, 0, "#000000");
		_rippleRoundStroke(button2, "#2196F3", "#FFFFFF", 15, 0, "#000000");
		_rippleRoundStroke(button3, "#2196F3", "#FFFFFF", 15, 0, "#000000");
		_rippleRoundStroke(linear3, "#F44336", "#FFFFFF", 15, 0, "#000000");
		_rippleRoundStroke(linear4, "#FFEB3B", "#FFFFFF", 15, 0, "#000000");
		jx.setClass(getApplicationContext(), ThanksActivity.class);
		startActivity(jx);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}