package com.example.mdpostres;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mdpostres.databinding.FragmentCarBinding;
import com.google.android.material.transition.MaterialSharedAxis;


public class CarFragment extends Fragment {

    FragmentCarBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setEnterTransition(new MaterialSharedAxis(MaterialSharedAxis.X, true));
        setReturnTransition(new MaterialSharedAxis(MaterialSharedAxis.X, false));

        setReenterTransition(new MaterialSharedAxis(MaterialSharedAxis.X, false));
        setExitTransition(new MaterialSharedAxis(MaterialSharedAxis.X, true));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CarAdapter adapter = new CarAdapter(CarFragmentArgs.fromBundle(getArguments()).getProducts());
        RecyclerView rvCar = binding.rvCar;
        rvCar.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCar.setAdapter(adapter);

        TextView tvSum = binding.tvSum;
        tvSum.setText(getString(R.string.car_sum, (float)adapter.getItemCount()));

        binding.btnBack.setOnClickListener(v -> NavHostFragment
                .findNavController(this).navigate(R.id.action_car_to_products));

        binding.btnPay.setOnClickListener(v -> NavHostFragment
                .findNavController(this).navigate(R.id.action_car_to_confirm));

        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        menu.findItem(R.id.action_confirm).setVisible(false);
        menu.findItem(R.id.confirmFragment.setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}