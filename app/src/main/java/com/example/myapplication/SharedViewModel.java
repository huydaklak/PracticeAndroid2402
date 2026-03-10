package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private MutableLiveData<String> name = new MutableLiveData<>();

    public void setName(String name){
        this.name.setValue(name);
    }
    public LiveData<String> getName(){
        return name;
    }
}
