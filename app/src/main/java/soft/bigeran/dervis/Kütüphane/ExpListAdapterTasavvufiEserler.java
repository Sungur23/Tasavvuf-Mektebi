package soft.bigeran.dervis.Kütüphane;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import soft.bigeran.dervis.R;


public class ExpListAdapterTasavvufiEserler extends BaseExpandableListAdapter{

    private Context context;
    private ArrayList<String> basliklar;
    private HashMap<String, ArrayList<String>> icerik;

    public ExpListAdapterTasavvufiEserler(Context context, ArrayList<String> basliklar,
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
            convertView = inflater.inflate(R.layout.list_item_tasavvufieserler, null);
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


        }
        else if(groupPosition==5) {
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
        }
        else if(groupPosition==6) {
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
        }else if(groupPosition==7) {
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
        }else if(groupPosition==8) {
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
        }else if(groupPosition==9) {
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
        }else if(groupPosition==10) {
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
        }else if(groupPosition==11) {
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
        }else if(groupPosition==12) {
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
        }else if(groupPosition==13) {
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
        }else if(groupPosition==14) {
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


        }else if(groupPosition==15) {
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
        }else if(groupPosition==16) {
            if (childPosition == 0) {
                itemimaj.setBackgroundResource(R.drawable.photo13);
                ;
            } else if (childPosition == 1) {
                itemimaj.setBackgroundResource(R.drawable.photo13);
            } else if (childPosition == 2) {
                itemimaj.setBackgroundResource(R.drawable.photo13);
            } else if (childPosition == 3) {
                itemimaj.setBackgroundResource(R.drawable.photo13);
            } else if (childPosition == 4) {
                itemimaj.setBackgroundResource(R.drawable.photo13);
            } else if (childPosition == 5) {
                itemimaj.setBackgroundResource(R.drawable.photo13);
            } else if (childPosition == 6) {
                itemimaj.setBackgroundResource(R.drawable.photo13);
            } else if (childPosition == 7) {
                itemimaj.setBackgroundResource(R.drawable.photo13);
            } else if (childPosition == 8) {
                itemimaj.setBackgroundResource(R.drawable.photo13);
            } else if (childPosition == 9) {
                itemimaj.setBackgroundResource(R.drawable.photo13);
            } else if (childPosition == 10) {
                itemimaj.setBackgroundResource(R.drawable.photo13);
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
            convertView = inflater.inflate(R.layout.liste_grup_tasavvufieserler, null);

        }

        TextView tvBaslik = (TextView) convertView.findViewById(R.id.gruptext);
        tvBaslik.setText(baslik);


        ImageView Listeimaj=(ImageView) convertView.findViewById(R.id.listeimaj);



        if(groupPosition==0)
        {
            Listeimaj.setBackgroundResource(R.drawable.book);

        }else if(groupPosition==1)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar1);
        }else if(groupPosition==2)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar2);
        }
        else if(groupPosition==3)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar3);
        }
        else if(groupPosition==4)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar4);
        }else if(groupPosition==5)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar5);
        }else if(groupPosition==6)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar6);
        }
        else if(groupPosition==7)
        {
            Listeimaj.setBackgroundResource(R.drawable.book);
        }
        else if(groupPosition==8)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar1);
        }else if(groupPosition==9)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar2);
        }else if(groupPosition==10)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar3);
        }
        else if(groupPosition==11)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar4);
        }
        else if(groupPosition==12)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar5);
        }else if(groupPosition==13)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar6);
        }else if(groupPosition==14)
        {
            Listeimaj.setBackgroundResource(R.drawable.book);
        }
        else if(groupPosition==15)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar1);
        }
        else if(groupPosition==16)
        {
            Listeimaj.setBackgroundResource(R.drawable.kitaplar2);
        }

        tvBaslik.setTypeface(null, Typeface.BOLD);
        tvBaslik.setTextSize(TypedValue.COMPLEX_UNIT_SP,19);
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
