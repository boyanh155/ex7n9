package Models;

import java.util.ArrayList;

public class cart {
    private ArrayList<lineItem> items;

    public cart() {
        items = new ArrayList<lineItem>();
    }

    public ArrayList<lineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(lineItem item) {
        String code = item.getProduct().getCode();
        int qty = item.getQty();
        for (int i = 0; i < items.size(); i++) {
            lineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                lineItem.setQty(qty);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(lineItem item) {
        String code = item.getProduct().getCode();
        for (int i = 0; i < items.size(); i++) {
            lineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }

}
