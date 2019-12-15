package soft.bigeran.dervis.Zikirmatik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import soft.bigeran.dervis.R;


public class ZikirAdapter extends ArrayAdapter<Zikir> {

    private final LayoutInflater inflater;
    private final Context context;
    private soft.bigeran.dervis.Zikirmatik.ZikirAdapter.ViewHolder holder;
    private final ArrayList<Zikir> zikir;

    public ZikirAdapter(Context context, ArrayList<Zikir> zikir) {
        super(context,0, zikir);
        this.context = context;
        this.zikir = zikir;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return zikir.size();
    }

    @Override
    public Zikir getItem(int position) {
        return zikir.get(position);
    }

    @Override
    public long getItemId(int position) {
        return zikir.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.zikirlisteitem, null);

            holder = new soft.bigeran.dervis.Zikirmatik.ZikirAdapter.ViewHolder();
            holder.personImage = (ImageView) convertView.findViewById(R.id.person_image);
            holder.personNameLabel = (TextView) convertView.findViewById(R.id.person_name_label);
            holder.personAddressLabel = (TextView) convertView.findViewById(R.id.person_address_label);
            convertView.setTag(holder);

        }
        else{
            //Get viewholder we already created
            holder = (soft.bigeran.dervis.Zikirmatik.ZikirAdapter.ViewHolder)convertView.getTag();
        }

        Zikir person = zikir.get(position);
        if(person != null){
            holder.personImage.setImageResource(person.getPhotoId());
            holder.personNameLabel.setText(person.getName());
            holder.personAddressLabel.setText(person.getAddress());

        }
        return convertView;
    }

    //View Holder Pattern for better performance
    private static class ViewHolder {
        TextView personNameLabel;
        TextView personAddressLabel;
        ImageView personImage;

    }
}
