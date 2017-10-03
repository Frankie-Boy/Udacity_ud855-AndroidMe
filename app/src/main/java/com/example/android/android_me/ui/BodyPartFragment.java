package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;


public class BodyPartFragment extends Fragment {

    public static final String IMAGE_ID_LIST = "img_ids";
    public static final String LIST_INDEX = "list_index";

    private List<Integer> listImageId;
    private int listIndex;

    public BodyPartFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstancedState) {

        if (savedInstancedState != null){
            listImageId = savedInstancedState.getIntegerArrayList(IMAGE_ID_LIST);
            listIndex = savedInstancedState.getInt(LIST_INDEX);

        }

        View updatedView =  layoutInflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = (ImageView)updatedView.findViewById(R.id.body_part_image_view);
        imageView.setImageResource(listImageId.get(listIndex));

        if(listImageId != null){
            imageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (listIndex < listImageId.size() - 1) {
                        listIndex++;
                    } else {
                        listIndex = 0;
                    }
                    imageView.setImageResource(listImageId.get(listIndex));
                }
            });

        } else {
            // Log empty list
        }

        return updatedView;
    }

    public void setListImageId(List<Integer> listImageId){
        this.listImageId = listImageId;
    }
    public void setListIndex(int listIndex){
        this.listIndex = listIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState){
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>)listImageId);
        currentState.putInt(LIST_INDEX, listIndex);
    }

}
