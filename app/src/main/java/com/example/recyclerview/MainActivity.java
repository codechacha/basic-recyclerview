package com.example.recyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private List<SampleItem> mSampleItems;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;
    private Context mContext;
    //private LinearLayoutManager mLinearLayoutManager;
    // GridLayoutManager
    //private StaggeredGridLayoutManager mStaggeredGridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        loadSampleItems();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        Button btnLinear = (Button) findViewById(R.id.btn_linear);
        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                adapter = new MyRecyclerViewAdapter(mSampleItems);
                adapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(SampleItem item) {
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                    }
                });
                mRecyclerView.setAdapter(adapter);
            }
        });


        Button btnGrid = (Button) findViewById(R.id.btn_grid);
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                adapter = new MyRecyclerViewAdapter(mSampleItems);
                adapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(SampleItem item) {
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                    }
                });
                mRecyclerView.setAdapter(adapter);
            }
        });


        Button btnStaggered = (Button) findViewById(R.id.btn_staggered_grid);
        btnStaggered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                //layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
                layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
                mRecyclerView.setLayoutManager(layoutManager);
                //mRecyclerView.setHasFixedSize(true);
                adapter = new MyRecyclerViewAdapter(mSampleItems);
                adapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(SampleItem item) {
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                    }
                });
                mRecyclerView.setAdapter(adapter);
            }
        });


    }

    private void loadSampleItems() {
        mSampleItems = new ArrayList<SampleItem>();
        mSampleItems.add(new SampleItem("Sample1", getResource(R.drawable.sample1)));
        mSampleItems.add(new SampleItem("Sample2", getResource(R.drawable.sample2)));
        mSampleItems.add(new SampleItem("Sample3", getResource(R.drawable.sample3)));
        mSampleItems.add(new SampleItem("Sample4", getResource(R.drawable.sample4)));
        mSampleItems.add(new SampleItem("Sample5", getResource(R.drawable.sample5)));
        mSampleItems.add(new SampleItem("Sample6", getResource(R.drawable.sample6)));
        mSampleItems.add(new SampleItem("Sample7", getResource(R.drawable.sample7)));
        mSampleItems.add(new SampleItem("Sample7", getResource(R.drawable.sample8)));
        mSampleItems.add(new SampleItem("Sample7", getResource(R.drawable.sample9)));
        mSampleItems.add(new SampleItem("Sample7", getResource(R.drawable.sample10)));
    }

    private Drawable getResource(int resourceId) {
        Drawable dr = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dr = getDrawable(resourceId);
        } else {
            dr = getResources().getDrawable(resourceId);
        }
        return dr;
    }

}
