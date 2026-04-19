package com.myrsoft.dispositivosmovilestp3;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.myrsoft.dispositivosmovilestp3.modelo.Libro;

public class ResultadoActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> libroMutable;
    public ResultadoActivityViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<Libro> getLibroMutable(){
        if(libroMutable == null){
            libroMutable = new MutableLiveData<>();
        }
        return libroMutable;
    }

    public void libroEncontrado(Intent intent){
        Libro libroEncontrado = (Libro) intent.getSerializableExtra("Libro");
        libroMutable.setValue(libroEncontrado);
    }

}
