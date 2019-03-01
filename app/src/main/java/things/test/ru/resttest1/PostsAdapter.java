package things.test.ru.resttest1;

import android.content.Context;
import android.os.Build;
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

    class ViewHolder extends RecyclerView.ViewHolder {
        //TextView post;
        TextView title;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.postpreviewitem_title);
            image=(ImageView) itemView.findViewById(R.id.postpreviewitem_photo);
            //site = (TextView) itemView.findViewById(R.id.postitem_site);
        }
    }
}