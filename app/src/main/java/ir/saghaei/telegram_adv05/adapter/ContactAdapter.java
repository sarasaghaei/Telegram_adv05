package ir.saghaei.telegram_adv05.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.saghaei.telegram_adv05.DetailActivity;
import ir.saghaei.telegram_adv05.databinding.ContactLayoutBinding;
import ir.saghaei.telegram_adv05.room.entity.en_chat;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ChatViewHolder> {
    Context context;
    List<en_chat> list;

    public ContactAdapter(Context context, List<en_chat> list){
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactLayoutBinding binding = ContactLayoutBinding
                .inflate(LayoutInflater.from(parent.getContext()));
        return new ChatViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull final ChatViewHolder holder, int position) {
        final en_chat chat = list.get(position);
        holder.binding.imgUserchat.setImageResource(chat.getPic());
        holder.binding.tvNamechat.setText(chat.getName());
        holder.binding.tvNamechat.setTextColor(Color.BLACK);
        holder.binding.layotContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name",chat.getName());
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ChatViewHolder extends RecyclerView.ViewHolder{

        ContactLayoutBinding binding;

        public ChatViewHolder(@NonNull ContactLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }
    }

}
