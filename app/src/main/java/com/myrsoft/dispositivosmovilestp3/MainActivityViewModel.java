package com.myrsoft.dispositivosmovilestp3;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.myrsoft.dispositivosmovilestp3.modelo.Libro;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private List<Libro> lista;
    private MutableLiveData<Libro> libroMutable;
    private MutableLiveData<String> mensajeMutable;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMensajeMutable(){
        if(mensajeMutable == null){
            mensajeMutable = new MutableLiveData<>();
        }
        return mensajeMutable;
    }
    public LiveData<Libro> getLibroMutable(){
        if(libroMutable == null){
            libroMutable = new MutableLiveData<>();
        }
        return libroMutable;
    }
    public void cargarLibros() {
        if (lista == null) {
            lista = new ArrayList<>();
            lista.add(new Libro("George Orwell", "1984", R.drawable.uno, "Ciencia Ficción", "Una novela distópica"));
            lista.add(new Libro("Gabriel García Márquez", "Crónica de una muerte anunciada", R.drawable.dos, "Realismo mágico", "Una novela de amor y decadencia"));
            lista.add(new Libro("Ray Bradbury", "Fahrenheit 451", R.drawable.tres, "Ciencia Ficción", "Una novela de ciencia ficción"));
            lista.add(new Libro("Bram Stoker", "Dracula", R.drawable.cuatro, "Terror", "Una novela de terror"));
            lista.add(new Libro("Miguel de Cervantes", "Don Quijote de la Mancha", R.drawable.cinco, "Novela", "Una novela de aventuras"));
        }
    }

    public void buscarLibro(String titulo) {
        cargarLibros();
        Libro libroEncontrado = null;

        for(Libro libro:lista) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libroEncontrado = libro;
                break;
            }
        }
        if (libroEncontrado != null) {
            libroMutable.setValue(libroEncontrado);
        }else {
            mensajeMutable.setValue("Libro no encontrado");
        }
    }
    public void mostrarResultado(Libro libro) {
        Intent intent = new Intent(getApplication(), ResultadoActivity.class);
        intent.putExtra("Libro", libro);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(intent);
    }
}
