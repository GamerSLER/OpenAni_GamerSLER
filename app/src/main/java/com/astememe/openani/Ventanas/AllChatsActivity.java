package com.astememe.openani.Ventanas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.astememe.openani.Adaptador_Evento.RoomAdapter;
import com.astememe.openani.Django_Manager.Interfaces.DjangoClient;
import com.astememe.openani.Django_Manager.Models.RoomModel;
import com.astememe.openani.R;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class AllChatsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String token;
    SharedPreferences preferences;
    RoomAdapter adapter;
    List<RoomModel.RoomDetail> listaSalas = new ArrayList<>();
    ConstraintLayout flecha_hacia_atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_chats);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        flecha_hacia_atras = findViewById(R.id.flecha_hacia_atras);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        recyclerView = findViewById(R.id.recyclerViewChats);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RoomAdapter(this, listaSalas);
        recyclerView.setAdapter(adapter);
        cargarSalas();


        flecha_hacia_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllChatsActivity.this, MainAnime.class);
                startActivity(intent);
            }
        });
    }

    private void cargarSalas() {
        token = "Bearer " + preferences.getString("token", "");
        DjangoClient.getMessages_Interface().getRooms(token).enqueue(new Callback<RoomModel>() {
            @Override
            public void onResponse(Call<RoomModel> call, Response<RoomModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().getSalas().isEmpty()) {
                        Toast.makeText(AllChatsActivity.this, "No hay salas disponibles", Toast.LENGTH_SHORT).show();
                    } else {
                        listaSalas.addAll(response.body().getSalas());
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e("DEBUG", "Error en el servidor: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<RoomModel> call, Throwable t) {
                Toast.makeText(AllChatsActivity.this, "Fallo de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}