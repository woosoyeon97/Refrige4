package com.example.woosoyeon.refrige;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    EditText mMemoEdit=null;
    TextFileManager mTextFileManager = new TextFileManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity);
        mMemoEdit=(EditText)findViewById(R.id.memo_edit);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.load_btn:{
                String memoData=mTextFileManager.load();
                mMemoEdit.setText(memoData);

                Toast.makeText(this,"불러오기 완료",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.save_btn:{
                String memoData=mMemoEdit.getText().toString();
                mTextFileManager.save(memoData);
                mMemoEdit.setText("");

                Toast.makeText(this,"저장 완료",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.delete_btn:{
                mTextFileManager.delete();
                mMemoEdit.setText("");

                Toast.makeText(this,"삭제 완료",Toast.LENGTH_LONG).show();

            }
        }
    }
    public void onBackButtonClicked(View v) {
        Toast.makeText(getApplicationContext(), "돌아가기 버튼을 눌렀어요", Toast.LENGTH_LONG).show();
        finish();
    }
}
