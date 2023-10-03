package com.example.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private Context context;
    private List<Student> students; // list student để truyền cho Adapter

    public StudentAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Student> students) {
        this.students = students;
        notifyDataSetChanged(); // load dữ liệu vào trong StudentAdapter
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Khai báo 1 view. View này chính là item trong RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = students.get(position);

        // Nếu như tại 1 vị trí trong RecyclerView có item là null thì không làm gì
        if(student == null)
            return;

        // Ngược lại khi vị trí là 1 item khác null thì ta load id và name lên
        holder.tvId.setText(student.getId());
        holder.tvName.setText(student.getName());
    }

    @Override
    public int getItemCount() {
        if(students != null)
            return students.size();

        return 0;
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        // Khai báo các thành phần có trong item_student.xml
        private TextView tvId;
        private TextView tvName;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
