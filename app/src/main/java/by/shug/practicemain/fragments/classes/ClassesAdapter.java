package by.shug.practicemain.fragments.classes;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import by.shug.practicemain.databinding.ItemClassesBinding;

public class ClassesAdapter extends RecyclerView.Adapter<ClassesAdapter.MyViewHolder> {

    private List<ClassesModel> dataList;

    public void setData(List<ClassesModel> dataList) {
        this.dataList = dataList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemClassesBinding binding;

        public MyViewHolder(ItemClassesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ClassesModel data) {
            binding.tvNumber.setText(data.getNumber());
            binding.tvDesc.setText(data.getDescription());
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemClassesBinding binding = ItemClassesBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ClassesModel data = dataList.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
