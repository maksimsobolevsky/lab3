package com.example.lab3userdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Comment extends AppCompatActivity {

    private EditText userCommentEditText;
    private TextInputLayout userCommentInputLayout;
    private Button save;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_form);

        this.userCommentEditText = (EditText)this.findViewById(R.id.userCommentEditText);
        this.userCommentInputLayout = (TextInputLayout) this.findViewById(R.id.userCommentInputLayout);

        this.save = (Button)this.findViewById(R.id.saveButton);
        this.cancel = (Button)this.findViewById(R.id.cancelButton);

        this.save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(Constants.FIELD_TYPE_KEY, Types.COMMENT);
                returnIntent.putExtra(Constants.RESULT_KEY, Comment.this.userCommentEditText.getText().toString());
                Comment.this.setResult(Activity.RESULT_OK, returnIntent);
                Comment.this.finish();
            }
        });


        this.cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Comment.this.setResult(Activity.RESULT_CANCELED);
                Comment.this.finish();
            }
        });
    }
}