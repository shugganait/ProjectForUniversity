package by.shug.practicemain.fragments.contacts;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import by.shug.practicemain.databinding.ItemContactsBinding;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private List<ContactsModel> dataList;
    private final OnContactClickListener contactListener;

    public ContactsAdapter(OnContactClickListener contactListener) {
        this.contactListener = contactListener;
    }

    public void setData(List<ContactsModel> dataList) {
        this.dataList = dataList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemContactsBinding binding;

        public MyViewHolder(ItemContactsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ContactsModel data) {
            binding.tvNumber.setText(data.getNumber());
            binding.tvName.setText(data.getName());
            binding.tvStatus.setText(data.getStatus());

            binding.btnCall.setOnClickListener(v -> {
                if (contactListener != null) {
                    contactListener.onCallClick(data.getNumber());
                }
            });

            binding.btnCopy.setOnClickListener(v -> {
                if (contactListener != null) {
                    contactListener.onCopyClick(data.getNumber());
                }
            });
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemContactsBinding binding = ItemContactsBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ContactsModel data = dataList.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
