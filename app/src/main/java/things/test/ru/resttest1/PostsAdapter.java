package things.test.ru.resttest1;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<PostPreviewModel> posts;
    private Context mContext;

    public PostsAdapter(Context context,List<PostPreviewModel> posts) {
        this.posts = posts;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostPreviewModel post = posts.get(position);

        ImageView imageView = holder.image;
        Glide.with(mContext)
                .load(post.getGuid())
                .placeholder(R.drawable.ic_cloud_off_red)
                .into(imageView);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            holder.post.setText(Html.fromHtml(post.getPostContent(), Html.FROM_HTML_MODE_LEGACY));
//        } else {
//            holder.post.setText(Html.fromHtml(post.getPostContent()));
//        }
        holder.title.setText(post.getPostTitle());

    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //TextView post;
        TextView title;
        ImageView image;
        CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.postpreviewitem_title);
            image=(ImageView) itemView.findViewById(R.id.postpreviewitem_photo);
            cv=(CardView) itemView.findViewById(R.id.cv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                PostPreviewModel onePost = posts.get(position);
                Intent intent = new Intent(mContext, PostActivity.class);
                intent.putExtra("post_ID", Integer.parseInt(onePost.getID()));
                mContext.startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }
    }
}