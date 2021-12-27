package com.example.emailweb.sorting;

import com.example.emailweb.Email;

import java.util.ArrayList;

public class SortByDateD implements Sorter{
    SortByDateA SBDA = new SortByDateA();

    @Override
    public void Sort(ArrayList<Email> emails) {
        Email m;
        SBDA.QuickSort(emails, 0, emails.size() - 1);
        for (int i = 0;i < emails.size() / 2;i++){
            m = emails.get(emails.size() - i - 1);
            emails.set(emails.size() - i - 1, emails.get(i));
            emails.set(i, m);
        }
    }


}
