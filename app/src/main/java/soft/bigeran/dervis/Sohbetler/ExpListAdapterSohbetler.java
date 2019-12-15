package soft.bigeran.dervis.Sohbetler;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import soft.bigeran.dervis.R;


public class ExpListAdapterSohbetler extends BaseExpandableListAdapter{

	private Context context;
	private ArrayList<String> basliklar;
	private HashMap<String, ArrayList<String>> icerik;

	public ExpListAdapterSohbetler(Context context, ArrayList<String> basliklar,
                                  HashMap<String, ArrayList<String>> icerik) {
		super();
		this.context = context;
		this.basliklar = basliklar;
		this.icerik = icerik;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return icerik.get(basliklar.get(groupPosition)).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {



		String text = (String) getChild(groupPosition, childPosition);

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_view_itemsohbetler, null);
		}

		TextView tvText = (TextView) convertView.findViewById(R.id.itemtext);
		tvText.setText(text);

		ImageView itemimaj=(ImageView) convertView.findViewById(R.id.itemimage);



		if(groupPosition==0)
		{
			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13); ;
			}else if(childPosition==1)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13) ;
			}else if(childPosition==2)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)  ;
			}else if(childPosition==3)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==4)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==5)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==6)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==7)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==8)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==9)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==10)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==11)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}

			else if(childPosition==12)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==13)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==14)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==15)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
			else if(childPosition==16)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}
		}else if(groupPosition==1) {
			if (childPosition == 0) {
				itemimaj.setBackgroundResource(R.drawable.photo13);
			} else if (childPosition == 1) {
				itemimaj.setBackgroundResource(R.drawable.photo13);

			}
            else if (childPosition == 2) {
                itemimaj.setBackgroundResource(R.drawable.photo13);

            }
            else if (childPosition == 3) {
                itemimaj.setBackgroundResource(R.drawable.photo13);

            }

			else if (childPosition == 4) {
				itemimaj.setBackgroundResource(R.drawable.photo13);

			}

			else if (childPosition == 5) {
				itemimaj.setBackgroundResource(R.drawable.photo13);

			}

			else if (childPosition == 6) {
				itemimaj.setBackgroundResource(R.drawable.photo13);

			}

			else if (childPosition == 7) {
				itemimaj.setBackgroundResource(R.drawable.photo13);

			}

			else if (childPosition == 8) {
				itemimaj.setBackgroundResource(R.drawable.photo13);

			}
			else if (childPosition == 9) {
				itemimaj.setBackgroundResource(R.drawable.photo13);

			}
		}

		else if(groupPosition==2) {
			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13); ;
			}else if(childPosition==1)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13) ;
			}else if(childPosition==2)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)  ;
			}else if(childPosition==3)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}



        }


		else if(groupPosition==3) {
			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13); ;
			}else if(childPosition==1)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13) ;
			}else if(childPosition==2)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)  ;
			}else if(childPosition==3)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)   ;
			}



		}

		else if(groupPosition==4) {
			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13); ;
			}else if(childPosition==1)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13) ;
			}else if(childPosition==2)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13)  ;
			}


		}

		return convertView;



	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return icerik.get(basliklar.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return basliklar.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return basliklar.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String baslik = (String) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.liste_grupsohbetler, null);
			
		}



		
		TextView tvBaslik = (TextView) convertView.findViewById(R.id.gruptext);
		tvBaslik.setText(baslik);


		ImageView Listeimaj=(ImageView) convertView.findViewById(R.id.listeimaj);



		if(groupPosition==0)
		{
			Listeimaj.setBackgroundResource(R.drawable.vav3);
			//SET TEAM ROW BACKGROUND COLOR

		}else if(groupPosition==1)
		{
			Listeimaj.setBackgroundResource(R.drawable.photo158);
		}else if(groupPosition==2)
		{
			Listeimaj.setBackgroundResource(R.drawable.photo151);
			//SET TEAM ROW BACKGROUND COLOR


		}
		else if(groupPosition==3)
		{
			Listeimaj.setBackgroundResource(R.drawable.photo142);
			//SET TEAM ROW BACKGROUND COLOR



		}
		else if(groupPosition==4)
		{
			Listeimaj.setBackgroundResource(R.drawable.photo148);
			//SET TEAM ROW BACKGROUND COLOR


		}




		tvBaslik.setTypeface(null, Typeface.BOLD);
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

}
