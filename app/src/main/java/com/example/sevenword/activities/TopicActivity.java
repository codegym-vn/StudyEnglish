package com.example.sevenword.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sevenword.R;
import com.example.sevenword.adapters.TopicListAdapter;
import com.example.sevenword.data.DataSource;
import com.example.sevenword.data.models.Topic;

import java.util.List;

public class TopicActivity extends AppCompatActivity implements TopicListAdapter.OnItemClickListener {

    private RecyclerView rvTopic;
    private TopicListAdapter mTopicListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        rvTopic = findViewById(R.id.rvTopic);
        rvTopic.setLayoutManager(new GridLayoutManager(this, 2));

        mTopicListAdapter = new TopicListAdapter(this, this);
        rvTopic.setAdapter(mTopicListAdapter);
        getDataTopic();
    }

    private void getDataTopic() {
        new AsyncTask<Void, Void, List<Topic>>() {

            @Override
            protected List<Topic> doInBackground(Void... voids) {
                DataSource.getInstance().initData();
                return DataSource.getInstance().getTopics();
            }

            @Override
            protected void onPostExecute(List<Topic> topics) {
                super.onPostExecute(topics);
                mTopicListAdapter.setItems(topics);
            }
        }.execute();
    }

    @Override
    public void onItemClick(Topic item) {
        ListWordActivity.start(this,item.getId());
    }
}
