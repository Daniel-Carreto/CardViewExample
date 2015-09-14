package com.danycarreto.cardviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.danycarreto.cardviewexample.adapter.CiudadAdapter;
import com.danycarreto.cardviewexample.model.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaTarjetas;
    Ciudad berlin, newYork, tokyo, paris;
    List<Ciudad> listCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos la instancia del Recycler para usarlo.
        listaTarjetas= (RecyclerView)findViewById(R.id.cardList);
        listaTarjetas.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaTarjetas.setLayoutManager(llm);


        //Creamos elementos de tipo Lista para llenar informacion
        paris= new Ciudad();
        paris.setPais("Francia");
        paris.setCiudad("Paris");
        paris.setContinente("Europa");
        paris.setDescripcion("You wanna know how I got them?" +
                " So I had a wife. She was beautiful, like you, who tells me I worry too much," +
                " who tells me I ought to smile more, who gambles and gets in deep with the sharks. " +
                "Hey. One day they carve her face. And we have no money for surgeries.");

        berlin= new Ciudad();
        berlin.setPais("Alemania");
        berlin.setCiudad("Berlin");
        berlin.setContinente("Europa");
        berlin.setDescripcion("Because some men aren't looking for anything logical, like money. " +
                "They can't be bought, bullied, reasoned or negotiated with. Some men just wanna watch the world burn.");

        newYork= new Ciudad();
        newYork.setPais("New York");
        newYork.setCiudad("Estados Unidos de América");
        newYork.setContinente("América");
        newYork.setDescripcion("Let me get this straight. You think that your client, one of the wealthiest, " +
                "most powerful men in the world is secretly a vigilante who spends his nights beating criminals " +
                "to a pulp with his bare hands and your plan is to blackmail this person? Good luck.");

        tokyo= new Ciudad();
        tokyo.setPais("Japón");
        tokyo.setCiudad("Tokyo");
        tokyo.setContinente("Asia");
        tokyo.setDescripcion("Lorem Ipsum Pokemon,blahblahmanga, blahanime, pan blah blah");

        //Agregamos los objetos creados a un ArrayList.
        listCiudad= new ArrayList<>();
        listCiudad.add(paris);
        listCiudad.add(berlin);
        listCiudad.add(newYork);
        listCiudad.add(tokyo);
        listCiudad.add(paris);
        listCiudad.add(berlin);
        listCiudad.add(newYork);
        listCiudad.add(tokyo);

        //Enviamos el ArrayList al adaptador que hemos hecho.
        CiudadAdapter mAdapter = new CiudadAdapter(listCiudad);

        //Le enviamos el resultado del adaptador a nuestro RecyclerView para que lo dibuje.
        listaTarjetas.setAdapter(mAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
