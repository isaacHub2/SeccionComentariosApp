package com.isaac.comentariosestaticos.app;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class ComentariosApp extends Application {
    private static ComentariosApp instancia;
    private static Context contextoApp;

    public static ComentariosApp getInstance(){
        return instancia;
    }

    public static Context getAppContext(){
        return contextoApp;
    }

    public void setAppContext(Context mAppContext){
        this.contextoApp = mAppContext;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        instancia = this;

        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
