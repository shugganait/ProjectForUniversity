package by.shug.practicemain.fragments.classes;

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
import by.shug.practicemain.databinding.FragmentClassesBinding;

public class ClassesFragment extends Fragment {

    FragmentClassesBinding binding;
    NavController navController;
    ClassesAdapter adapter;
    List<ClassesModel> classesList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentClassesBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        fillList();
        adapter = new ClassesAdapter();
        adapter.setData(classesList);
        binding.rvClasses.setAdapter(adapter);

        binding.btnBack.setOnClickListener(v -> navController.navigateUp());
    }

    private void fillList() {
        classesList = Arrays.asList(
                new ClassesModel("2/61", getString(R.string.first_class)),
                new ClassesModel("2/619", getString(R.string.second_class)),
                new ClassesModel("2/624", getString(R.string.third_class)),
                new ClassesModel("2/602", getString(R.string.fourth_class))
        );
    }
}