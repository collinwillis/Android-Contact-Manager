package com.example.conmancontactmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addBusinessContact extends AppCompatActivity {

    BusinessService businessService;

    Button btn_ok, btn_cancel, btn_delete;

    final static int PERMISSION_TO_CALL = 1;

    EditText et_name, et_phonenum, et_email, et_picturenumber, et_country, et_state, et_city, et_zip, et_streetaddress, et_open, et_close, et_url;

    int positionEdit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_business_contact);

        businessService = ((MyApplication) this.getApplication()).getBusinessService();

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_delete = findViewById(R.id.btn_delete);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_phonenum = findViewById(R.id.et_phonenum);
        et_country = findViewById(R.id.et_country);
        et_picturenumber = findViewById(R.id.et_picturenumber);
        et_state = findViewById(R.id.et_state);
        et_city = findViewById(R.id.et_city);
        et_zip = findViewById(R.id.et_zip);
        et_streetaddress = findViewById(R.id.et_streetaddress);
        et_open = findViewById(R.id.et_open);
        et_close = findViewById(R.id.et_close);
        et_url = findViewById(R.id.et_url);

        Bundle incomingIntent = getIntent().getExtras();
        if(incomingIntent != null)
        {
            String name = incomingIntent.getString("name");
            String email = incomingIntent.getString("email");
            String phonenum = incomingIntent.getString("phonenum");
            String country = incomingIntent.getString("country");
            String state = incomingIntent.getString("state");
            String city = incomingIntent.getString("city");
            String zip = incomingIntent.getString("zip");
            String streetaddress = incomingIntent.getString("streetaddress");
            int picturenumber = incomingIntent.getInt("picturenumber");
            String open = incomingIntent.getString("open");
            String close = incomingIntent.getString("close");
            String url = incomingIntent.getString("url");
            positionEdit = incomingIntent.getInt("edit");

            et_name.setText(name);
            et_email.setText(email);
            et_phonenum.setText(phonenum);
            et_country.setText(country);
            et_state.setText(state);
            et_city.setText(city);
            et_zip.setText(zip);
            et_streetaddress.setText(streetaddress);
            et_picturenumber.setText(Integer.toString(picturenumber));
            et_open.setText(open);
            et_close.setText(close);
            et_url.setText(url);


        }

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newName = et_name.getText().toString();
                String newEmail = et_email.getText().toString();
                String newPictureNumber = et_picturenumber.getText().toString();
                String newPhonenum = et_phonenum.getText().toString();
                String newCountry = et_country.getText().toString();
                String newState = et_state.getText().toString();
                String newCity = et_city.getText().toString();
                String newZip = et_zip.getText().toString();
                String newStreetAddress = et_streetaddress.getText().toString();
                String newOpen = et_open.getText().toString();
                String newClose = et_close.getText().toString();
                String newUrl = et_url.getText().toString();

               BusinessContact b = new BusinessContact();
                b.name = newName;
                b.email = newEmail;
                b.photoName = Integer.parseInt(newPictureNumber);
                b.phoneNo = newPhonenum;
                b.country = newCountry;
                b.state = newState;
                b.city = newCity;
                b.zipCode = newZip;
                b.streetAddress = newStreetAddress;
                b.url = newUrl;
                b.opening = newOpen;
                b.closing = newClose;

                FileIOService fileIOService = new FileIOService(v.getContext());
                businessService = fileIOService.readAllData("contacts.txt");

                businessService.addressbook.addOne(b);


                Intent i = new Intent(v.getContext(), MainActivity.class);


                i.putExtra("edit", positionEdit);
                i.putExtra("name", newName);
                i.putExtra("email", newEmail);
                i.putExtra("phonenum", newPhonenum);
                i.putExtra("country", newCountry);
                i.putExtra("state", newState);
                i.putExtra("city", newCity);
                i.putExtra("zip", newZip);
                i.putExtra("streetaddress", newStreetAddress);
                i.putExtra("picturenumber", newPictureNumber);
                i.putExtra("open", newOpen);
                i.putExtra("close", newClose);
                i.putExtra("url", newUrl);

                startActivity(i);

                FileIOService fileioservice = new FileIOService(v.getContext());
                fileioservice.writeAllData(businessService, "contacts.txt");


            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileIOService fileIOService = new FileIOService(v.getContext());
                businessService = fileIOService.readAllData("contacts.txt");

                businessService.getList().deleteOne(businessService.addressbook.getTheList().get(positionEdit));

                FileIOService fileioservice = new FileIOService(v.getContext());
                fileioservice.writeAllData(businessService, "contacts.txt");

                Intent i = new Intent(v.getContext(), MainActivity.class);

                startActivity(i);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.businessservicemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item2:
                Toast.makeText(this, et_phonenum.getText().toString(), Toast.LENGTH_SHORT).show();
                dialPhoneNumber(et_phonenum.getText().toString());
                return true;
            case R.id.item3:
                Toast.makeText(this, "Text", Toast.LENGTH_SHORT).show();
                composeMmsMessage(et_phonenum.getText().toString(), "Hello I would like to talk.");
                return true;
            case R.id.item4:
                Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
                String[] addresses = new String[1];
                addresses[0] = et_email.getText().toString();

                composeEmail(addresses, "Hello friend.");
                return true;
            case R.id.item5:
                Toast.makeText(this, "Directions", Toast.LENGTH_SHORT).show();
                String mapQuery = "geo:0,0?q=" + et_streetaddress.getText().toString() + " " + et_city.getText().toString() + " " + et_state.getText().toString();

                Uri mapUri = Uri.parse(mapQuery);

                showMap(mapUri);
                return true;
            case R.id.item6:
                Toast.makeText(this, "Website", Toast.LENGTH_SHORT).show();
                openWebPage(et_url.getText().toString());
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void openWebPage(String url)
    {
        if(!url.startsWith("http://") || !url.startsWith("https://"))
        {
            url = "http://" + url;
        }
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }

    }

    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void callPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted

            // No explanation needed; request the permission
            ActivityCompat.requestPermissions(addBusinessContact.this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PERMISSION_TO_CALL);
        }
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_TO_CALL: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    callPhoneNumber(et_phonenum.getText().toString());

                } else {

                    Toast.makeText(this, "Cannot make a call without your permission.", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    public void composeMmsMessage(String phoneNumber, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNumber));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
