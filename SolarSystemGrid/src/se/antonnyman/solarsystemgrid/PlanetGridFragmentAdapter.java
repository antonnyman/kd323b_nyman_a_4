package se.antonnyman.solarsystemgrid;

import java.util.ArrayList;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlanetGridFragmentAdapter extends ArrayAdapter<Planet> {
	
	private static final String LOG_TAG = PlanetGridFragmentAdapter.class.getName();
	
	private int					layoutId;
	private ArrayList<Planet> 	planets;
	private Context				mContext;
	
	
	public PlanetGridFragmentAdapter(Context context, int resource,
			ArrayList<Planet> objects) {
		super(context, resource, objects);
		this.mContext = context;
		this.layoutId = resource;
		this.planets = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null) {
			LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(layoutId, null);
			
			Log.i(LOG_TAG, "ConvertView was null");
		}
		
		
		Planet planet = planets.get(position);
		if(planet != null) {
			TextView planetName = (TextView) convertView.findViewById(R.id.fragment_start_planetgrid_item_name);
			ImageView planetImage = (ImageView) convertView.findViewById(R.id.fragment_start_planetgrid_item_image);
			planetName.setText(planet.getName());
			planetImage.setImageResource(planet.getImageId());
			
			Log.i(LOG_TAG, "Setting view");
		}
		
		Log.i(LOG_TAG, "Returning view!");
		return convertView;
	}
}
