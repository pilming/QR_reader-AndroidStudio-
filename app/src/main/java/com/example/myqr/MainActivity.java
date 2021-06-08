package com.example.myqr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //자바로 따지면 메인메소드 개념 자바와달리 안드로이드는 클래스 하나당 onCreate가 하나씩 필요하다
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        new IntentIntegrator(this).initiateScan(); //바코드 스캐너 호출
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //main액티비티에서 sub액티비티를 호출하여 넘어갔다가, 다시 main 액티비티로 돌아올때 사용되는 기본 메소드
        //바코드 스캐너로 서브액티비티가 실행되고 바코드 인식후 다시 메인 액티비티로 돌아오면서 아래 코드가 실행된다.
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data); //바코드 스캐너로부터 받은 결과값
        if(result != null) { //결과값이 있다면
            if(result.getContents() == null) { //결과값은 있는데 거기에 데이터가 없다면
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                // todo
            } else { //데이터가 있다면 스캔된 데이터 띄워줌
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                // todo
            }
        } else { //결과값이 없다면 바로 종료
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}