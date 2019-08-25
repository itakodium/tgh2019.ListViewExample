package events.tgh2019.androidlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    /**
     * ListViewに表示するデータ
     */
    private static ListItem[] listItems = {
            new ListItem("烏龍茶珍珠奶茶", R.drawable.oolong, "定番じゃね"),
            new ListItem("キャラメルタピオカミルクティー", R.drawable.caramel, "この夏たいへんお世話になりました…"),
            new ListItem("ストロベリータピオカミルクティー", R.drawable.strawberry, "意外なおいしさ"),
            new ListItem("巧克力珍珠奶茶", R.drawable.chocolate, "僕は結構好き"),
            new ListItem("宇治抹茶タピオカミルクティー", R.drawable.greentea, "ホイップクリームのアドオン無双"),
            new ListItem("レモンタピオカティー", R.drawable.lemon, "うーーーん"),
            new ListItem("香蕉珍珠奶茶", R.drawable.banana, "なんかおいもっぽい")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView contactList = findViewById(R.id.contact_list);
        BaseAdapter adapter =
                new ListViewAdapter(this.getApplicationContext(), R.layout.list, listItems);
        contactList.setAdapter(adapter);

        contactList.setOnItemClickListener(this);

    }

    /**
     * ListView項目クリック時の処理：クリックされた項目のデータを次画面で表示する
      * @param parent
     * @param v
     * @param pos
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
        Intent intent = new Intent(this.getApplicationContext(), ItemDetailActivity.class);

        String selectedText = listItems[pos].getName();
        intent.putExtra("Text", selectedText);
        int selectedPic = listItems[pos].getPic();
        intent.putExtra("Pic", selectedPic);
        String description = listItems[pos].getDescription();
        intent.putExtra("Description", description);

        startActivity(intent);
    }
}
