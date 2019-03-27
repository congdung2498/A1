package com.example.nguyentuan.tracnghiem1.symbol;

        import android.content.Context;
        import android.content.res.Resources;
        import android.database.Cursor;
        import android.provider.ContactsContract;
        import android.support.annotation.NonNull;
        import android.support.v4.widget.CursorAdapter;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.example.nguyentuan.tracnghiem1.R;

        import org.w3c.dom.DOMImplementation;

        import java.util.ArrayList;

public class SymbolsAdapter extends CursorAdapter {


    public SymbolsAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view= LayoutInflater.from(context).inflate(R.layout.item_list_symbol, parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ImageView imgSymbol=(ImageView) view.findViewById(R.id.imgSymbol);
        TextView tvNameSymbol= (TextView) view.findViewById(R.id.tvNameSymbol);
        TextView tvContentSymbol= (TextView) view.findViewById(R.id.tvContentSymbol);

        //LinearLayout ln= (LinearLayout) view.findViewById(R.id.linQues);

//        if(cursor.getPosition()%2 == 0){
//            ln.setBackgroundColor(Color.parseColor("#FFE2DFDF"));
//        }else ln.setBackgroundColor(Color.parseColor("#ffffff"));
        tvNameSymbol.setText(cursor.getString(1));
        tvContentSymbol.setText(cursor.getString(2));
    //SET IMAGE HERE
        imgSymbol.setImageResource(context.getResources().getIdentifier(cursor.getString(3)+"","drawable","com.example.nguyentuan.tracnghiem1"));


    }
}
