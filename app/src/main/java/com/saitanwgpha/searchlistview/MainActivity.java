package com.saitanwgpha.searchlistview;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class MainActivity extends Activity {

    ListView lv;
    SearchView sv;

    String[] names={"Juan Mata","Ander Herera","Wayne Rooney","Eden Hazard","Michael Carrick","Diego Costa","Jose Mourinho"};
    int[] images={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView) findViewById(R.id.listView1);
        sv=(SearchView) findViewById(R.id.searchView1);

        //ADASPTER
        final Adapter adapter=new Adapter(this, getPlayers());
        lv.setAdapter(adapter);

        sv.setOnQueryTextListener(new OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String arg0) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // TODO Auto-generated method stub

                adapter.getFilter().filter(query);

                return false;
            }
        });

    }

    private ArrayList<Player> getPlayers()
    {
        ArrayList<Player> players=new ArrayList<Player>();
        Player p;

        for(int i=0;i<names.length;i++)
        {
            p=new Player(names[i], images[i]);
            players.add(p);
        }

        return players;
    }

}