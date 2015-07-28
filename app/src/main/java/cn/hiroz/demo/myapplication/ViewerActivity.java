package cn.hiroz.demo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by hiro on 7/27/15.
 */
public class ViewerActivity extends AppCompatActivity {

    public static void launch(AppCompatActivity activity, View transitionView, int resId) {
        Intent intent = new Intent(activity, ViewerActivity.class);
        intent.putExtra("resId", resId);

        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity, transitionView, "image");

        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewer);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(getIntent().getIntExtra("resId", R.mipmap.pic_1));

        ViewCompat.setTransitionName(imageView, "image");
    }

}
