package com.asg.postfeed.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asg.postfeed.R;
import com.asg.postfeed.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    Context context;
    List<Post> postList;
    onItemClickListener onItemClickListener;

    public PostAdapter(Context context, List<Post> postList, PostAdapter.onItemClickListener onItemClickListener) {
        this.context = context;
        this.postList = postList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
       return new PostViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.id.setText("Post Id : " + post.getId());
        holder.title.setText("Title : " +post.getTitle());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title, id, userid, body;
        onItemClickListener onItemClickListener;

        public PostViewHolder(@NonNull View itemView, onItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            title = itemView.findViewById(R.id.title);
            id = itemView.findViewById(R.id.postId);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClickPost(getAdapterPosition());
        }
    }

    public interface onItemClickListener {
        void onItemClickPost(int position);
    }
}
