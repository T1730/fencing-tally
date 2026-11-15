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

		this.update();
    }

	@Override
	protected void onSaveInstanceState(Bundle state) {
		state.putInt("left_score", this.left_score);
		state.putInt("right_score", this.right_score);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		this.left_score = savedInstanceState.getInt("left_score");
		this.right_score = savedInstanceState.getInt("right_score");
		this.update();
	}

	public void increment(View v) {
		switch(v.getId()) {
			case R.id.leftscore_button:
				this.left_score += 1;
				break;
			case R.id.rightscore_button:
				this.right_score += 1;
				break;
			default: break;
		}
		this.update();
	}
	
	public void update() {
		this.left_text.setText(String.valueOf(this.left_score));
		this.right_text.setText(String.valueOf(this.right_score));
	}
}
