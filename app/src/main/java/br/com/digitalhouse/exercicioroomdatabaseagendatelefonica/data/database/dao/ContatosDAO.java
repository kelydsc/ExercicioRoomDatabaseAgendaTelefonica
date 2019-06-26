package br.com.digitalhouse.exercicioroomdatabaseagendatelefonica.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.digitalhouse.exercicioroomdatabaseagendatelefonica.model.Contato;
import io.reactivex.Flowable;

@Dao
public interface ContatosDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Contato contato);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Contato> contatos);

    @Update
    void update(Contato contato);

    @Delete
    void delete(Contato contato);

    @Query("SELECT * FROM contatos")
    List<Contato> getAll();

    @Query("SELECT * FROM contatos")
    Flowable<List<Contato>> getAllRxJava();

    @Query("SELECT * FROM contatos WHERE id = :id")
    Contato getById(long id);

    @Query("SELECT * FROM contatos WHERE nome = :nome")
    Contato getByName(String nome);

    //@Query("SELECT * FROM contatos WHERE nome = :nome AND telefone = :telefone")
    //Contato getByName(String nome, String telefone);
}
