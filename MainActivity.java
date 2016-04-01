package com.altaf.multiitemlist;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
  private ArrayList<String> data = new ArrayList<String>();
  ListView lv; 
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView)findViewById(R.id.listView);
		generateListContent();
		lv.setAdapter(new MyListAdapter(this,R.layout.list_item,data));
		lv.setOnItemClickListener(new OnItemClickListener()
		{
         @Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
            {
			 // TODO Auto-generated method stub
			  Toast.makeText(MainActivity.this,"Last Item was Clicked",Toast.LENGTH_SHORT).show();	
			}
		});
	}

	private void generateListContent()
	{
	  for(int i=0;i<=10;i++)
	  {
		data.add("This is row number" +i);  
	  }
	}
	
	private class MyListAdapter extends ArrayAdapter<String>
	{
	 private int layout;
		public MyListAdapter(Context context, int resource,List<String> object) 
	    {
	  	 super(context,resource,object);
		 layout = resource;
	  	}
  	
	 public View getView(final int position,View convertView,ViewGroup parent)
	 {
	  ViewBuilder mainViewBuilder = null;
		 
	  if(convertView==null)
	  {
		LayoutInflater inflater = LayoutInflater.from(getContext());
		convertView = inflater.inflate(layout,parent,false);
		ViewBuilder viewBuilder = new ViewBuilder();
		viewBuilder.thumbnail = (ImageView)convertView.findViewById(R.id.list_item_thumbnail);
		viewBuilder.title = (TextView)convertView.findViewById(R.id.list_item_text);
		viewBuilder.price=(TextView)convertView.findViewById(R.id.pricetext);
		viewBuilder.button = (Button)convertView.findViewById(R.id.list_item_button);
		viewBuilder.sw = (Switch)convertView.findViewById(R.id.list_item_switch);
		viewBuilder.sw.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
		 @Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) 
		    {
			 // TODO Auto-generated method stub
			 if(arg1==true)
			 {
			   Toast.makeText(getContext(),"On",Toast.LENGTH_SHORT).show();	 
			 }
			 else
			 {
			   Toast.makeText(getContext(),"Off",Toast.LENGTH_SHORT).show();	 
			 }
		    }
		});
		viewBuilder.button.setOnClickListener(new View.OnClickListener()
		{
		 @Override
			public void onClick(View arg0) 
		    {
			 // TODO Auto-generated method stub
			
			 Toast.makeText(getContext(),"Button was clicked for list item" + position,Toast.LENGTH_SHORT).show();	
		     Intent i=new Intent(MainActivity.this,TotalPrice.class);
		     startActivity(i);
		    
		    }
		});
		convertView.setTag(viewBuilder);
	  }
	  else
	  {
		mainViewBuilder = (ViewBuilder)convertView.getTag();
		mainViewBuilder.title.setText(getItem(position));
	  }
	   return convertView;
	 }
	}
	
	public class ViewBuilder
	{
	  ImageView thumbnail;
	  TextView title,price;
	  Button button;
	  Switch sw;
	  
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
