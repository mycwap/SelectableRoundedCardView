package ie.miao.yichong.mCardview;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.github.captain_miao.optroundcardview.OptRoundCardView;

import ie.miao.yichong.diycardview.view.DIYRoundedCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DIYRoundedCardView diyRoundedCardView=findViewById(R.id.card);
        OptRoundCardView diyRoundedCardView2=findViewById(R.id.card2);

        ImageView ImageView=findViewById(R.id.special_category_image1);

        ImageView diyRoundedCardView211=findViewById(R.id.special_category_image123);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            diyRoundedCardView211.setClipToOutline(true);
            ImageView.setClipToOutline(true);
        }
        diyRoundedCardView2.setPreventCornerOverlap(true);

    }
}
