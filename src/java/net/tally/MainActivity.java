package net.tally;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tally_view);

		TextView left = (TextView)findViewById(R.id.leftscore_text);
		left.setText("0");

		TextView right = (TextView)findViewById(R.id.rightscore_text);
		right.setText("0");

        // TextView text = (TextView)findViewById(R.id.my_text);
        // text.setText("Hello, Fencers!");
    }
}
