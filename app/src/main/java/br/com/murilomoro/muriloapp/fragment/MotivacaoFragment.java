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
public class MotivacaoFragment extends Fragment {

    private SimpleDraweeView simpleDraweeView;
    private String urlMotivacao = "http://static.frasesparaface.com.br/imagem/n/e/nenhum-obstaculo-sera-grande-se-a-sua-vontade.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_motivacoes,
                null);

        simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.frescoMotivacao);
        simpleDraweeView.setImageURI(Uri.parse(urlMotivacao));

        return view;
    }
}
