package com.example.mvplearn.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvplearn.Bean.Goods;
import com.example.mvplearn.R;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater lsyoutInflater;
    private Context context;
    private List<Goods> data;

    public HomeRecyclerViewAdapter(Context context, List<Goods> data){
        this.context = context;
        this.data = data;
        lsyoutInflater = LayoutInflater.from(context);

    }

    public void setGoods(List<Goods> data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = lsyoutInflater.inflate(viewType,parent,false);
        if (viewType == R.layout.home_recycler_text_image){
            return new MultiViewHolder(view);
        }
        return new SigleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Goods good = data.get(position);
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case R.layout.home_recycler_banner:
                ((Banner)(holder.itemView)).setAdapter(new BannerImageAdapter<String>(good.getBannners()) {
                    @Override
                    public void onBindView(BannerImageHolder holder, String  data, int position, int size) {
                        //图片加载自己实现
                        Glide.with(holder.itemView)
                                .load(data)
                                .apply(RequestOptions.centerCropTransform())
                                .into(holder.imageView);
                    }
                })
                        .addBannerLifecycleObserver((LifecycleOwner) context)//添加生命周期观察者
                        .setIndicator(new CircleIndicator(context));
                break;
            case R.layout.home_recycler_image:
                Glide.with(holder.itemView)
                        .load(good.getImageUrl())
                        .apply(RequestOptions.centerCropTransform())
                        .into((ImageView) holder.itemView);
                break;
            case R.layout.home_recycler_text:
                ((TextView) holder.itemView).setText(good.getText());
                break;
            case R.layout.home_recycler_text_image:
                MultiViewHolder multiViewHolder = (MultiViewHolder) holder;
                multiViewHolder.textView.setText(good.getText());
                Glide.with(holder.itemView)
                        .load(good.getImageUrl())
                        .apply(RequestOptions.centerCropTransform())
                        .into(MultiViewHolder.imageView);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        Goods goods = data.get(position);
        if (goods.getBannners() != null){
            return R.layout.home_recycler_banner;
        }else if (goods.getImageUrl() == null){
            return R.layout.home_recycler_text;
            //显示文字
        }else if (goods.getText() == null){
            return R.layout.home_recycler_image;
            //显示图片
        }else {
            return R.layout.home_recycler_text_image;
            //显示文字+图片
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


        class SigleViewHolder extends RecyclerView.ViewHolder{

            public SigleViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
        class MultiViewHolder extends RecyclerView.ViewHolder{
            TextView textView;
            static ImageView imageView;
            public MultiViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.text);
                imageView = itemView.findViewById(R.id.image);
            }
        }


}

