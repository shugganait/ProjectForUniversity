package by.shug.practicemain.fragments.schedule;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import by.shug.practicemain.databinding.ItemScheduleBinding;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.MyViewHolder> {

    private List<ScheduleModel> dataList;

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<ScheduleModel> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemScheduleBinding binding;

        public MyViewHolder(ItemScheduleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ScheduleModel data) {
            binding.tvStartTime.setText(data.getStart());
            binding.tvEndTime.setText(data.getEnd());
            binding.tvDescription.setText(data.getDescription());
            binding.tvDay.setText(data.getDay());
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemScheduleBinding binding = ItemScheduleBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ScheduleModel data = dataList.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
