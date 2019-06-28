package com.samsung.android.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.mesalabs.cerberus.R;
import com.samsung.android.ui.util.SeslRoundedCornerWoStroke;

/*
 * Cerberus Core App
 *
 * Coded by BlackMesa @2019
 * Originally coded by Samsung. All rights reserved to their respective owners.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * ULTRA-MEGA-PRIVATE SOURCE CODE. SHARING TO DEVKINGS TEAM
 * EXTERNALS IS PROHIBITED AND WILL BE PUNISHED WITH ANAL ABUSE.
 */

public class RoundFrameLayoutWoStroke extends FrameLayout {
    SeslRoundedCornerWoStroke mSeslRoundedCornerWoStroke;

    public RoundFrameLayoutWoStroke(Context context) {
        super(context);
    }

    public RoundFrameLayoutWoStroke(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.RoundFrameLayoutWoStroke);
        String corners = obtainStyledAttributes.getString(R.styleable.RoundFrameLayoutWoStroke_flwsCorners);

        mSeslRoundedCornerWoStroke = new SeslRoundedCornerWoStroke(context);
        mSeslRoundedCornerWoStroke.setRoundedCorners(getCornersInt(corners));

        obtainStyledAttributes.recycle();
    }

    public RoundFrameLayoutWoStroke(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RoundFrameLayoutWoStroke(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mSeslRoundedCornerWoStroke.drawRoundedCorner(canvas);
    }

    private int getCornersInt(String cornersS) {
        int corners = 15;

        if (cornersS != null && !cornersS.isEmpty()) {
            if (!cornersS.contains("topleft"))
                corners -= 1;
            if (!cornersS.contains("topright"))
                corners -= 2;
            if (!cornersS.contains("bottomleft"))
                corners -= 4;
            if (!cornersS.contains("bottomright"))
                corners -= 8;
        }

        return corners;
    }
}
