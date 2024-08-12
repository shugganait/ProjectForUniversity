package by.shug.practicemain.fragments.contacts;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.Arrays;
import java.util.List;

import by.shug.practicemain.databinding.FragmentContactsBinding;

public class ContactsFragment extends Fragment implements OnContactClickListener {

    FragmentContactsBinding binding;
    NavController navController;
    ContactsAdapter adapter;
    List<ContactsModel> contactsList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContactsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        fillList();
        adapter = new ContactsAdapter(this);
        adapter.setData(contactsList);
        binding.rvContacts.setAdapter(adapter);

        binding.btnBack.setOnClickListener(v -> navController.navigateUp());
    }

    private void fillList() {
        contactsList = Arrays.asList(
                new ContactsModel("Турусбекова Айым Исаковна", "Cекретарь деканата ИИТ", "+996704692809"),
                new ContactsModel("Кудакеева Гулида Маданбековна", "Зам. директора по АР", "+996773244676"),
                new ContactsModel("Жаныбекова Гульмира Жаныбековна", "Методист деканата иит", "+996708778802"),
                new ContactsModel("Исраилова Нелла Амантаевна", "Кандидат технических наук, доцент", "+996705340620"),
                new ContactsModel("Момуналиева Нуризат Тыныбековна", "Старший преподаватель", "+996772010071"),
                new ContactsModel("Шаршеева Кундуз Токтобековна", "Cтарший преподаватель", "+996705780665"),
                new ContactsModel("Тультемирова Гульназ Усенбековна", "Cтарший преподаватель", "+996550150286"),
                new ContactsModel("Бакасова Пери Cултановна", "Преподаватель ", "+996555774318"),
                new ContactsModel("Эркинбек Алтынай", "Преподаватель", "+996550521722"),
                new ContactsModel("Еремин Алексей Сергеевич", "Преподаватель", "+996555991903")
        );
    }

    @Override
    public void onCallClick(String number) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:" + number));
        startActivity(dialIntent);
    }

    @Override
    public void onCopyClick(String number) {
        ClipboardManager clipboard = (ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied Text", number);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getContext(), "Скопировано в буфер обмена!", Toast.LENGTH_SHORT).show();
    }
}