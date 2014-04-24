package se.antonnyman.solarsystemgrid;

import android.app.Fragment;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PlanetDetailsFragment extends Fragment {
	
	final static String BUNDLE_POSITION_KEY = "se.antonnyman.solarsystem.CURRENT_POSITION_KEY";
	int currentPosition = -1;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_planetdetail, null);
		return view;
		
	}
	
	@Override
	public void onStart() {
		super.onStart();
		
//		onStart we check if there are arguments passed to the Fragment (putInt is part of Bundle).
		Bundle arguments = getArguments();
		
//		If there are arguments, update the planet view to the right position
		if(arguments != null) {
			updatePlanetView(arguments.getInt(BUNDLE_POSITION_KEY));

//		  If the currentPosition is not equal to -1 (PlanetListFragment) then update the planet view.
		} else if(currentPosition != -1) {
			updatePlanetView(currentPosition);
		}
	}
	
	
//	Updates the TextView with the right text passed on from the position. Returns the int text from that position in the array.
	public void updatePlanetView(int position) {
//		Put this in a try/catch if something should fail.
		try {
			TextView planetName = (TextView) getActivity().findViewById(R.id.fragment_planetdetail_title);
			TextView planetRadius = (TextView) getActivity().findViewById(R.id.fragment_planetdetail_radius);
			TextView orbitalPeriod = (TextView) getActivity().findViewById(R.id.fragment_planetdetail_orbitalperiod);
			TextView planetSummaryInformation = (TextView) getActivity().findViewById(R.id.fragment_planetdetail_description);
			ImageView planetImage = (ImageView) getActivity().findViewById(R.id.fragment_planetdetail_image);
			
			planetName.setText(Static.PLANET_NAMES[position]);
			planetRadius.setText(Double.toString(Static.PLANET_RADIUS[position]));
			orbitalPeriod.setText(Integer.toString(Static.ORBITAL_PERIOD[position]));
			planetSummaryInformation.setText(Static.PLANET_SUMMARY[position]);
			planetImage.setImageResource(Static.PLANET_IMAGE_ID[position]);
		} catch (Exception e){
			Log.i("Error: ", e+" ");
		}
		
		currentPosition = position;
	}

}
