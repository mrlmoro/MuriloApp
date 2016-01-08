package br.com.murilomoro.muriloapp.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import br.com.murilomoro.muriloapp.R;
import br.com.murilomoro.muriloapp.activity.MainActivity;

/**
 * Created by Murilo on 07/01/2016.
 */
public class NavigationDrawerFragment extends Fragment {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View containerView;
    private ListView lvMenu;
    private SimpleDraweeView draweeView;
    private List<String> mList;
    private static Uri uri = null;
    private String urldisplay = "https://scontent-gru2-1.xx.fbcdn.net/hphotos-xpl1/v/t1.0-9/1794543_933498416740821_490655164016379690_n.jpg?oh=52ad8f2cd87c0fc60c8b27722edaafa1&oe=57044FB1";

    public NavigationDrawerFragment() {

    }

    public static  Uri getUriImage(){
        return uri;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_navigation_drawer, null);

        lvMenu = (ListView) v.findViewById(R.id.lvMenuDrawer);
        draweeView = (SimpleDraweeView) v.findViewById(R.id.frescoImage);

        uri = Uri.parse(urldisplay);

        mList = new ArrayList<String>();
        mList.add("Sobre");
        mList.add("Conquistas");
        mList.add("Objetivos");
        mList.add("Motivações");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, mList);
        lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MainActivity) getActivity()).selectedItem(position);

                mDrawerLayout.closeDrawer(containerView);
            }
        });

        return v;
    }

    public void setUp(int fragmentId, DrawerLayout dl, Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = dl;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), dl, toolbar,
                R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                draweeView.setImageURI(uri);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);


            }
        };


        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {

            @Override
            public void run() {
                mDrawerToggle.syncState();

            }
        });
    }


}
