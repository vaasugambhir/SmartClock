package com.example.smartclock;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> {

    private ArrayList<String> mAlarmList;
    private ArrayList<Boolean> mSwitchStates;
    private ArrayList<Integer> mMusic;

    private OnItemClickListener mListener;


    public interface OnItemClickListener{
        void onDeleteClick(int pos);
        void onSwitchClick(int pos);
        void onTextClick(int pos);
        void onAlarmClick(int pos);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public AlarmAdapter(ArrayList<String> list, ArrayList<Boolean> switchStates, ArrayList<Integer> musicList) {
        this.mAlarmList = list;
        this.mSwitchStates = switchStates;
        this.mMusic = musicList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alarm_card_item, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.alarm.setText(mAlarmList.get(position));
        holder.alarmOnOff.setChecked(mSwitchStates.get(position));
        String text = "Music " + mMusic.get(position);
        holder.musicID.setText(text);
    }

    @Override
    public int getItemCount() {
        return mAlarmList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements OnItemClickListener{

        TextView alarm;
        Button delete;
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch alarmOnOff;
        TextView musicID;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            alarm = itemView.findViewById(R.id.alarm_time);
            delete = itemView.findViewById(R.id.delete_alarm);
            alarmOnOff = itemView.findViewById(R.id.alarm_on_off);
            musicID = itemView.findViewById(R.id.music_id);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION)
                            listener.onDeleteClick(pos);
                    }
                }
            });

            alarmOnOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION)
                            listener.onSwitchClick(pos);
                    }
                }
            });

            musicID.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION)
                            listener.onTextClick(pos);
                    }
                }
            });

            alarm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION)
                            listener.onAlarmClick(pos);
                    }
                }
            });
        }

        @Override
        public void onDeleteClick(int pos) {
        }

        @Override
        public void onSwitchClick(int pos) {
        }

        @Override
        public void onTextClick(int pos) {

        }

        @Override
        public void onAlarmClick(int pos) {

        }
    }
}
