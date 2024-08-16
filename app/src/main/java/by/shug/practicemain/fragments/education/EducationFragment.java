package by.shug.practicemain.fragments.education;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.Arrays;
import java.util.List;

import by.shug.practicemain.R;
import by.shug.practicemain.databinding.FragmentEducationBinding;

public class EducationFragment extends Fragment {

    FragmentEducationBinding binding;
    NavController navController;
    PointsAdapter adapter;
    List<PointsModel> pointsList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEducationBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        fillList();
        adapter = new PointsAdapter();
        binding.rvPoints.setAdapter(adapter);
        adapter.setData(pointsList);
        binding.btnBack.setOnClickListener(v -> navController.navigateUp());
    }

    private void fillList() {
        pointsList = Arrays.asList(
                new PointsModel("Баллы", "Буква", "Описание", "<Содержание оценки>"),
                new PointsModel("87-100", "A", "Отлично", getString(R.string.first)),
                new PointsModel("80-86", "B", "Хорошо", getString(R.string.second)),
                new PointsModel("74-79", "C", "Хорошо", getString(R.string.third)),
                new PointsModel("68-73", "D", "Удовлетворительно", getString(R.string.fourth)),
                new PointsModel("61-67", "E", "Удовлетворительно", getString(R.string.fifth)),
                new PointsModel("41-60", "FX", "Неудовлетворительно", getString(R.string.sixth)),
                new PointsModel("0-60", "F", "Неудовлетворительно", getString(R.string.seventh))
        );
    }

}