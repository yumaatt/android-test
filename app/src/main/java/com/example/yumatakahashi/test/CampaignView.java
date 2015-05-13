package com.example.yumatakahashi.test;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */
public class CampaignView extends Fragment implements AbsListView.OnScrollListener {


    public static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<ModelClass> aList;
    private ListViewPagerAdapter mAdapter;

    private View mFooter;
    private int mCount = 0;
    private final static int VISIBLE_ITEM_COUNT = 5;
    private ListView mListView;
    private AsyncTask<Long, Void, Void> mTask;
    private ArrayList<ModelClass> allList;

    public CampaignView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View campainview = inflater.inflate(R.layout.campaignview, container, false);
        return campainview;
    }

    private final static String[] s_tmp = {
            //"https://test-yuma.s3.amazonaws.com/test/droid.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            //"https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            /*"https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",*/


/*
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
*/
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png"
    };

    String[][] s = {
            {
                    "https://test-yuma.s3.amazonaws.com/test/droid.png",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_red.png"
            },
            {
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img01.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img02.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img03.jpg"
            },
            {
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img04.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img05.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img06.jpg"
            },
            {
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img07.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img08.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img09.jpg"
            },
            {
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img10.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img11.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img12.jpg"
            },
            {
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img13.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img14.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img15.jpg"
            },
            {
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img16.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img17.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img18.jpg"
            },
            {
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img19.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img20.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img21.jpg"
            },
            {
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img22.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img23.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img24.jpg"
            },
            {
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img25.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img26.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img27.jpg"
            },
            {
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img28.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img29.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img30.jpg"
            },
            {
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img31.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img32.jpg",
                    "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img33.jpg"
            },

    };

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //String[] s = { "a", "b", "c", "d", "b", "c", "d", "b", "c", "d", "b",
        //        "c", "d", "b", "c", "d", "b", "c", "d" };

        //ArrayList<ModelClass> aList = new ArrayList<ModelClass>();
/*
        //int id = 0;
        for (String s1 : s) {

            aList.add(new ModelClass(s1));

            //AsyncLoaderImageView imageView = (AsyncLoaderImageView)getActivity().findViewById(R.id.icon);
            //imageView.setImageUrl(s1);

            //getLoaderManager().initLoader(id, null, imageView);//ローダーを実行
            //id++;

        }
*/

/*        //RequestQueue queue = Volley.newRequestQueue(this);
        RequestQueue mQueue = MyApplication.getInstance().getRequestQueue();

        // Volley でリクエスト
        String url = "http://www.google.com/uds/GnewsSearch?q=Obama&v=1.0";
        mQueue.add(new JsonObjectRequest(Request.Method.GET, url, (String) null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d(TAG, "response : " + response.toString());
                        Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_LONG).show();
                    }
                }, null));
        mQueue.start();
  */
        /*
        ListView lv1 = (ListView) getActivity().findViewById(
                R.id.campaignListView);
        // lv1.setAdapter(new ArrayAdapter<String>(getActivity(),
        // android.R.layout.simple_list_item_1,aList));
        listViewPagerAdapter = new ListViewPagerAdapter(getActivity(), aList);
        lv1.setAdapter(listViewPagerAdapter);
        lv1.addFooterView(getFooter());
        lv1.setOnScrollListener(this);
*/
        ListView listView = getListView();
        listView.addFooterView(getFooter());
        listView.setAdapter(getAdapter());
        listView.setOnScrollListener(this);
    }

    private ListViewPagerAdapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = new ListViewPagerAdapter(getActivity(), getList());
        }
        return mAdapter;
    }

    private View getFooter() {
        if (mFooter == null) {
            mFooter = getActivity().getLayoutInflater().inflate(R.layout.listview_footer, null);
        }
        return mFooter;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (totalItemCount == firstVisibleItem + visibleItemCount) {
            additionalReading();
            //readFlag = true;
        }
    }

    //private boolean readFlag = false;

    private void additionalReading() {
        // 読み込み回数が最大値以上ならスキップ。フッタを消す
        if (mCount >= Math.ceil((double) getAllList().size() / VISIBLE_ITEM_COUNT)) {
            invisibleFooter();
            return;
        }
        // 既に読み込み中ならスキップ
        if (mTask != null && mTask.getStatus() == AsyncTask.Status.RUNNING) {
            return;
        }
        mTask = new AsyncTask<Long, Void, Void>() {
            @Override
            protected Void doInBackground(Long[] params) {
                try {
                    Log.d(TAG, "sleep..." + params[0]);
                    Thread.sleep(params[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            };

            protected void onPostExecute(Void result) {
                addListData();

                mAdapter.notifyDataSetChanged();
                //getListView().invalidateViews();
                //invisibleFooter();

                /*ListView list = getListView();
                //int start = list.getFirstVisiblePosition();
                //for (int i = start, j = list.getLastVisiblePosition(); i <= j; i++) {
                for (int i = 6; i < 11; i++) {
                    //if (target == list.getItemAtPosition(i)) {
                    View view = list.getChildAt(i);
                    list.getAdapter().getView(i, view, list);
                    //break;
                }*/

                /*ListView list = getListView();
                int start = list.getFirstVisiblePosition();
                //for (int i = start, j = list.getLastVisiblePosition(); i <= j; i++) {
                for (int i = start, j = start + 5; i < j; i++) {
                    //if (target == list.getItemAtPosition(i)) {
                        View view = list.getChildAt(i - start);
                        list.getAdapter().getView(i, view, list);
                        //break;
                    //}
                }*/
            };
        }.execute(Math.abs(new Random(System.currentTimeMillis()).nextLong() % 3000));
        //}.execute(3000);
        /*if (readFlag) {
            return;
        }
        mTask = new AsyncTask<Long, Void, Void>() {
            @Override
            protected Void doInBackground(Long[] params) {
                try {
                    Log.d(TAG, "sleep..." + params[0]);
                    Thread.sleep(params[0]);
                } catch (Exception e) {

                    e.printStackTrace();
                }
                return null;
            };

            protected void onPostExecute(Void result) {
                addListData();
                getListView().invalidateViews();
            };
        }.execute(Math.abs(new Random(System.currentTimeMillis()).nextLong() % 3000));*/
    }

    private void invisibleFooter() {
        getListView().removeFooterView(getFooter());
    }

    private ListView getListView() {
        if (mListView == null) {
            mListView = (ListView) getActivity().findViewById(R.id.campaignListView);
        }
        return mListView;
    }

    private ArrayList<ModelClass> getList() {
        if (aList == null) {
            aList = new ArrayList<ModelClass>();
            addListData();
        }
        return aList;
    }

    private ArrayList<ModelClass> getAllList() {
        if (allList == null) {
            allList = new ArrayList<ModelClass>();
            for (String[] urls : s) {
                ModelClass m = new ModelClass(urls);
                allList.add(m);
            }
        }
        return allList;
    }

    private void addListData() {
        Log.d(TAG, "additionalReading");
        ArrayList<ModelClass> list = getList();
        //Log.d(TAG, getAllList().toString());
        int from = mCount * VISIBLE_ITEM_COUNT;
        int to = Math.min((mCount + 1) * VISIBLE_ITEM_COUNT, getAllList().size());
        ArrayList<ModelClass> subList = new ArrayList<ModelClass>(getAllList().subList(from, to));
        for (ModelClass m : subList) {
            list.add(m);
        }
        mCount++;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

}