package com.example.poojajoshi.assignment_9_3;

import android.os.Bundle;
import android.provider.Telephony;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.content.Context;
import android.widget.Toast;
import android.content.Intent;
import android.provider.ContactsContract;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {
    Context context;
    ListView listView;
    String[] nameList = {"Pushpa", "Latha", "Arjun", "Kiran", "Arnav"};
    String[] phoneNumberList = {"9825365449", "9825365449", "9825365449", "9825365449", "9825365449"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the Custom Adapter with name and phone number list
        context = this;
        listView = findViewById(R.id.listView);
        listView.setAdapter(new CustomAdapter(this, nameList,phoneNumberList));

        // register the context menu for list view
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo)
    {
        // create context menu items
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, 1, 1, "Call");
        menu.add(0, 2, 2, "SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==1 && item.getGroupId()==0){
            // set intent for Call
            Intent intent1 = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivity(intent1);
        }
        else if(item.getItemId()==2 && item.getGroupId()==0){
            // Set intent for SMS
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "12345"));
            intent.putExtra("sms_body", "HI");
            startActivity(intent);
        }
        else return false;
        return true;
    }
}
