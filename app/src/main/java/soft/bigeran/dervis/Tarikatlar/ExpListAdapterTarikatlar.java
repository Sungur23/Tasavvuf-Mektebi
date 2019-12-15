package soft.bigeran.dervis.Tarikatlar;

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

public class ExpListAdapterTarikatlar extends BaseExpandableListAdapter{

	private Context context;
	private ArrayList<String> basliklar;
	private HashMap<String, ArrayList<String>> icerik;

	public ExpListAdapterTarikatlar(Context context, ArrayList<String> basliklar,
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
			convertView = inflater.inflate(R.layout.list_view_itemtarikat, null);
		}

		TextView tvText = (TextView) convertView.findViewById(R.id.person_name_label);
		tvText.setText(text);

		ImageView itemimaj=(ImageView) convertView.findViewById(R.id.person_image);



		if(groupPosition==0)
		{
			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.naksi1); ;
			}else if(childPosition==1)
			{
				itemimaj.setBackgroundResource(R.drawable.naksi2) ;
			}else if(childPosition==2)
			{
				itemimaj.setBackgroundResource(R.drawable.naksi3)  ;
			}else if(childPosition==3)
			{
				itemimaj.setBackgroundResource(R.drawable.naksi4)   ;
			}
		}else if(groupPosition==1) {
			if (childPosition == 0) {
				itemimaj.setBackgroundResource(R.drawable.kadiri1);
			} else if (childPosition == 1) {
				itemimaj.setBackgroundResource(R.drawable.photo13);

			}
            else if (childPosition == 2) {
                itemimaj.setBackgroundResource(R.drawable.kadiri2);

            }
            else if (childPosition == 3) {
                itemimaj.setBackgroundResource(R.drawable.kadiri4);

            }

			else if (childPosition == 4) {
				itemimaj.setBackgroundResource(R.drawable.kadiri5);

			}




		} else if(groupPosition==2) {

			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.mevlevi1); ;
			}else if(childPosition==1)
			{
				itemimaj.setBackgroundResource(R.drawable.mevlevi2) ;
			}else if(childPosition==2)
			{
				itemimaj.setBackgroundResource(R.drawable.mevlevi3)  ;
			}else if(childPosition==3)
			{
				itemimaj.setBackgroundResource(R.drawable.mevlevi4)   ;
			}

        }


		else if(groupPosition==3) {
			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.sazeli1); ;
			}else if(childPosition==1)
			{
				itemimaj.setBackgroundResource(R.drawable.sazeli2) ;
			}else if(childPosition==2)
			{
				itemimaj.setBackgroundResource(R.drawable.sazeli3)  ;
			}else if(childPosition==3)
			{
				itemimaj.setBackgroundResource(R.drawable.sazeli4)   ;
			}

		}

		else if(groupPosition==4) {
			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.kadiri2); ;
			}

		}else if(groupPosition==5) {
			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.bedevi1); ;
			}else if(childPosition==1)
			{
				itemimaj.setBackgroundResource(R.drawable.kadiri2) ;
			}else if(childPosition==2)
			{
				itemimaj.setBackgroundResource(R.drawable.bedevi3)  ;
			}


		}else if(groupPosition==6) {
			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.melami1); ;
			}


		}else if(groupPosition==7) {
			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.kadiri2); ;
			}else if(childPosition==1)
			{
				itemimaj.setBackgroundResource(R.drawable.rufai2) ;
			}else if(childPosition==2)
			{
				itemimaj.setBackgroundResource(R.drawable.rufai3)  ;
			}else if(childPosition==3)
			{
				itemimaj.setBackgroundResource(R.drawable.rufai4)   ;
			}
			else if(childPosition==4)
			{
				itemimaj.setBackgroundResource(R.drawable.rufai5)   ;
			}
			else if(childPosition==5)
			{
				itemimaj.setBackgroundResource(R.drawable.photo32)   ;
			}


		}else if(groupPosition==8) {
			if(childPosition==0)
			{
				itemimaj.setBackgroundResource(R.drawable.photo13); ;
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
			convertView = inflater.inflate(R.layout.liste_gruptarikat, null);
			
		}



		
		TextView tvBaslik = (TextView) convertView.findViewById(R.id.gruptext);
		tvBaslik.setText(baslik);


		ImageView Listeimaj=(ImageView) convertView.findViewById(R.id.listeimaj);



		if(groupPosition==0)
		{
			Listeimaj.setBackgroundResource(R.drawable.tarikat2);
			//SET TEAM ROW BACKGROUND COLOR

		}else if(groupPosition==1)
		{
			Listeimaj.setBackgroundResource(R.drawable.tarikat1);
		}else if(groupPosition==2)
		{
			Listeimaj.setBackgroundResource(R.drawable.tarikat3);
			//SET TEAM ROW BACKGROUND COLOR


		}
		else if(groupPosition==3)
		{
			Listeimaj.setBackgroundResource(R.drawable.tarikat4);
			//SET TEAM ROW BACKGROUND COLOR



		}
		else if(groupPosition==4)
		{
			Listeimaj.setBackgroundResource(R.drawable.tarikat5);
			//SET TEAM ROW BACKGROUND COLOR


		}else if(groupPosition==5)
		{
			Listeimaj.setBackgroundResource(R.drawable.tarikat6);
		}else if(groupPosition==6)
		{
			Listeimaj.setBackgroundResource(R.drawable.tarikat7);
			//SET TEAM ROW BACKGROUND COLOR


		}
		else if(groupPosition==7)
		{
			Listeimaj.setBackgroundResource(R.drawable.tarikat8);
			//SET TEAM ROW BACKGROUND COLOR



		}
		else if(groupPosition==8)
		{
			Listeimaj.setBackgroundResource(R.drawable.cca1);
			//SET TEAM ROW BACKGROUND COLOR


		}else if(groupPosition==9)
		{
			Listeimaj.setBackgroundResource(R.drawable.cca1);
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
