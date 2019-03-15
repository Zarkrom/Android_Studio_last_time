package com.example.marobine.premierprojet.outils;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public abstract class RecupFichier {
    public static void ajouterDansFichier(String filename, Object object, Context
            context) {
        try {
            FileOutputStream fichier = context.openFileOutput(filename,
                    Context.MODE_PRIVATE);
            ObjectOutputStream objectStream;
            try {
                objectStream = new ObjectOutputStream(fichier);
                objectStream.writeObject(object);
                objectStream.flush();
                objectStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Object recupererDansFichier(String filename, Context context) {
        try {
            FileInputStream fichier = context.openFileInput(filename);
            ObjectInputStream objectStream;
            try {
                objectStream = new ObjectInputStream(fichier);
                try {

                    Object object = objectStream.readObject();
                    objectStream.close();
                    return object;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }catch (StreamCorruptedException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}