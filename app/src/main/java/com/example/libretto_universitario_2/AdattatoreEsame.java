package com.example.libretto_universitario_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.List;

public class AdattatoreEsame extends BaseAdapter {

    private Context context;
    private List<Esame> data;

    public AdattatoreEsame(Context context, List<Esame> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.esame_view, null);
        }
        TextView textViewNome = convertView.findViewById(R.id.textViewNome);
        TextView textViewCfu = convertView.findViewById(R.id.textViewCfu);
        TextView textViewVoto = convertView.findViewById(R.id.textViewVoto);
        Esame esame = data.get(position);
        textViewNome.setText(esame.getNome());
        textViewCfu.setText(esame.getCfu()+" CFU");
        textViewVoto.setText(esame.getVoto()+"");

        ImageButton buttonElimina = convertView.findViewById(R.id.buttonElimina);
        buttonElimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog(esame);

            }
        });
        return convertView;
    }

    private void showConfirmationDialog(Esame esame) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Conferma eliminazione");
        builder.setMessage("Vuoi eliminare questo esame?");

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Azione confermata
                performAction(esame);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Azione annullata
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void performAction(Esame esame) {
        // Esegui l'azione confermata
        data.remove(esame);
        notifyDataSetChanged();
        Toast.makeText(context, "Esame eliminato", Toast.LENGTH_SHORT).show();
    }
}
