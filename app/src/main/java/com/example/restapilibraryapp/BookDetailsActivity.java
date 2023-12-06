package com.example.restapilibraryapp;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class BookDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_EDIT_BOOK_TITLE = "com.example.pl.EDIT_BOOK_TITLE";
    public static final String EXTRA_EDIT_BOOK_AUTHORS = "com.example.pl.EDIT_BOOK_AUTHORS";
    public static final String EXTRA_EDIT_BOOK_IMG = "com.example.pl.EDIT_BOOK_IMG";
    public static final String EXTRA_EDIT_BOOK_NUMBER_OF_PAGES = "com.example.pl.EDIT_BOOK_NUMBER_OF_PAGES";
    private TextView titleTextView;
    private TextView authorsTextView;
    private ImageView coverImageView;
    private TextView numberOfPagesTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_details);

        titleTextView = findViewById(R.id.book_title);
        authorsTextView = findViewById(R.id.book_author);
        coverImageView = findViewById(R.id.img_cover);
        numberOfPagesTextView = findViewById(R.id.number_of_pages);

        Intent intent = getIntent();
        titleTextView.setText(intent.getStringExtra(EXTRA_EDIT_BOOK_TITLE));
        authorsTextView.setText(intent.getStringExtra(EXTRA_EDIT_BOOK_AUTHORS));
        numberOfPagesTextView.setText(intent.getStringExtra(EXTRA_EDIT_BOOK_NUMBER_OF_PAGES));
        String imageUrl = intent.getStringExtra(EXTRA_EDIT_BOOK_IMG);
        if (imageUrl != null) {
            Picasso.get()
                    .load(MainActivity.IMAGE_URL_BASE + imageUrl + "-L.jpg")
                    .placeholder(R.drawable.baseline_library_books_24).into(coverImageView);
        } else {
            coverImageView.setImageResource(R.drawable.baseline_library_books_24);
        }

    }
}
