package net.tally;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

public class Stopwatch {

	private Chronometer chronometer;
    private boolean running = false;
	private long stopped_at = 0;

    public Stopwatch(Chronometer meter) {
		this.chronometer = meter;
		this.stopped_at = SystemClock.elapsedRealtime();
    }

	public void onSaveInstanceState(Bundle state) {
		state.putBoolean("running", this.running);
		state.putLong("stopped_at", this.stopped_at);
	}

	public void onRestoreInstanceState(Bundle savedInstanceState) {
		this.running = savedInstanceState.getBoolean("running");
		this.stopped_at = savedInstanceState.getLong("stopped_at");
	}

    public boolean running() {
        return this.running;
    }

    public void start() {
		// add time the clock was stopped for to base
		long base = this.chronometer.getBase();
		base += SystemClock.elapsedRealtime() - this.stopped_at;
		this.chronometer.setBase(base);
        this.chronometer.start();
        this.running = true;
    }

    public void stop() {
        this.chronometer.stop();
		this.stopped_at = SystemClock.elapsedRealtime();
        this.running = false;
    }

	public void toggle() {
		if (this.running) {
			this.stop();
		} else {
			this.start();
		}
	}
}

