package com.isaac.comentariosestaticos.network;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isaac.comentariosestaticos.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EntradaInfoComentario implements Parcelable {
    private static final String TAG = EntradaInfoComentario.class.getSimpleName();

    public final Uri urlDinamica;
    public final String url;
    public final String usuario;
    public final String comentario;
    public final String publicacion;

    public EntradaInfoComentario(String usuario, String urlDinamica, String url, String comentario, String publicacion){
        this.usuario = usuario;
        this.urlDinamica = Uri.parse(urlDinamica);
        this.url = url;
        this.comentario = comentario;
        this.publicacion = publicacion;
    }

    protected EntradaInfoComentario(Parcel in) {
        urlDinamica = in.readParcelable(Uri.class.getClassLoader());
        url = in.readString();
        usuario = in.readString();
        comentario = in.readString();
        publicacion = in.readString();
    }

    public static final Creator<EntradaInfoComentario> CREATOR = new Creator<EntradaInfoComentario>() {
        @Override
        public EntradaInfoComentario createFromParcel(Parcel in) {
            return new EntradaInfoComentario(in);
        }

        @Override
        public EntradaInfoComentario[] newArray(int size) {
            return new EntradaInfoComentario[size];
        }
    };

    public static List<EntradaInfoComentario> listaInfoComentarios (Resources resources){
        InputStream inputStream = resources.openRawResource(R.raw.comentarios);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;

            while ((pointer = reader.read(buffer)) != -1){
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception){
            Log.e(TAG, "HUBO UN ERROR AL MOMENTO DE LEER Y ESCRIBIR EL ARCHIVO");

        } finally {
            try {
                inputStream.close();
            } catch (IOException exception){
                Log.e(TAG, "Hubo un error al cerrar el input stream", exception);
            }
        }

        String jsonComentariosString = writer.toString();

        Gson gson = new Gson();
        Type listaTipoComentario = new TypeToken<ArrayList<EntradaInfoComentario>>(){}.getType();

        return gson.fromJson(jsonComentariosString, listaTipoComentario);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(urlDinamica, i);
        parcel.writeString(url);
        parcel.writeString(usuario);
        parcel.writeString(comentario);
        parcel.writeString(publicacion);
    }
}
