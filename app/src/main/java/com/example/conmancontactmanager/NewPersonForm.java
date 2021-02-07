//package com.example.conmancontactmanager;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class NewPersonForm extends AppCompatActivity {
//
//    Button btn_ok, btn_cancel;
//
//    EditText et_name, et_age, et_picturenumber;
//
//    int positionEdit = -1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_new_person_form);
//
//        btn_ok = findViewById(R.id.btn_ok);
//        btn_cancel = findViewById(R.id.btn_cancel);
//        et_name = findViewById(R.id.et_name);
//        et_age = findViewById(R.id.et_age);
//        et_picturenumber = findViewById(R.id.et_picturenumber);
//
//        Bundle incomingIntent = getIntent().getExtras();
//        if(incomingIntent != null)
//        {
//             String name = incomingIntent.getString("name");
//            int age = incomingIntent.getInt("age");
//            int picturenumber = incomingIntent.getInt("picturenumber");
//            positionEdit = incomingIntent.getInt("edit");
//
//            et_name.setText(name);
//            et_age.setText(Integer.toString(age));
//            et_picturenumber.setText(Integer.toString(picturenumber));
//        }
//
//        btn_ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String newName = et_name.getText().toString();
//                String newAge = et_age.getText().toString();
//                String newPictureNumber = et_picturenumber.getText().toString();
//
//
//                 Intent i = new Intent(v.getContext(), MainActivity.class);
//
//
//                 i.putExtra("edit", positionEdit);
//                 i.putExtra("name", newName);
//                 i.putExtra("age", newAge);
//                 i.putExtra("picturenumber", newPictureNumber);
//
//                 startActivity(i);
//            }
//        });
//    }
//}
