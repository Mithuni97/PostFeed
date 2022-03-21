package com.asg.postfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.asg.postfeed.model.Post;

import java.util.List;

public class ViewPost extends AppCompatActivity {
    String userId, id, title, body;
    TextView tv_userId, tv_id, tv_title, tv_body;
    Button btn_comment;
    Post postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);

        tv_userId = findViewById(R.id.userid);
        tv_id = findViewById(R.id.postId);
        tv_title = findViewById(R.id.title);
        tv_body = findViewById(R.id.body);
        btn_comment = findViewById(R.id.comment);

        postList = getIntent().getParcelableExtra("postlist");

        tv_id.setText("Post Id : " + postList.getId());
        tv_userId.setText("User Id : " + postList.getUserId());
        tv_title.setText("Title : " + postList.getTitle());
        tv_body.setText(postList.getBody());

        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewPost.this, PostComments.class);
                startActivity(intent);
            }
        });
    }
}