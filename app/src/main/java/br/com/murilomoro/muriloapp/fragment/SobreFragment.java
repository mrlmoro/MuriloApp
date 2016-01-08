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
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import br.com.murilomoro.muriloapp.R;
import br.com.murilomoro.muriloapp.model.Sobre;

/**
 * Created by Murilo on 07/01/2016.
 */
public class SobreFragment extends Fragment {

    private SimpleDraweeView simpleDraweeView;
    private Button btnFacebook, btnEmail;
    private TextView txtSobre, txtNome;
    private Sobre sobre;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_sobre,
                null);

        simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.frescoSobre);
        btnFacebook = (Button) view.findViewById(R.id.btnFacebook);
        btnEmail = (Button) view.findViewById(R.id.btnEmail);
        txtSobre = (TextView) view.findViewById(R.id.txtSobre);
        txtNome = (TextView) view.findViewById(R.id.txtNome);

        if (NavigationDrawerFragment.getUriImage() != null)
            simpleDraweeView.setImageURI(NavigationDrawerFragment.getUriImage());

        sobre = new Sobre();
        txtNome.setText(sobre.getNome());
        txtSobre.setText(sobre.getTextSobre());

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getActivity().getPackageManager().getPackageInfo("com.facebook.katana", 0);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/murilo.moro.12")));
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/murilo.moro.12")));
                }
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailer = new Intent(Intent.ACTION_SEND);
                mailer.setType("text/plain");
                mailer.putExtra(Intent.EXTRA_EMAIL, new String[]{sobre.getEmail()});
                startActivity(Intent.createChooser(mailer, "Enviar email..."));
            }
        });

        return view;
    }
}
