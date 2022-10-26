package com.picsartacademy.platform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder>{
    List<Comment> commentList;
    Context context;

    public CommentAdapter(Context context, List<Comment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_item, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = commentList.get(position);

        holder.email.setText(comment.getEmail());
        holder.name.setText("title: " + comment.getName());
        holder.commentbody.setText(comment.getBody());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }


    public class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView email, name, commentbody;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.email);
            name = itemView.findViewById(R.id.name);
            commentbody = itemView.findViewById(R.id.commentbody);
        }
    }
}
