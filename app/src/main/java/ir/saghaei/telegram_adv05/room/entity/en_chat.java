package ir.saghaei.telegram_adv05.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class en_chat {
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    int chat_id;

    @ColumnInfo
    String name;

    @ColumnInfo
    String tell;

    @ColumnInfo
    String text_send;

    @ColumnInfo
    String text_received;

    @ColumnInfo
    String time_send;

    @ColumnInfo
    String time_received;

    @ColumnInfo
    String category;

    @ColumnInfo
    int pic;

    @ColumnInfo
    int read;

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getText_send() {
        return text_send;
    }

    public void setText_send(String text_send) {
        this.text_send = text_send;
    }

    public String getText_received() {
        return text_received;
    }

    public void setText_received(String text_received) {
        this.text_received = text_received;
    }

    public String getTime_send() {
        return time_send;
    }

    public void setTime_send(String time_send) {
        this.time_send = time_send;
    }

    public String getTime_received() {
        return time_received;
    }

    public void setTime_received(String time_received) {
        this.time_received = time_received;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public en_chat(String name, String tell, String text_send, String text_received, String time_send,
                   String time_received, String category, int pic, int read) {
        this.name = name;
        this.tell = tell;
        this.text_send = text_send;
        this.text_received = text_received;
        this.time_send = time_send;
        this.time_received = time_received;
        this.category = category;
        this.pic = pic;
        this.read = read;
    }
}
