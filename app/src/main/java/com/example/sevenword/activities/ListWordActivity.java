package com.example.sevenword.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sevenword.R;
import com.example.sevenword.adapters.WordListAdapter;
import com.example.sevenword.data.DataSource;
import com.example.sevenword.data.models.Topic;
import com.example.sevenword.data.models.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListWordActivity extends AppCompatActivity implements WordListAdapter.OnItemClickListener {

    public static void start(Context context, int idTopic) {
        Intent starter = new Intent(context, ListWordActivity.class);
        starter.putExtra("id_topic", idTopic);
        context.startActivity(starter);
    }

    private RecyclerView rvWords;
    private WordListAdapter mWordListAdapter;
    private int idTopic;
    private List<Word> words = new ArrayList<>();
    private List<Word> originalwords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listword);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        idTopic = getIntent().getIntExtra("id_topic", 0);

        rvWords = findViewById(R.id.rvWords);
        rvWords.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvWords.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mWordListAdapter = new WordListAdapter(this, this);
        rvWords.setAdapter(mWordListAdapter);
        getData(idTopic);
    }

    private void getData(int idTopic) {
        Topic topic =DataSource.getInstance().getTopicById(idTopic);
        getSupportActionBar().setTitle(topic.getTitle());
        words.clear();
        originalwords.clear();
        words.addAll(topic.getWords());
        originalwords.addAll(words);
        mWordListAdapter.setItems(words);
    }

    @Override
    public void onItemClick(final Word item, final int pos) {
        //thực hiện khi ấn vào item word
        AlertDialog builder = new AlertDialog.Builder(this)
                .setTitle("Trạng thái")
                .setMessage("Đã hoàn thành từ mới")
                .setPositiveButton("Hoàn thành", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mWordListAdapter.removeItem(item, pos);
                        dialogInterface.dismiss();
                    }
                }).setNeutralButton("Chưa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    private void practice() {
        final Word word = originalwords.get(new Random().nextInt(originalwords.size()));
        Word word2 =originalwords.get(new Random().nextInt(originalwords.size()));
        Word word3 = originalwords.get(new Random().nextInt(originalwords.size()));
        final List<Word> wordsRandom = Arrays.asList(word, word2, word3);
        //xáo trộn các phần tử
        Collections.shuffle(wordsRandom);
        new AlertDialog.Builder(this)
                .setTitle("Chọn đáp án đúng")
                .setMessage(word.getTitle() + " nghĩa là")
                .setNegativeButton(wordsRandom.get(0).getMean(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (wordsRandom.get(0).getMean().equalsIgnoreCase(word.getMean())) {
                            Toast.makeText(ListWordActivity.this, "Chính xác", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ListWordActivity.this, "Sai rồi", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setPositiveButton(wordsRandom.get(1).getMean(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (wordsRandom.get(1).getMean().equalsIgnoreCase(word.getMean())) {
                            Toast.makeText(ListWordActivity.this, "Chính xác", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ListWordActivity.this, "Sai rồi", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setNeutralButton(wordsRandom.get(2).getMean(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (wordsRandom.get(2).getMean().equalsIgnoreCase(word.getMean())) {
                    Toast.makeText(ListWordActivity.this, "Chính xác", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListWordActivity.this, "Sai rồi", Toast.LENGTH_SHORT).show();
                }
            }
        })
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_word, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        if (item.getItemId() == R.id.practice) {
            practice();
        }
        return super.onOptionsItemSelected(item);
    }


}
