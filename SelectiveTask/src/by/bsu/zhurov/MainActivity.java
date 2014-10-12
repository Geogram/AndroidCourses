package by.bsu.zhurov;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private XMLParser manager = new XMLParser();
    private ArrayList<Event> events;
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        if (null != searchView) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setIconifiedByDefault(false);
        }
        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener( ) {
            public boolean onQueryTextChange( String newText ) {
                return true;
            }
            public boolean onQueryTextSubmit(String query) {
                manager.createXMLFile(query);
                events = manager.parseXMLFile();
                paintList();
                events.clear();
                return true;
            }
        };
        searchView.setOnQueryTextListener(queryTextListener);
    }
    public void paintList () {
        mainListView = (ListView) findViewById(R.id.listView);
        ArrayList<String> items = new ArrayList<String>();
        if(!events.isEmpty())
            for(Event e :events)
                items.add(e.eventToString());
        else
            items.add("There is no concerts of this band.");
        listAdapter = new ArrayAdapter<String>(this, R.layout.row,items);
        mainListView.setAdapter(listAdapter);
    }
}
