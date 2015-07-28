package cn.hiroz.demo.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiro on 7/27/15.
 */
public abstract class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder> {

    protected List<DataItem> data;

    public ImagesAdapter() {
        data = new ArrayList<>();
        data.add(new DataItem(R.mipmap.pic_1));
        data.add(new DataItem(R.mipmap.pic_2));
        data.add(new DataItem(R.mipmap.pic_3));
        data.add(new DataItem(R.mipmap.pic_4));
        data.add(new DataItem(R.mipmap.pic_5));
        data.add(new DataItem(R.mipmap.pic_6));
        data.add(new DataItem(R.mipmap.pic_7));
        data.add(new DataItem(R.mipmap.pic_8));
        data.add(new DataItem(R.mipmap.pic_9));
        data.add(new DataItem(R.mipmap.pic_10));
    }

    @SuppressLint("InflateParams")
    @Override
    public ImagesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ImagesViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null));
    }

    @Override
    public void onBindViewHolder(ImagesViewHolder imagesViewHolder, int i) {
        imagesViewHolder.imageView.setImageResource(data.get(i).resId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected abstract void onClickItem(View v, int position);

    public class ImagesViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ImagesViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.image);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItem(v, getAdapterPosition());
                }
            });
        }
    }

}
