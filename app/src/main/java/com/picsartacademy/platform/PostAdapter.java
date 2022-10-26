package com.picsartacademy.platform;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    List<Post> postList;
    Context context;
    String[] UserNames;

    public PostAdapter(Context context, List<Post> posts, String[] Usernames) {
        this.context = context;
        postList = posts;
        UserNames = Usernames;
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.userName.setText(UserNames[Integer.valueOf(post.getUserId()) - 1]);
        //holder.id.setText("In their No " + post.getId() + " post");
        holder.title.setText("title: " + post.getTitle());
        holder.body.setText(post.getBody());

        holder.commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CommentActivity.class);

                intent.putExtra("postId", Integer.valueOf(post.getId()));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView userName, title, body;
        Button commentButton;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.userName);
            //id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            commentButton = itemView.findViewById(R.id.commentButton);
        }
    }
}
