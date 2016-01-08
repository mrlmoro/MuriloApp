package br.com.murilomoro.muriloapp.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import br.com.murilomoro.muriloapp.R;

/**
 * Created by Murilo on 08/01/2016.
 */
public class ObjetivosFragment extends Fragment {

    private SimpleDraweeView simpleDraweeView;
    private String urlObjetivo = "http://pnsdr.com/img/frase/al/be/albert_einstein_nao_se_deve_ir_atras_wl.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_objetivos,
                null);

        simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.frescoObjetivos);
        simpleDraweeView.setImageURI(Uri.parse(urlObjetivo));

        return view;
    }
}
