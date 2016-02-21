package com.android.arifhasnat.material;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String data[]={"Once upon a time ","Once upon a time","Once upon a time","Once upon a time ","Once upon a time ","Once upon a time","Once upon a time"};
    ArrayList<String> arrayList;
    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mLayoutManager;
    public DataAdapter dataAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList=new ArrayList<>();
        arrayList.add("arif");
        arrayList.add("hasnat");


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new DataAdapter(arrayList,this);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));




    }



    public static  interface ClickListener{

        public void onClick(View view,int position);
        public void onLongClick(View view, int position);

    }

    static  public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(final Context context, RecyclerView recyclerView, ClickListener clickListener) {


            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    Toast.makeText(context,"single clicked",Toast.LENGTH_LONG).show();
                    return super.onSingleTapUp(e);



                }

                @Override
                public void onLongPress(MotionEvent e) {
                    Toast.makeText(context,"long  clicked",Toast.LENGTH_LONG).show();
                    super.onLongPress(e);
                }
            });

        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            Toast.makeText(rv.getContext(),"Intercept clicked"+e,Toast.LENGTH_LONG).show();
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            Toast.makeText(rv.getContext(),"onTouch clicked"+e,Toast.LENGTH_LONG).show();

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
