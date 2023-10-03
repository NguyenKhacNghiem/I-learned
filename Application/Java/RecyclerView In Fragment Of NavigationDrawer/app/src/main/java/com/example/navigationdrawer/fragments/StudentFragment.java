package com.example.navigationdrawer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.Student;
import com.example.navigationdrawer.StudentAdapter;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {
    private RecyclerView rcvStudent;
    private StudentAdapter studentAdapter;

    public StudentFragment() {

    }

    // Hiển thị Fragment
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student, container, false);
    }

    // Hiển thị thành phần trong Fragment. Các thành phần này không cài trước trong XML
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Adapter
        studentAdapter = new StudentAdapter(getContext());

        List<Student> students = getStudents();
        studentAdapter.setData(students);

        // Recycler View
        rcvStudent = view.findViewById(R.id.rcvStudent);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rcvStudent.setLayoutManager(linearLayoutManager);
        rcvStudent.setAdapter(studentAdapter);
    }

    // Lấy dữ liệu để đổ vào Adapter cho Recycler View
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        // Chỗ này làm đúng thì phải lấy từ database, gọi API,...
        students.add(new Student("S01", "Nguyễn Văn A"));
        students.add(new Student("S02", "Nguyễn Văn B"));
        students.add(new Student("S03", "Nguyễn Văn C"));
        students.add(new Student("S04", "Nguyễn Văn D"));
        students.add(new Student("S05", "Nguyễn Văn E"));
        students.add(new Student("S06", "Nguyễn Văn F"));
        students.add(new Student("S07", "Nguyễn Văn G"));
        students.add(new Student("S08", "Nguyễn Văn H"));
        students.add(new Student("S09", "Nguyễn Văn I"));
        students.add(new Student("S10", "Nguyễn Văn J"));
        students.add(new Student("S11", "Nguyễn Văn K"));
        students.add(new Student("S12", "Nguyễn Văn L"));
        students.add(new Student("S13", "Nguyễn Văn M"));
        students.add(new Student("S14", "Nguyễn Văn N"));
        students.add(new Student("S15", "Nguyễn Văn O"));
        students.add(new Student("S16", "Nguyễn Văn P"));
        students.add(new Student("S17", "Nguyễn Văn Q"));
        students.add(new Student("S18", "Nguyễn Văn R"));
        students.add(new Student("S19", "Nguyễn Văn S"));
        students.add(new Student("S20", "Nguyễn Văn T"));

        return students;
    }
}