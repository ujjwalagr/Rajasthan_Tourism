package rajasthantourism.com.tourrajasthan;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import devlight.io.library.ntb.NavigationTabBar;

import java.util.ArrayList;

public class HorizontalNtbActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_ntb);
        initUI();
    }

    private void initUI() {
        final ViewPager viewPager = findViewById(R.id.vp_horizontal_ntb);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public boolean isViewFromObject(final View view, final Object object) {
                return view.equals(object);
            }

            @Override
            public void destroyItem(final View container, final int position, final Object object) {
                ((ViewPager) container).removeView((View) object);
            }

            @Override
            public Object instantiateItem(final ViewGroup container, final int position) {

                final View view = LayoutInflater.from(
                        getBaseContext()).inflate(R.layout.item_vp, null, false);

                final TextView imageView1 = view.findViewById(R.id.imageView1);
                imageView1.setOnClickListener(HorizontalNtbActivity.this);

                final TextView imageView2 = view.findViewById(R.id.imageView2);
                imageView2.setOnClickListener(HorizontalNtbActivity.this);

                final TextView imageView3 = view.findViewById(R.id.imageView3);
                imageView3.setOnClickListener(HorizontalNtbActivity.this);

                final TextView imageView4 = view.findViewById(R.id.imageView4);
                imageView4.setOnClickListener(HorizontalNtbActivity.this);

                final TextView imageView5 = view.findViewById(R.id.imageView5);
                imageView5.setOnClickListener(HorizontalNtbActivity.this);

                final TextView imageView6 = view.findViewById(R.id.imageView6);
                imageView6.setOnClickListener(HorizontalNtbActivity.this);

                final TextView imageView7 = view.findViewById(R.id.imageView7);
                imageView7.setOnClickListener(HorizontalNtbActivity.this);

                final TextView imageView8 = view.findViewById(R.id.imageView8);
                imageView8.setOnClickListener(HorizontalNtbActivity.this);

                container.addView(view);
                return view;
            }
        });


        final String[] colors = getResources().getStringArray(R.array.default_preview);

        final NavigationTabBar navigationTabBar = findViewById(R.id.ntb_horizontal);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.home),
                        Color.parseColor(colors[0]))
                        .title("Home")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.event),
                        Color.parseColor(colors[1]))
                        .title("Events")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.places),
                        Color.parseColor(colors[2]))
                        .title("Places")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.profile),
                        Color.parseColor(colors[3]))
                        .title("Profile")
                        .build()
        );

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 0);
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                navigationTabBar.getModels().get(position).hideBadge();
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        navigationTabBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < navigationTabBar.getModels().size(); i++) {
                    final NavigationTabBar.Model model = navigationTabBar.getModels().get(i);
                    navigationTabBar.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            model.showBadge();
                        }
                    }, i * 100);
                }
            }
        }, 500);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView1:
                Toast.makeText(this, "imageview1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView2:
                Toast.makeText(this, "imageview2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView3:
                Toast.makeText(this, "imageview3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView4:
                Toast.makeText(this, "imageview4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView5:
                Toast.makeText(this, "imageview5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView6:
                Toast.makeText(this, "imageview6", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView7:
                Toast.makeText(this, "imageview7", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView8:
                Toast.makeText(this, "imageview8", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Koi nahi chala", Toast.LENGTH_SHORT).show();
        }
    }
}
