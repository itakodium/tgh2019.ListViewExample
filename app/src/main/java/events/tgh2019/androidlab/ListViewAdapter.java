package events.tgh2019.androidlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ListViewに項目を対応付けるアダプタ。
 * Androidできあいのアダプタとしては、
 * ArrayAdapter（配列要素をまんま貼り付ける）、
 * SimpleAdapter（MLで定義したビューを貼り付ける）
 * があるが、（このプロジェクトのように）オブジェクトのメンバを開いて個別に貼り付けたい場合、
 * BaseAdapterを継承して自前のアダプタを定義する必要がある。
 */
public class ListViewAdapter extends BaseAdapter {

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    private LayoutInflater inflater;
    private int layoutId;
    private ListItem[] listItems;

    ListViewAdapter(Context context, int layoutId, ListItem[] listItems) {
        super();
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layoutId = layoutId;
        this.listItems = listItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(listItems[position].getPic());
        holder.textView.setText(listItems[position].getName());

        return convertView;
    }

    @Override
    public int getCount() {
        return listItems.length;
    }

    @Override
    public Object getItem(int pos) {
        return listItems[pos];
    }

    @Override
    public long getItemId(int pos) {
        return listItems[pos].hashCode();
    }
}
