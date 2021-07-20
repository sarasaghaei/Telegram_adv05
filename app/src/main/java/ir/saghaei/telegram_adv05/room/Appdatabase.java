package ir.saghaei.telegram_adv05.room;

import android.app.Application;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ir.saghaei.telegram_adv05.Const;
import ir.saghaei.telegram_adv05.room.dao.ChatDAO;
import ir.saghaei.telegram_adv05.room.entity.en_chat;

@Database(entities = {en_chat.class}, version = 1)
public abstract class Appdatabase extends RoomDatabase {

    public abstract ChatDAO getChatDAO();

    public static Appdatabase instanc;
    public static Appdatabase getInstance(Context context) {
        if (instanc == null){
            instanc = Room
                    .databaseBuilder(context.getApplicationContext(),Appdatabase.class, Const.DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instanc;
    }



}
