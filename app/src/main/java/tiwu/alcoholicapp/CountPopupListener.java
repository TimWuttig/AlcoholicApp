package tiwu.alcoholicapp;

import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by tim on 21.10.18.
 * Shows Popup menu when counter is longer clicked
 */

class CountPopupListener implements View.OnLongClickListener {
    private AlcoholicApp alcoholicApp;
    private Counter counter;

    public CountPopupListener(Counter counter) {
        this.alcoholicApp = counter.management.alcoholicApp;
        this.counter = counter;
    }

    @Override
    public boolean onLongClick(View view) {
        PopupMenu popupMenu = new PopupMenu(alcoholicApp,view);
        popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new ItemListener(counter));
        popupMenu.show();
        return false;
    }

    private class ItemListener implements PopupMenu.OnMenuItemClickListener {
        public ItemListener(Counter counter) {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.delete:
                    counter.delete();
            }
            return false;
        }
    }
}
