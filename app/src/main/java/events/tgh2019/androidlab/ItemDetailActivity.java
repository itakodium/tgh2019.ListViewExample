package events.tgh2019.androidlab;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * ListViewの項目をクリックすると、このアクティビティで詳細を確認できる
 */
public class ItemDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Intent intent = getIntent();

        final String selectedText = intent.getStringExtra("Text");
        TextView textView = findViewById(R.id.selected_txt);
        textView.setText(selectedText);

        int selectedPic = intent.getIntExtra("Pic", 0);
        ImageView imageView = findViewById(R.id.selected_pic);
        imageView.setImageResource(selectedPic);

        String description = intent.getStringExtra("Description");
        TextView desc = findViewById(R.id.selected_description);
        desc.setText(description);
    }
}
