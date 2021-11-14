package com.nsibandelh.programminglanguages;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class LanguageAdapter extends BaseAdapter
{
    //Where is this going to run from
    private Context mContext;
    //Where is the data coming from
    private List<Language> mLanguageList;

    public LanguageAdapter(Context mContext, List<Language> mLanguageList)
    {
        this.mContext = mContext;
        this.mLanguageList = mLanguageList;
    }

    @Override
    public int getCount()
    {
        return 0;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return null;
    }
}
