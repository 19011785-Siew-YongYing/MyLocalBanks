package sg.edu.rp.c346.id19011785.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2, text3;
    String bankClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.bank1); // DBS bank
        registerForContextMenu(text1);

        text2 = findViewById(R.id.bank2); // OCBC bank
        registerForContextMenu(text2);

        text3 = findViewById(R.id.bank3); // UOB bank
        registerForContextMenu(text3);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == text1){
            bankClicked = "DBS";
        }
        else if (v == text2) {
            bankClicked = "OCBC";
        }

        else if (v == text3){
            bankClicked = "UOB";
        }

        menu.add(0,0,0, "Website");
        menu.add(0,1,1, "Contact The Bank");
        menu.add(0,2,2, "Toggle Favourite"); // Toggle Favourite ; // ENHANCEMENTS
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){ // ENHANCEMENTS
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.English){
            text1.setText(R.string.dbsBank);
            text2.setText(R.string.ocbcBank);
            text3.setText(R.string.uobBank);
            return true;
        }
        else if (id == R.id.Chinese){ // ENHANCEMENTS
            text1.setText(R.string.dbsChi);
            text2.setText(R.string.ocbcChi);
            text3.setText(R.string.uobChi);
            return true;
        }
        else {
            text1.setText(R.string.error); // ENHANCEMENTS
            text2.setText(R.string.error);
            text3.setText(R.string.error);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();
        if(bankClicked.equalsIgnoreCase(getString(R.string.dbsBank))) {
            if (id == 0) {
                Intent int1 = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb)));
                startActivity(int1);
                return true;
            }
            else if (id == 1){
                Intent int2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getString(R.string.dbsContact)));
                startActivity(int2);
                return true;
            }
            else if (id == 2){ // ENHANCEMENTS
                if(text1.getCurrentTextColor()== Color.BLACK){
                    text1.setTextColor(Color.RED);
                }
                else if (text1.getCurrentTextColor() == Color.RED){
                    text1.setTextColor(Color.BLACK);
                }
                return true;
            }
        }

        else if(bankClicked.equalsIgnoreCase(getString(R.string.ocbcBank))) {
            if (id == 0) {
                Intent int3 = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
                startActivity(int3);
                return true;
            }
            else if (id == 1){
                Intent int4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getString(R.string.ocbcContact)));
                startActivity(int4);
                return true;
            }
            else if (id == 2){ // ENHANCEMENTS
                if(text2.getCurrentTextColor()== Color.BLACK){
                    text2.setTextColor(Color.RED);
                }
                else if (text2.getCurrentTextColor() == Color.RED){
                    text2.setTextColor(Color.BLACK);
                }
                return true;
            }
        }

        else if(bankClicked.equalsIgnoreCase(getString(R.string.uobBank))) {
            if (id == 0) {
                Intent int3 = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWeb)));
                startActivity(int3);
                return true;
            }
            else if (id == 1){
                Intent int4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ getString(R.string.uobContact)));
                startActivity(int4);
                return true;
            }
            else if (id == 2){ // ENHANCEMENTS
                if(text3.getCurrentTextColor()== Color.BLACK){
                    text3.setTextColor(Color.RED);
                }
                else if (text3.getCurrentTextColor() == Color.RED){
                    text3.setTextColor(Color.BLACK);
                }
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

}