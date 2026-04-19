package com.myrsoft.dispositivosmovilestp3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.myrsoft.dispositivosmovilestp3.databinding.ActivityResultadoBinding;
import com.myrsoft.dispositivosmovilestp3.modelo.Libro;

public class ResultadoActivity extends AppCompatActivity {
    private ActivityResultadoBinding binding;
    private ResultadoActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ResultadoActivityViewModel.class);

        vm.getLibroMutable().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {
                binding.edtTitulo.setText(libro.getTitulo());
                binding.edtAutor.setText(libro.getAutor());
                binding.edtDescripcion.setText(libro.getDescripcion());
                binding.edtGenero.setText(libro.getGenero());
                binding.ivFoto.setImageResource(libro.getPortada());
            }
        });
        vm.libroEncontrado(getIntent());

    }
}