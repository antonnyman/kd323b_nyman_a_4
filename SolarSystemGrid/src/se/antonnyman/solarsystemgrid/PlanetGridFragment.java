package se.antonnyman.solarsystemgrid;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


public class PlanetGridFragment extends Fragment {
	
	
	public static final String 		LOG_TAG = PlanetGridFragment.class.getName();
	
	private GridView					mGrid;
	private PlanetGridFragmentAdapter	mAdapter;
	private ArrayList<Planet>			mPlanets = new ArrayList<Planet>();
	private int							mGridItem = R.layout.fragment_start_planetgrid_item;
	private Context						mContext;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_start, container, false);

		return view;
	}
	

	@Override
	public void onStart() {
		super.onStart();
		mGrid = (GridView) getView().findViewById(R.id.fragment_start_planetgrid);
		mContext = getActivity();
		mAdapter = new PlanetGridFragmentAdapter(mContext, mGridItem, mPlanets);
		mGrid.setAdapter(mAdapter);
		
		if(mGrid != null) {
			mGrid.setOnItemClickListener(new OnItemClickListener(){
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					onGridItemClick((GridView) arg0, arg1, arg2, arg3);
					
				}
			});
		}
		updateList();
	}
	
	public void updateList() {
		for(int i=0; i < Static.PLANET_NAMES.length; i++) {
			mPlanets.add(new Planet(Static.PLANET_NAMES[i], Static.PLANET_IMAGE_ID[i], Static.PLANET_RADIUS[i], Static.ORBITAL_PERIOD[i], Static.PLANET_SUMMARY[i]));
			Log.i(LOG_TAG, "Added planet: " + Static.PLANET_NAMES[i]);
		}
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	
	public void onGridItemClick(GridView g, View v, int position, long id) {
		Activity activity = getActivity();
		if(activity != null) {
			PlanetDetailsFragment planetDetailFragment = new PlanetDetailsFragment();
			Bundle bundle = new Bundle();
			bundle.putInt(PlanetDetailsFragment.BUNDLE_POSITION_KEY, position);
			planetDetailFragment.setArguments(bundle);
			FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
			fragmentTransaction.replace(R.id.start_fragmentframe, planetDetailFragment);
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
		}
	}
	
}
