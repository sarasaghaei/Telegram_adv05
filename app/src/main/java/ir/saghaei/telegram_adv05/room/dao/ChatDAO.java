package ir.saghaei.telegram_adv05.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import ir.saghaei.telegram_adv05.room.entity.en_chat;


@Dao
public interface ChatDAO {

    @Insert
    Long insert(en_chat chat);

    @Query("Select * from en_chat WHERE category = :category")
    List<en_chat> select_cat(String category);

    @Query("Select * from en_chat WHERE read = :read")
    List<en_chat> select_unread(int read);

    @Query("Select * from en_chat WHERE name = :name")
    List<en_chat> select_textchat(String name);

    @Query("Select * from en_chat WHERE name = :name")
    en_chat select_userprofile(String name);


    @Query("SELECT * FROM en_chat" )
    List<en_chat> getall();

    @Query("update en_chat set read = :isread  WHERE name = :name")
    void update_unread(String name, int isread);






}
