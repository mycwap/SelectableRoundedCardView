package ie.miao.yichong.diycardview.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import ie.miao.yichong.diycardview.R;

/**
 * Author:   yichongmiao
 * CreateAt: 27/01/2018.
 */

public class RoundedLinearLayout extends LinearLayout {


    private boolean[]roundedCorner;
    private  float radius;

    public RoundedLinearLayout(Context context) {

        super(context);
        initialize(context, null, 0);
    }

    public RoundedLinearLayout(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        initialize(context, attrs, 0);

    }

    public RoundedLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path clipPath = new Path();


        //float radii=70f;
        float[] corners = new float[8];
        int i = 0;
        for (boolean r : roundedCorner) {
            if (r) {

                corners[i++] = radius;


                corners[i++] = radius;

            } else {

                corners[i++] = 0;
                corners[i++] = 0;
            }
        }


                //1 2
        //3 4
        clipPath.addRoundRect(new RectF(canvas.getClipBounds()), corners, Path.Direction.CW);


        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }


    private void initialize(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DIYRoundedCardView, defStyleAttr,
                R.style.CardView);


        radius = a.getDimension(R.styleable.DIYRoundedCardView_cardCornerRadius, 0);

        boolean leftTop = a.getBoolean(R.styleable.DIYRoundedCardView_DIYLeftTopCorner, true);
        boolean rightBottom = a.getBoolean(R.styleable.DIYRoundedCardView_DIYRightBottomCorner, true);
        boolean leftBottom = a.getBoolean(R.styleable.DIYRoundedCardView_DIYLeftBottomCorner, true);
        boolean rightTop = a.getBoolean(R.styleable.DIYRoundedCardView_DIYRightTopCorner, true);


        roundedCorner= new boolean[]{leftTop, rightTop, leftBottom, rightBottom};

        a.recycle();


    }

}
