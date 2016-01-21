package com.honestme.animetasteex.util;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2015/11/2 0002.
 */
public class OverlayImageView extends ImageView {
    public OverlayImageView(Context context){
        super(context);
    }

    public OverlayImageView(Context context,AttributeSet attributeSet){
        super(context,attributeSet);
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);

        if(pressed){
            getDrawable().setColorFilter(0x44000000, PorterDuff.Mode.SRC_ATOP);
            invalidate();
        }else {
            getDrawable().clearColorFilter();
            invalidate();
        }
    }
}
