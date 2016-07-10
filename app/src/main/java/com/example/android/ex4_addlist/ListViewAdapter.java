package com.example.android.ex4_addlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Krivnon on 2016-07-10.
 */
public class ListViewAdapter extends BaseAdapter {
    private ArrayList<Player> playerArrayList = new ArrayList<Player>() ;

    public ListViewAdapter(){

    }
    @Override
    public int getCount() {
        return playerArrayList.size();
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int i) {
        return playerArrayList.get(i);
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final int pos  = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row, parent, false);
        }

        TextView titleTextView = (TextView) view.findViewById(R.id.name) ;
        TextView descTextView = (TextView) view.findViewById(R.id.team) ;


        // Data Set(playerArrayList)에서 position에 위치한 데이터 참조 획득
        Player player = playerArrayList.get(position);

        titleTextView.setText(player.getName());
        descTextView.setText(player.getTeam());
        return view;
    }

    public void addItem(String name, String team){
        Player player = new Player();
        player.setName(name);
        player.setTeam(team);

        playerArrayList.add(player);
    }
}
