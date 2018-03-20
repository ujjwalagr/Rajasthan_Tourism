package rajasthantourism.com.tourrajasthan;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import devlight.io.library.ntb.NavigationTabBar;

import java.util.ArrayList;
import java.util.List;

public class HorizontalNtbActivity extends Activity implements View.OnClickListener {

    String description[];
    int imageId[];
    ViewPager viewPager;
    int flag;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_ntb);
        flag = 0;
        initUI();
    }

    private void initUI() {
        viewPager = findViewById(R.id.vp_horizontal_ntb);
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

                View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_vp, null, false);
                if (position == 0 && flag == 0) {
                    view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_vp, null, false);
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
                } else if (position == 0)
                    view = LayoutInflater.from(getBaseContext()).inflate(R.layout.activity_recycler_view, null, false);

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
                //Toast.makeText(HorizontalNtbActivity.this, "On page " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageSelected(final int position) {
                Toast.makeText(HorizontalNtbActivity.this, "On page " + position, Toast.LENGTH_SHORT).show();
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

    // har case ke according
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView1:
                setJaipurData();
                setRecyclerView();
                break;
            case R.id.imageView2:
                setUdaipurData();
                setRecyclerView();
                break;
            case R.id.imageView3:
                setJaipurData();
                setRecyclerView();
                break;
            case R.id.imageView4:
                setPushkarData();
                setRecyclerView();
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
        }
    }

    // simliar sab ke lie
    public void setJaipurData() {
        description = new String[]{"Amber Palace", "City Palace", "Jantar Mantar", "Hawa Mahal", "Albert Hall Museum",
                "Nahargarh Fort", "Jaigarh", "Birla Mandir", "Jal Mahal"};
        imageId = new int[]{R.drawable.amberpalace, R.drawable.citypalace, R.drawable.jantarmantar, R.drawable.amber_fort,
                R.drawable.alberhall, R.drawable.nahargarhfort, R.drawable.jaigarhfort, R.drawable.birlatemple, R.drawable.jalmahal};
        flag = 1;
        initUI();
        setRecyclerView();
    }
    public void setUdaipurData() {
        description = new String[]{"Udaipur City palace", "Lake Palace", "Jag Mandir", "Lake Pichola", "Saheliyo ki Bari",
                "Monsoon palace"};
        imageId = new int[]{R.drawable.udaipurcitypalace, R.drawable.lakepalace, R.drawable.jagmandir, R.drawable.lakepichola,
                R.drawable.saheliyonkibari, R.drawable.monsoonpalace};
        flag = 1;
        initUI();
        setRecyclerView();
    }
    public void setJodhpurData() {
        description = new String[]{"Mehrangarh Fort", "Khejarala Fort", "Umaid Bhawan"};
        imageId = new int[]{R.drawable.mehrangarhfort, R.drawable.khejarlafort, R.drawable.umaidbhawan};
        flag = 1;
        initUI();
        setRecyclerView();

    }
    public void setPushkarData() {
        description = new String[]{"Pushkar Lake", "Brahma Temple", "Gurudwara Singh Sabha","Rangji Temple","Papmochni Temple"};
        imageId = new int[]{R.drawable.pushkarlake, R.drawable.brahmatemple, R.drawable.gurudwarasinghsabha,R.drawable.rangjitemple,R.drawable.papmochinitemple};
        flag = 1;
        initUI();
        setRecyclerView();

    }

    // nahi chedna
    public List<NatureModel> callNext() {
        List<NatureModel> dataList = new ArrayList<>();
        for (int i = 0; i < imageId.length; i++) {
            NatureModel natureModel = new NatureModel();
            natureModel.setImageId(imageId[i]);
            natureModel.setTitle(description[i]);
            dataList.add(natureModel);
        }
        return dataList;
    }

    // nahi chedna
    public void setRecyclerView() {
        List<NatureModel> dataList = callNext();

        android.support.v7.widget.RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MyAdapter adapter = new MyAdapter(this, dataList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
