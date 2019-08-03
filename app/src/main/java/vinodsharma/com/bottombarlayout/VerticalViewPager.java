package vinodsharma.com.bottombarlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VerticalViewPager extends ViewPager {

    public VerticalViewPager(@NonNull Context context) {
        super(context);
        init();

    }

    public VerticalViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public  void init()
    {
        setPageTransformer(true,new ViewPagerTransform());
        setOverScrollMode(OVER_SCROLL_NEVER); // this gives bounce effetc when scrolls up and down

    }

    private MotionEvent SwapXY(MotionEvent event)
    {
        float X=getWidth();
        float y=getHeight();

        float newx=(event.getY()/y)*y;
        float newy= (event.getX()/X)*X;
        event.setLocation(newx,newy);
        return event;

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        boolean intercept=super.onInterceptTouchEvent(ev);
        return intercept ;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    public class ViewPagerTransform implements ViewPager.PageTransformer{
  public static  final float MIN_SCALE=0;
        @Override
        public void transformPage(@NonNull View page, float position) {
                    if (position<-1)
                    {
                        page.setAlpha(0);
                    }
                    else if (position<=0)
                    {
                        page.setTranslationX(page.getWidth()*-position);
                        page.setTranslationY(page.getHeight()*position);
                        page.setScaleX(1);
                        page.setScaleY(1);
                    }
                    else if (position<=0)
                    {
                    page.setAlpha(1-position);
                    page.setTranslationX(page.getWidth()*-position);
                    page.setTranslationY(0);

                    float scaleFactor=MIN_SCALE+(1-MIN_SCALE)*(1-Math.abs(position));
                    page.setScaleY(scaleFactor);
                    page.setScaleY(scaleFactor);
                    }
                    else  if (position>1)
                    {
                       page.setAlpha(0);
                    }
        }
    }
}
