package com.github.propenster.birthdaycontactmanager.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.propenster.birthdaycontactmanager.Models.Contact;
import com.github.propenster.birthdaycontactmanager.R;
import com.github.propenster.birthdaycontactmanager.SingleBirthContactActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyCustomListAdapter extends BaseAdapter {

    private Activity activity;
    ArrayList<Contact> contactArrayList;
    LayoutInflater inflater;

    public MyCustomListAdapter(Activity activity, ArrayList<Contact> contactArrayList) {
        this.activity = activity;
        this.contactArrayList = contactArrayList;
    }


    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null){
            inflater = this.activity.getLayoutInflater();
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom_birthday_item, null);
        }

        //init all views to be passed...
        ImageView birthdayContactImageView = (ImageView)convertView.findViewById(R.id.birthdayContactImageView);
        TextView txt_BirthdayContactName = (TextView)convertView.findViewById(R.id.txt_BirthdayContactName);
        TextView txt_BirthdayContactPhone = (TextView)convertView.findViewById(R.id.txt_BirthdayContactPhone);
        TextView txt_BirthdayContactBirthDate = (TextView)convertView.findViewById(R.id.txt_BirthdayContactBirthDate);
        LinearLayout rootLinearLayout = (LinearLayout)convertView.findViewById(R.id.rootLinearLayout);
        Contact contact = (Contact)this.contactArrayList.get(position);

        //Picasso.with(context).load(R.drawable.drawableName).into(imageView);
        Picasso.get().load(R.drawable.icon_faith_avatar).placeholder(R.mipmap.ic_launcher).fit().centerCrop().into(birthdayContactImageView);
        birthdayContactImageView.setImageResource(R.mipmap.ic_launcher);
        txt_BirthdayContactName.setText(contact.getContactName());
        txt_BirthdayContactPhone.setText(contact.getContactPhone());
        txt_BirthdayContactBirthDate.setText(contact.getContactBirthDate().toString());


        rootLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "You have selected the Contact " + getItemId(position+1), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, SingleBirthContactActivity.class);
                intent.putExtra("birthContactObject", contact);
                activity.startActivity(intent);

//                Picasso.with(context).load(url)
//                        .resize(w, h)
//                        .into(myImageView, new Callback() {
//                            @Override
//                            public void onSuccess() {
//                                Bitmap imageBitmap = ((BitmapDrawable) myImageView.getDrawable()).getBitmap();
//                                RoundedBitmapDrawable imageDrawable = RoundedBitmapDrawableFactory.create(getResources(), imageBitmap);
//                                imageDrawable.setCircular(true);
//                                imageDrawable.setCornerRadius(Math.max(imageBitmap.getWidth(), imageBitmap.getHeight()) / 2.0f);
//                                myImageView.setImageDrawable(imageDrawable);
//                            }
//                            @Override
//                            public void onError() {
//                                myImageView.setImageResource(R.drawable.default_image);
//                            }
//                        });

            }
        });



        return convertView;
    }
}
