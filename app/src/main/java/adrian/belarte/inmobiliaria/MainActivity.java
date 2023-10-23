package adrian.belarte.inmobiliaria;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;



import adrian.belarte.inmobiliaria.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> launcherAddInmueble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inicializarLaunchers();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //                                           Desde donde va            A DONDE VA
                launcherAddInmueble.launch(new Intent(MainActivity.this, AddInmuebleActivity.class));
            }
        });
    }

    private void inicializarLaunchers() {
        launcherAddInmueble = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        //RESULTADO DE VOLVER DE LA ACTIVDAD ADD INMUEBLE
                    }
                }
        );
    }
}