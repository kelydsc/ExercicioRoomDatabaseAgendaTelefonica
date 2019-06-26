package br.com.digitalhouse.exercicioroomdatabaseagendatelefonica.data.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import br.com.digitalhouse.exercicioroomdatabaseagendatelefonica.data.database.dao.ContatosDAO;
import br.com.digitalhouse.exercicioroomdatabaseagendatelefonica.model.Contato;

@android.arch.persistence.room.Database(entities = {Contato.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class Database extends RoomDatabase {
    private static volatile Database INSTANCE;

    public abstract ContatosDAO contatosDAO();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "my_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}