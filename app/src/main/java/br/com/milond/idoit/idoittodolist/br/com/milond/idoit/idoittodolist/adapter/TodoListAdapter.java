package br.com.milond.idoit.idoittodolist.br.com.milond.idoit.idoittodolist.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;

import br.com.milond.idoit.idoittodolist.R;
import br.com.milond.idoit.idoittodolist.br.com.milond.idoit.idoittodolist.data.TodoItem;

/**
 * Created by Carlos Leao (carloseduardogu@gmail.com) on 27/04/2015.
 */
public class TodoListAdapter extends BaseAdapter {

    private List<TodoItem> mTodoItemList;
    private LayoutInflater mLayoutInflater;

    public TodoListAdapter(Context context, List<TodoItem> todoItemList) {
        mTodoItemList = todoItemList;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setTodoItemList(List<TodoItem> mTodoItemList) {
        this.mTodoItemList = mTodoItemList;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return mTodoItemList.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return mTodoItemList.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link android.view.LayoutInflater#inflate(int, android.view.ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mLayoutInflater.inflate(R.layout.todo_item, null);
        TodoItem todoItem = mTodoItemList.get(position);

        TextView tvDescription = (TextView) convertView.findViewById(R.id.todo_item_description);
        tvDescription.setText(mTodoItemList.get(position).getDescription());

        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT

        // generate random color
        int color = generator.getColor(todoItem.getDescription());

        TextDrawable drawable = TextDrawable.builder()
                .buildRound(todoItem.getDescription().substring(0,1).toUpperCase(), color);

        ImageView image = (ImageView) convertView.findViewById(R.id.image_view);
        image.setImageDrawable(drawable);

        return convertView;
    }
}
