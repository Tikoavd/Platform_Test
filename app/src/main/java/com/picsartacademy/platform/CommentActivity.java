package com.picsartacademy.platform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentActivity extends AppCompatActivity {
    RecyclerView recyclerViewComment;
    int postId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        recyclerViewComment = findViewById(R.id.recyclerViewComment);
        recyclerViewComment.setLayoutManager(new LinearLayoutManager(this));

        postId = getIntent().getIntExtra("postId", 0);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceholder jsonPlaceholder = retrofit.create(JSONPlaceholder.class);
        Call<List<Comment>> call = jsonPlaceholder.getComments(postId);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if(!response.isSuccessful()) {
                    Toast.makeText(CommentActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Comment> commentList = response.body();
                CommentAdapter adapter = new CommentAdapter(CommentActivity.this, commentList);
                recyclerViewComment.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Toast.makeText(CommentActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}