package by.shug.practicemain.fragments.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.shug.practicemain.databinding.FragmentScheduleBinding;

public class ScheduleFragment extends Fragment {

    FragmentScheduleBinding binding;
    NavController navController;
    ScheduleAdapter adapter;
    List<ScheduleModel> scheduleList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentScheduleBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        fillList();
        adapter = new ScheduleAdapter();
        binding.rvSchedule.setAdapter(adapter);
        binding.btnBack.setOnClickListener(v -> navController.navigateUp());
        binding.rgGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != -1) {
                RadioButton selectedGroup = view.findViewById(checkedId);
                String selectedText = selectedGroup.getText().toString();

                List<ScheduleModel> filteredList = filterByGroup(scheduleList, selectedText);
                adapter.setData(filteredList);
                //
                binding.rvSchedule.setVisibility(View.VISIBLE);
                binding.tvChose.setVisibility(View.GONE);
            }
        });
    }

    private void fillList() {
        scheduleList = Arrays.asList(
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там,  что то там, что то там, что то там, что то там, что то там, что то там, что то там, что то там, что то там, что то там, что то там,", "group5"),
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там, ", "group1"),
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там, ", "group1"),
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там, ", "group1"),
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там, ", "group1"),
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там, ", "group1"),
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там, ", "group3"),
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там, ", "group3"),
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там, ", "group2"),
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там, ", "group3"),
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там, ", "group2"),
                new ScheduleModel("ПH", "18:20", "20:22", "Lorem ipsum dolor amet фиг его знает что то там, что то там, что то там, что то там, что то там, ", "group5")
        );
    }

    public static List<ScheduleModel> filterByGroup(List<ScheduleModel> scheduleList, String group) {
        List<ScheduleModel> filteredList = new ArrayList<>();

        for (ScheduleModel schedule : scheduleList) {
            if (schedule.getGroup().equalsIgnoreCase(group)) {
                filteredList.add(schedule);
            }
        }

        return filteredList;
    }

}