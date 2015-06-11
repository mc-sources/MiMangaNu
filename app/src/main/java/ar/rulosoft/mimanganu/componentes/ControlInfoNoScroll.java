package ar.rulosoft.mimanganu.componentes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ar.rulosoft.mimanganu.R;

/**
 * Created by Raul on 16/05/2015.
 */
public class ControlInfoNoScroll extends LinearLayout implements Imaginable {
    View s1, s2, s3, s4;
    // TODO: Needs translation. Possibly breaks databse?
    TextView author, status, server, synopsis, title;
    TextView authorTitle, statusTitle, serverTitle;
    ImageView image;

    public ControlInfoNoScroll(Context context) {
        super(context);
        initialize();
    }

    public ControlInfoNoScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public ControlInfoNoScroll(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    public void initialize() {
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.control_info, this, true);
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);
        authorTitle = (TextView) findViewById(R.id.autorTitle);
        statusTitle = (TextView) findViewById(R.id.estadoTitle);
        serverTitle = (TextView) findViewById(R.id.servidorTitle);
        status = (TextView) findViewById(R.id.estado);
        server = (TextView) findViewById(R.id.servidor);
        synopsis = (TextView) findViewById(R.id.sinopsis);
        title = (TextView) findViewById(R.id.titulo);
        author = (TextView) findViewById(R.id.autor);
        image = (ImageView) findViewById(R.id.imagen);
    }

    public void setColor(int color) {
        Drawable colorDrawable = new ColorDrawable(color);
        if (Build.VERSION.SDK_INT >= 16) {
            s1.setBackground(colorDrawable);
            s2.setBackground(colorDrawable);
            s3.setBackground(colorDrawable);
            s4.setBackground(colorDrawable);
            title.setBackground(colorDrawable);
        } else {
            s1.setBackgroundDrawable(colorDrawable);
            s2.setBackgroundDrawable(colorDrawable);
            s3.setBackgroundDrawable(colorDrawable);
            s4.setBackgroundDrawable(colorDrawable);
            title.setBackgroundDrawable(colorDrawable);
        }
        authorTitle.setTextColor(color);
        statusTitle.setTextColor(color);
        serverTitle.setTextColor(color);
    }

    public void setAuthor(String author) {
        this.author.setText(author);
    }

    public void setStatus(String status) {
        this.status.setText(status);
    }

    public void setServer(String server) {
        this.server.setText(server);
    }

    public void setSynopsis(String synopsis) {
        this.synopsis.setText(synopsis);
    }

    @Override
    public void setImageBitmap(Bitmap b) {
        image.setImageBitmap(b);
    }

    @Override
    public void setImageResource(int id) {
        image.setImageResource(id);
    }

    public void setTitle(String title) {
        if (title.length() > 2)
            this.title.setVisibility(View.VISIBLE);
        else
            this.title.setVisibility(View.GONE);
        this.title.setText(title);
    }
}
