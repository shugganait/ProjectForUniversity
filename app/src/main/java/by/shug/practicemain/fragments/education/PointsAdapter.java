package by.shug.practicemain.fragments.education;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import by.shug.practicemain.databinding.ItemPointsBinding;

public class PointsAdapter extends RecyclerView.Adapter<PointsAdapter.MyViewHolder> {

    private List<PointsModel> dataList;

    public void setData(List<PointsModel> dataList) {
        this.dataList = dataList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemPointsBinding binding;

        public MyViewHolder(ItemPointsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PointsModel data) {
            binding.tvPoint.setText(data.getPoint());
            binding.tvLetterPoint.setText(data.getLetter());
            binding.tvDescription.setText(data.getDescription());
            binding.tvPointDescription.setText(data.getPointDescription());
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPointsBinding binding = ItemPointsBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PointsModel data = dataList.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
