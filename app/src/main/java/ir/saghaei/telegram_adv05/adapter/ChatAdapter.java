package ir.saghaei.telegram_adv05.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import ir.saghaei.telegram_adv05.DetailActivity;
import ir.saghaei.telegram_adv05.R;
import ir.saghaei.telegram_adv05.databinding.RecycleviewItemChatBinding;
import ir.saghaei.telegram_adv05.room.entity.en_chat;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    Context context;
    List<en_chat> list;

    public ChatAdapter(Context context,List<en_chat> list){
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleviewItemChatBinding binding = RecycleviewItemChatBinding
                .inflate(LayoutInflater.from(parent.getContext()));
        return new ChatViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull final ChatViewHolder holder, int position) {
        final en_chat chat = list.get(position);
        holder.binding.imgItemrecyc.setImageResource(chat.getPic());
        holder.binding.tvNameRecycitem.setText(chat.getName());
        holder.binding.tvDetailRecycitem.setText(chat.getText_received());
        holder.binding.tvTimeRecycitem.setText(chat.getTime_received());
        holder.binding.tvUnreadmsgRecycitem.setBackgroundResource(R.drawable.ic_tik_send);
        int isread = chat.getRead();
        if (chat.getRead() == 0){
            holder.binding.tvUnreadmsgRecycitem.setBackgroundResource(R.drawable.ic_tik_send);
        }else holder.binding.tvUnreadmsgRecycitem.setBackgroundResource(R.drawable.ic_tik_seen);


        holder.binding.layoutRecycleitemchat.setOnClickListener(new View.OnClickListener() {
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

        RecycleviewItemChatBinding binding;

        public ChatViewHolder(@NonNull RecycleviewItemChatBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }
    }

}
