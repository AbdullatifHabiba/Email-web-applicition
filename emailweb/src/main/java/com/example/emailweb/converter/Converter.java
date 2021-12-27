package com.example.emailweb.converter;

import org.json.JSONException;
import java.text.ParseException;

public interface Converter<T, A> {

    T create(A i) throws JSONException, ParseException;
}
