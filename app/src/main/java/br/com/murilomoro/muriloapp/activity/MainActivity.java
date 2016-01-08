package br.com.murilomoro.muriloapp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.facebook.drawee.backends.pipeline.Fresco;

import br.com.murilomoro.muriloapp.R;
import br.com.murilomoro.muriloapp.fragment.ConquistaFragment;
import br.com.murilomoro.muriloapp.fragment.MotivacaoFragment;
import br.com.murilomoro.muriloapp.fragment.NavigationDrawerFragment;
import br.com.murilomoro.muriloapp.fragment.ObjetivosFragment;
import br.com.murilomoro.muriloapp.fragment.SobreFragment;
import br.com.murilomoro.muriloapp.util.AndroidUtil;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.tbMain);
        setSupportActionBar(mToolbar);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);


        if(!AndroidUtil.isConnected(this))
            AndroidUtil.makeText(this, "Caso não consiga visualizar as imagens,\native sua conexão com a internet!");


        if (savedInstanceState == null)
            selectedItem(0);
    }

    public void selectedItem(int position) {
        switch (position) {
            case 0:
                mToolbar.setSubtitle("Sobre");
                inicializaFragment(new SobreFragment());
                break;
            case 1:
                mToolbar.setSubtitle("Conquistas");
                inicializaFragment(new ConquistaFragment());
                break;
            case 2:
                mToolbar.setSubtitle("Objetivos");
                inicializaFragment(new ObjetivosFragment());
                break;
            default:
                mToolbar.setSubtitle("Motivações");
                inicializaFragment(new MotivacaoFragment());
                break;
        }

    }

    private void inicializaFragment(Fragment frag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layoutCentral, frag);
        fragmentTransaction.commit();
    }



}
