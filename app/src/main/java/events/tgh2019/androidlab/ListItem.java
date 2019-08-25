package events.tgh2019.androidlab;

/**
 * ListView に表示させる項目（リストの行）を表す。
 * メンバ：　品名（name）、画像（pic）、説明（description）
 */
public class ListItem {

    private String name;
    private int pic;
    private String description;

    public ListItem(String name, int pic, String description){
        this.name = name;
        this.pic = pic;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPic() {
        return pic;
    }

    public String getDescription() {
        return description;
    }


}
