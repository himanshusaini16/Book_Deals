package com.example.john.bookdeals.navigation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.john.bookdeals.PostingIT;
import com.example.john.bookdeals.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class App_PostAds extends Fragment {
    View v;
    protected ExpandableListView expandableListView;
    private List<String> parentHeaderInformation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_app__post_ads, container, false);
        parentHeaderInformation = new ArrayList<String>();

        parentHeaderInformation.add("Automobile Engineering");
        parentHeaderInformation.add("Civil Engineering");
        parentHeaderInformation.add("Computer Science Engineering");
        parentHeaderInformation.add("Electronics & Comm. Engineering");
        parentHeaderInformation.add("Mechanical Engineering");
        parentHeaderInformation.add("Stationary Items");


        HashMap<String, List<String>> allChildItems = returnGroupedChildItems();

        expandableListView = (ExpandableListView) v.findViewById(R.id.expandableListView);

        ExpandableListViewAdapter expandableListViewAdapter = new ExpandableListViewAdapter(getContext(), parentHeaderInformation, allChildItems);

        expandableListView.setAdapter(expandableListViewAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if(groupPosition==0&&childPosition==0)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Automobile Engineering 1st Semester");
                    startActivity(i);
                }
                if(groupPosition==0&&childPosition==1)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Automobile Engineering 2nd Semester");
                    startActivity(i);
                }
                if(groupPosition==0&&childPosition==2)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Automobile Engineering 3rd Semester");
                    startActivity(i);
                }
                if(groupPosition==0&&childPosition==3)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Automobile Engineering 4th Semester");
                    startActivity(i);
                }
                if(groupPosition==0&&childPosition==4)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Automobile Engineering 5th Semester");
                    startActivity(i);
                }
                if(groupPosition==0&&childPosition==5)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Automobile Engineering 6th Semester");
                    startActivity(i);
                }
                if(groupPosition==0&&childPosition==6)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Automobile Engineering 7th Semester");
                    startActivity(i);
                }
                if(groupPosition==0&&childPosition==7)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Automobile Engineering 8th Semester");
                    startActivity(i);
                }





                if(groupPosition==1&&childPosition==0)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Civil Engineering 1st Semester");
                    startActivity(i);
                }
                if(groupPosition==1&&childPosition==1)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Civil Engineering 2nd Semester");
                    startActivity(i);
                }
                if(groupPosition==1&&childPosition==2)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Civil Engineering 3rd Semester");
                    startActivity(i);
                }
                if(groupPosition==1&&childPosition==3)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Civil Engineering 4th Semester");
                    startActivity(i);
                }
                if(groupPosition==1&&childPosition==4)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Civil Engineering 5th Semester");
                    startActivity(i);
                }
                if(groupPosition==1&&childPosition==5)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Civil Engineering 6th Semester");
                    startActivity(i);
                }
                if(groupPosition==1&&childPosition==6)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Civil Engineering 7th Semester");
                    startActivity(i);
                }
                if(groupPosition==1&&childPosition==7)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","CS Engineering 8th Semester");
                    startActivity(i);
                }



                if(groupPosition==2&&childPosition==0)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","CS Engineering 1st Semester");
                    startActivity(i);
                }
                if(groupPosition==2&&childPosition==1)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","CS Engineering 2nd Semester");
                    startActivity(i);
                }
                if(groupPosition==2&&childPosition==2)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","CS Engineering 3rd Semester");
                    startActivity(i);
                }
                if(groupPosition==2&&childPosition==3)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","CS Engineering 4th Semester");
                    startActivity(i);
                }
                if(groupPosition==2&&childPosition==4)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","CS Engineering 5th Semester");
                    startActivity(i);
                }
                if(groupPosition==2&&childPosition==5)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","CS Engineering 6th Semester");
                    startActivity(i);
                }
                if(groupPosition==2&&childPosition==6)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","CS Engineering 7th Semester");
                    startActivity(i);
                }
                if(groupPosition==2&&childPosition==7)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","CS Engineering 8th Semester");
                    startActivity(i);
                }




                if(groupPosition==3&&childPosition==0)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","ECE Engineering 1st Semester");
                    startActivity(i);
                }
                if(groupPosition==3&&childPosition==1)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","ECE Engineering 2nd Semester");
                    startActivity(i);
                }
                if(groupPosition==3&&childPosition==2)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","ECE Engineering 3rd Semester");
                    startActivity(i);
                }
                if(groupPosition==3&&childPosition==3)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","ECE Engineering 4th Semester");
                    startActivity(i);
                }
                if(groupPosition==3&&childPosition==4)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","ECE Engineering 5th Semester");
                    startActivity(i);
                }
                if(groupPosition==3&&childPosition==5)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","ECE Engineering 6th Semester");
                    startActivity(i);
                }
                if(groupPosition==3&&childPosition==6)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","ECE Engineering 7th Semester");
                    startActivity(i);
                }
                if(groupPosition==3&&childPosition==7)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","ECE Engineering 8th Semester");
                    startActivity(i);
                }




                if(groupPosition==4&&childPosition==0)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Mechanical Engineering 1st Semester");
                    startActivity(i);
                }
                if(groupPosition==4&&childPosition==1)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Mechanical Engineering 2nd Semester");
                    startActivity(i);
                }
                if(groupPosition==4&&childPosition==2)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Mechanical Engineering 3rd Semester");
                    startActivity(i);
                }
                if(groupPosition==4&&childPosition==3)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Mechanical Engineering 4th Semester");
                    startActivity(i);
                }
                if(groupPosition==4&&childPosition==4)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Mechanical Engineering 5th Semester");
                    startActivity(i);
                }
                if(groupPosition==4&&childPosition==5)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Mechanical Engineering 6th Semester");
                    startActivity(i);
                }
                if(groupPosition==4&&childPosition==6)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Mechanical Engineering 7th Semester");
                    startActivity(i);
                }
                if(groupPosition==4&&childPosition==7)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Mechanical Engineering 8th Semester");
                    startActivity(i);
                }


                if(groupPosition==5&&childPosition==0)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Other Books");
                    startActivity(i);
                }
                if(groupPosition==5&&childPosition==1)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Hand Books");
                    startActivity(i);
                }
                if(groupPosition==5&&childPosition==2)
                {
                    Intent i=new Intent(getContext(), PostingIT.class);
                    i.putExtra("str","Stationary Items");
                    startActivity(i);
                }


                return false;
            }
        });

        return v;
    }


    private HashMap<String, List<String>> returnGroupedChildItems(){

        final HashMap<String, List<String>> childContent = new HashMap<String, List<String>>();

        List<String> automobile = new ArrayList<String>();

        automobile.add("1st Semester"); automobile.add("2nd Semester"); automobile.add("3rd Semester"); automobile.add("4th Semester");
        automobile.add("5th Semester"); automobile.add("6th Semester"); automobile.add("7th Semester"); automobile.add("8th Semester");

        List<String> civil = new ArrayList<String>();

        civil.add("1st Semester"); civil.add("2nd Semester"); civil.add("3rd Semester"); civil.add("4th Semester");
        civil.add("5th Semester"); civil.add("6th Semester"); civil.add("7th Semester"); civil.add("8th Semester");

        List<String> cs = new ArrayList<String>();

        cs.add("1st Semester"); cs.add("2nd Semester"); cs.add("3rd Semester"); cs.add("4th Semester");
        cs.add("5th Semester"); cs.add("6th Semester"); cs.add("7th Semester"); cs.add("8th Semester");

        List<String> ece = new ArrayList<String>();

        ece.add("1st Semester"); ece.add("2nd Semester"); ece.add("3rd Semester"); ece.add("4th Semester");
        ece.add("5th Semester"); ece.add("6th Semester"); ece.add("7th Semester"); ece.add("8th Semester");

        List<String> me = new ArrayList<String>();

        me.add("1st Semester"); me.add("2nd Semester"); me.add("3rd Semester"); me.add("4th Semester");
        me.add("5th Semester"); me.add("6th Semester"); me.add("7th Semester"); me.add("8th Semester");

        List<String> items = new ArrayList<String>();

        items.add("Other Books");
        items.add("Hand Books");
        items.add("Stationary Items");



        childContent.put(parentHeaderInformation.get(0), automobile);

        childContent.put(parentHeaderInformation.get(1), civil);

        childContent.put(parentHeaderInformation.get(2), cs);
        childContent.put(parentHeaderInformation.get(3), ece);

        childContent.put(parentHeaderInformation.get(4), me);

        childContent.put(parentHeaderInformation.get(5), items);



        return childContent;

    }


    }



