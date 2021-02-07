package com.example.conmancontactmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv_contacts;

    Adapter adapter;
    BusinessService businessService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_contacts = findViewById(R.id.lv_contacts);

        businessService = ((MyApplication) this.getApplication()).getBusinessService();

        FileIOService fileIOService = new FileIOService(this);
        businessService = fileIOService.readAllData("contacts.txt");

        adapter = new Adapter(MainActivity.this, businessService);

        lv_contacts.setAdapter(adapter);

        lv_contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                editPerson(position);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contactmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item2:
                Toast.makeText(this, "Create Person Contact", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this,addPersonContact.class);
                startActivity(i);
                        return true;
            case R.id.item3:
                Toast.makeText(this, "Create Business Contact", Toast.LENGTH_SHORT).show();
                Intent b = new Intent(this,addBusinessContact.class);
                startActivity(b);
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }

    }

    public void editPerson(int position)
    {


        BaseContact b = businessService.getList().getTheList().get(position);

            if (b instanceof BusinessContact) {
                Intent i = new Intent(getApplicationContext(), addBusinessContact.class);
                i.putExtra("edit", position);
                i.putExtra("name", b.name);
                i.putExtra("phonenum", b.phoneNo);
                i.putExtra("email", b.email);
                i.putExtra("name", b.name);
                i.putExtra("country", b.country);
                i.putExtra("state", b.state);
                i.putExtra("city", b.city);
                i.putExtra("zip", b.zipCode);
                i.putExtra("streetaddress", b.streetAddress);
                i.putExtra("picturenumber", b.photoName);
                i.putExtra("open", ((BusinessContact) b).opening);
                i.putExtra("close", ((BusinessContact) b).closing);
                i.putExtra("url", ((BusinessContact) b).url);

                startActivity(i);
            } else {
                Intent i = new Intent(getApplicationContext(), addPersonContact.class);
                i.putExtra("edit", position);
                i.putExtra("name", b.name);
                i.putExtra("phonenum", b.phoneNo);
                i.putExtra("email", b.email);
                i.putExtra("name", b.name);
                i.putExtra("country", b.country);
                i.putExtra("state", b.state);
                i.putExtra("city", b.city);
                i.putExtra("zip", b.zipCode);
                i.putExtra("streetaddress", b.streetAddress);
                i.putExtra("picturenumber", b.photoName);

                startActivity(i);
            }


    }
}
