package by.shug.practicemain.fragments.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import by.shug.practicemain.R;
import by.shug.practicemain.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    FragmentMainBinding binding;
    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        //
        listeners();
    }

    private void listeners() {
        binding.btnBack.setOnClickListener(v -> navController.navigateUp());
        binding.btnAvn.setOnClickListener(v -> openWebPage());
        binding.btnSchedule.setOnClickListener(v -> navController.navigate(R.id.action_mainFragment_to_scheduleFragment));
        binding.btnClass.setOnClickListener(v -> navController.navigate(R.id.action_mainFragment_to_classesFragment));
        binding.btnPart.setOnClickListener(v -> navController.navigate(R.id.action_mainFragment_to_educationFragment));
        binding.btnContacts.setOnClickListener(v -> navController.navigate(R.id.action_mainFragment_to_contactsFragment));
    }

    private void openWebPage() {
        Uri webpage = Uri.parse("https://avn.kstu.kg");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }
}