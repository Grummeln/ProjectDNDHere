package com.example.projectdndhere;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class PdfViewerActivity extends AppCompatActivity {

    private ImageView pdfImageView;
    private PdfRenderer pdfRenderer;
    private PdfRenderer.Page currentPage;
    private ParcelFileDescriptor parcelFileDescriptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview);

        pdfImageView = findViewById(R.id.pdf_image_view);

        // Specify the path of your PDF file
        String filePath = getFilesDir() + File.separator + "sheet_details.pdf";

        try {
            // Open the PDF file using ParcelFileDescriptor
            parcelFileDescriptor = ParcelFileDescriptor.open(new File("/sdcard/Android/data/com.example.projectdndhere/files/sheet_details.pdf"), ParcelFileDescriptor.MODE_READ_ONLY);

            // Create a PdfRenderer instance
            pdfRenderer = new PdfRenderer(parcelFileDescriptor);

            // Display the first page
            displayPage(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayPage(int pageIndex) {
        // Make sure to close the previous page before opening a new one
        if (currentPage != null) {
            currentPage.close();
        }

        currentPage = pdfRenderer.openPage(pageIndex);


        // Create a Bitmap to render the page
        Bitmap bitmap = Bitmap.createBitmap(currentPage.getWidth(), currentPage.getHeight(), Bitmap.Config.ARGB_8888);

        // Render the page content onto the Bitmap
        currentPage.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

        // Display the Bitmap in an ImageView
        pdfImageView.setImageBitmap(bitmap);

        // Update the height of the ImageView to match the bitmap height
        pdfImageView.getLayoutParams().height = bitmap.getHeight();
        pdfImageView.requestLayout();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Clean up resources
        if (currentPage != null) {
            currentPage.close();
        }
        if (pdfRenderer != null) {
            pdfRenderer.close();
        }
        try {
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
