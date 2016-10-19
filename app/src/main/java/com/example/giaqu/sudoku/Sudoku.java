package com.example.giaqu.sudoku;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.sudoku.R;

public class Sudoku extends Activity implements OnClickListener {

    private static final String TAG = "Sudoku";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        View newGameButton = findViewById(R.id.newGame_button);
        newGameButton.setOnClickListener(this);
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(this, Prefs.class));
                return true;
        }
        return false;
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.about_button:
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
                break;
            case R.id.newGame_button:
                openNewGameDialog();
                break;
            case R.id.exit_button:
                finish();
                break;
        }
    }

    private void openNewGameDialog() {
        new android.app.AlertDialog.Builder(this)
                .setTitle(R.string.new_game_title)
                .setItems(R.array.difficulty,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(which);
                            }
                        }).show();
    }

    private void startGame(int which) {
        Log.d(TAG, "Clicked on" + which);
        Intent intent = new Intent(Sudoku.this, Game.class);
        intent.putExtra(Game.KEY_DIFFICULTY, which);
        startActivity(intent);
    }
}
