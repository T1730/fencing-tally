package net.tally;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {

	public TextView left_text;
	public Button left_button;
	public int left_score = 0;

	public TextView right_text;
	public Button right_button;
	public int right_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tally_view);

		this.left_text = (TextView)findViewById(R.id.leftscore_text);
		this.left_button = (Button)findViewById(R.id.leftscore_button);

		this.right_text = (TextView)findViewById(R.id.rightscore_text);
		this.right_button = (Button)findViewById(R.id.rightscore_button);
    }

	public void increment(View v) {
		switch(v.getId()) {
			case R.id.leftscore_button:
				this.left_score += 1;
				this.left_text.setText(String.valueOf(this.left_score));
				break;
			case R.id.rightscore_button:
				this.right_score += 1;
				this.right_text.setText(String.valueOf(this.right_score));
				break;
			default: break;
		}
	}
}
