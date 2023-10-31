package com.example.exercise3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ItemViewHolder> {
    private Context context;
    private List<Event> events;
    private boolean isToggleShowHideEventChecked; // kiểm tra xem toggle hiện các sự kiện disable có được check không
    DatabaseHelper db;

    public EventAdapter(Context context) {
        this.context = context;
        isToggleShowHideEventChecked = false;

        // Khởi tạo 1 đối tượng SQLite
        db = new DatabaseHelper(context);
    }

    public void setData() {
        this.events = db.getAllData(); // Load data từ SQLite
        notifyDataSetChanged();
    }

    public void removeAll() {
        // Xóa trong SQLite
        for(Event e : events)
            db.deleteData(e.getId());
        
        events.clear();
        
        notifyDataSetChanged();
    }

    public void showHideEvent(boolean isChecked) {
        isToggleShowHideEventChecked = isChecked;
        notifyDataSetChanged();
    }

    public void addNewEvent(Event event) {
        // Thêm vào SQLite
        db.insertData(event);
        events.add(event); 
        
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.event, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Event event = events.get(position);

        // Ẩn các event bị disable
        if((event == null || !event.getEnable()) && !isToggleShowHideEventChecked) {
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            return;
        }

        // Hiện lại các item bị disable
        holder.itemView.setVisibility(View.VISIBLE);
        holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        holder.tvSubject.setText(event.getSubject());
        holder.tvRoom.setText(event.getRoom());
        holder.tvDate.setText(event.getDate());
        holder.sEnable.setChecked(event.getEnable());

        // Gán sự kiện checked change cho từng Switch
        holder.sEnable.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            int clickedItemPosition = holder.getAdapterPosition();
            Event e = events.get(clickedItemPosition);
            
            if (isChecked) {
                e.setEnable(true);
                db.updateData(e.getId(), true); // Sửa trong SQLite
            }
            else {
                e.setEnable(false);
                db.updateData(e.getId(), false); // Sửa trong SQLite
            }
            
            notifyDataSetChanged();
        });

        // Hiển thị context menu khi nhấn giữ 1 sự kiện
        holder.itemView.setOnLongClickListener(v -> {
            v.showContextMenu();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        if(events != null)
            return events.size();

        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSubject;
        private TextView tvRoom;
        private TextView tvDate;
        private Switch sEnable;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSubject = itemView.findViewById(R.id.tvSubject);
            tvRoom = itemView.findViewById(R.id.tvRoom);
            tvDate = itemView.findViewById(R.id.tvDate);
            sEnable = itemView.findViewById(R.id.sEnable);
        }
    }
}
