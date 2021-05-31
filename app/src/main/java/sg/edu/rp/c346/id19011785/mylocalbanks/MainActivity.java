package sg.edu.rp.c346.id19011785.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2, text3;
    String bankClicked;

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
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();
        if(bankClicked.equalsIgnoreCase("DBS")) {
            if (id == 0) {
                Intent int1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/"));
                startActivity(int1);
                return true;
            }
            else if (id == 1){
                String dbsnum = "1800-111-1111";
                Intent int2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ dbsnum));
                startActivity(int2);
                return true;
            }
        }

        else if(bankClicked.equalsIgnoreCase("OCBC")) {
            if (id == 0) {
                Intent int3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/"));
                startActivity(int3);
                return true;
            }
            else if (id == 1){
                //String ocbcnum = "1800-773-6437";
                Intent int4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ 18007736437l));
                startActivity(int4);
                return true;
            }
        }

        else if(bankClicked.equalsIgnoreCase("UOB")) {
            if (id == 0) {
                Intent int3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/"));
                startActivity(int3);
                return true;
            }
            else if (id == 1){
                String uobnum = "1800-222-2121";
                Intent int4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ uobnum));
                startActivity(int4);
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }

}