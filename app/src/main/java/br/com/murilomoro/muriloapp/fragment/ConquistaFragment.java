package br.com.murilomoro.muriloapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.drawee.view.SimpleDraweeView;
import br.com.murilomoro.muriloapp.R;

/**
 * Created by Murilo on 08/01/2016.
 */
public class ConquistaFragment extends Fragment {

    private SimpleDraweeView simpleDraweeView;
    private Button btnOpenMEmp;
    private String urlConquista = "http://pnsdr.com/img/frase/al/do/aldo_novak_sonhos_determinam_o_que_voce_quer_acao_deter_wj99qp.jpg";
    private String PACKAGE = "br.com.morosistemas.mempvendas";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_conquistas,
                null);

        simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.frescoConquista);
        btnOpenMEmp = (Button) view.findViewById(R.id.btnOpenMEmp);

        simpleDraweeView.setImageURI(Uri.parse(urlConquista));

        btnOpenMEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + PACKAGE)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + PACKAGE)));
                }
            }
        });
        return view;
    }
}
