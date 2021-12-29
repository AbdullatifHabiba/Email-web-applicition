package com.example.emailweb.sorting;

import com.example.emailweb.Email;

import java.util.ArrayList;

public class SortByDateA implements Sorter{

    @Override
    public void Sort(ArrayList<Email> emails) {
        QuickSort(emails, 0, emails.size() - 1);
    }

    public void QuickSort(ArrayList<Email> emails, int left, int right){
        int i, j, pivot;
        Email m;
        if (left < right){
            pivot = left;
            i = left;
            j = right;
            while (i < j){
                while (emails.get(i).getDate().before(emails.get(pivot).getDate()) && i < right)
                    i += 1;
                while (emails.get(j).getDate().after(emails.get(pivot).getDate()) && j > left)
                    j -= 1;
                if (i < j){
                    m = emails.get(i);
                    emails.set(i, emails.get(j));
                    emails.set(j, m);
                }
                m = emails.get(pivot);
                emails.set(pivot, emails.get(j));
                emails.set(j, m);

                QuickSort(emails, left, j - 1);
                QuickSort(emails, j + 1, right);
            }
        }
    }
}
