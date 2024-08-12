package by.shug.practicemain.fragments.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.shug.practicemain.R;
import by.shug.practicemain.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    //ЭКРАН С ПРИВЕТСТВИЕМ, НЕ РЕГИСТРАЦИЯ

    FragmentLoginBinding binding;
    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //инициализация Binding
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //инициализация NavController для навигаций
        navController = Navigation.findNavController(view);
        //
        binding.btnLogin.setOnClickListener(v -> navController.navigate(R.id.action_loginFragment_to_mainFragment));
    }
}