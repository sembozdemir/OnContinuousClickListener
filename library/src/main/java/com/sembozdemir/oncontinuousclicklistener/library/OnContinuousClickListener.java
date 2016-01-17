package com.sembozdemir.oncontinuousclicklistener.library;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by semihb on 15.01.2016.
 */
public abstract class OnContinuousClickListener implements View.OnLongClickListener {
    private static final int WHAT = 12345;
    private final int delay;
    private final Handler handler;

    public OnContinuousClickListener(int delay) {
        this.delay = delay;
        handler = new Handler();

    }

    public OnContinuousClickListener() {
        delay = 500; // default delay value
        handler = new Handler();
    }

    @Override
    public boolean onLongClick(final View v) {
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    handler.removeMessages(WHAT);
                }
                return false;
            }
        });

        handler.post(new Runnable() {
            @Override
            public void run() {
                // v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                onContinuousClick(v);

                Message message = Message.obtain(handler, this);
                message.what = WHAT;
                handler.sendMessageDelayed(message, delay);
            }
        });
        return true;
    }

    public abstract void onContinuousClick(View v);
}
