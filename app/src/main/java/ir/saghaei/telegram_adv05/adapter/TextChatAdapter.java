package ir.saghaei.telegram_adv05.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.saghaei.telegram_adv05.R;
import ir.saghaei.telegram_adv05.databinding.RecyclechatBinding;
import ir.saghaei.telegram_adv05.room.entity.en_chat;

public class TextChatAdapter extends RecyclerView.Adapter<TextChatAdapter.ChatViewHolder> {

    Context context;
    List<en_chat> list;

    public TextChatAdapter(Context context, List<en_chat> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclechatBinding binding = RecyclechatBinding
                .inflate(LayoutInflater.from(parent.getContext()));
        return new ChatViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        final en_chat textchat = list.get(position);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_END);

        if (textchat.getText_received().equals("")){
            holder.binding.tvTextchat.setText(textchat.getText_send());
            holder.binding.tvTextchat.setBackgroundColor(Color.GREEN);
            holder.binding.layout.setGravity(Gravity.END);
            params.addRule(RelativeLayout.ALIGN_PARENT_END);
            params.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            holder.binding.tvTextchat.setLayoutParams(params);
            holder.binding.tvTextchat.setBackgroundResource(R.drawable.shape_send);
        }else {
            holder.binding.tvTextchat.setText(textchat.getText_received());
            holder.binding.tvTextchat.setBackgroundColor(Color.WHITE);
            holder.binding.tvTextchat.setGravity(Gravity.START);
            holder.binding.tvTextchat.setBackgroundResource(R.drawable.shape_resived);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder{

        RecyclechatBinding binding;

        public ChatViewHolder(@NonNull RecyclechatBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }




}
