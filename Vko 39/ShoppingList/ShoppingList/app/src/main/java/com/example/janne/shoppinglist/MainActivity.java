package com.example.janne.shoppinglist;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements AddItemDialogFragment.DialogListener {

    private final String DATABASE_TABLE = "shoppingList";
    private final int DELETE_ID = 0;
    private SQLiteDatabase db;
    private Cursor cursor;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find list view
        listView = (ListView)  findViewById(R.id.listView);
        // register listView's context menu (to delete row)
        registerForContextMenu(listView);

        // get database instance
        db = (new DatabaseOpenHelper(this)).getWritableDatabase();
        // get data with using own made queryData method
        queryData();

        // calculate total price
        float points = 0f;
        if (cursor.moveToFirst()) {
            do {
                float price = cursor.getFloat(3); // columnIndex
                float amount = cursor.getFloat(2);
                points += price*amount;
            } while(cursor.moveToNext());
            Toast.makeText(getBaseContext(), "Total price: " + points, Toast.LENGTH_SHORT).show();
        }
    }

    // query data from database
    public void queryData() {
        //cursor = db.rawQuery("SELECT _id, name, score FROM shoppingList ORDER BY score DESC", null);
        // get data with query
        String[] resultColumns = new String[]{"_id","name","amount","price"};
        //cursor = db.query(DATABASE_TABLE,resultColumns,null,null,null,null,"price DESC",null);
        cursor = db.rawQuery("SELECT * FROM shoppingList ORDER BY price DESC", null);

        // add data to adapter
        ListAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.list_item, cursor,
                new String[] {"name", "amount", "price"},      // from
                new int[] {R.id.name, R.id.amount, R.id.price}    // to
                ,0);  // flags

        // show data in listView
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handles item selections
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                AddItemDialogFragment eDialog = new AddItemDialogFragment();
                eDialog.show(getFragmentManager(), "Add a new item to shopping list");
        }
        return false;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(Menu.NONE, DELETE_ID, Menu.NONE, "Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case DELETE_ID:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
                String[] args = {String.valueOf(info.id)};
                db.delete("shoppingList", "_id=?", args);
                queryData();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // close cursor and db connection
        cursor.close();
        db.close();
    }

    @Override
    public void onDialogPositiveClick(android.app.DialogFragment dialog, String name, int amount, int price) {
        ContentValues values=new ContentValues(2);
        values.put("name", name);
        values.put("amount", amount);
        values.put("price", price);
        db.insert("shoppingList", null, values);
        // get data again
        queryData();
    }

    @Override
    public void onDialogNegativeClick(android.app.DialogFragment dialog) {

    }
}
