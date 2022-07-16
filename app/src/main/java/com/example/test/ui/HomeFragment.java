package com.example.test.ui;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.test.Utils;
import com.example.test.databinding.FragmentHomeBinding;

import java.io.File;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ActivityResultLauncher<Uri> take;
    Uri uri;
    Activity main;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        main = this.requireActivity();
        View root = binding.getRoot();
        permission();
        click();
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        take = registerForActivityResult(new ActivityResultContracts.TakePicture(), result -> {
            if (result) {
//                Bitmap bitmap = null;
//                System.out.println("success");
//                try {
//                     bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(picture));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                imageView.setImageBitmap(bitmap);
                Glide.with(main).load(uri).into(binding.imageView);
            }
        });
    }

    private void click() {
        binding.btnTake.setOnClickListener(view -> {
            File uriFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            uri = Utils.getUriForFile(main, uriFile);
            System.out.println(uri);
            take.launch(uri);
        });
    }

    private void permission(){
        int REQUEST_CODE = 88;
        String[] str = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
        };
        for (String per : str) {
            if (main.checkSelfPermission(per) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(str, REQUEST_CODE);
            }
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}