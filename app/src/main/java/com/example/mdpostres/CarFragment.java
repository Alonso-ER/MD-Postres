package com.example.mdpostres;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdpostres.databinding.FragmentCarBinding;

public class CarFragment extends Fragment {

    FragmentCarBinding binding;

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

        binding.btnBack.setOnClickListener(v -> NavHostFragment
                .findNavController(this).navigate(R.id.action_car_to_products));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}