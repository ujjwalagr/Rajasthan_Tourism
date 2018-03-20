package rajasthantourism.com.tourrajasthan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<NatureModel> objectList;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<NatureModel> objectList) {
        inflater = LayoutInflater.from(context);
        this.objectList = objectList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.single_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NatureModel current = objectList.get(position);
        holder.setData(current, position);
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView img;
        private int position;
        private NatureModel currentObject;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView);
            img = itemView.findViewById(R.id.imgView);
        }

        public void setData(NatureModel currentObject, int position) {

            title.setText(currentObject.getTitle());
            img.setImageResource(currentObject.getImageId());
            this.position = position;
            this.currentObject = currentObject;
        }
    }
}

