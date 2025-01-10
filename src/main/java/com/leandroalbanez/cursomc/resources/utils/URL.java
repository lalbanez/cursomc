package com.leandroalbanez.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
    public static String decodeParam(String param) {
        try {
            return URLDecoder.decode(param, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static List<Integer> decodeIntList(String s) {
        String[] array = s.split(",");
        List<Integer> lista = new ArrayList<Integer>();
        for (String inteiro : array) {
            lista.add(Integer.parseInt(inteiro));
        }
        return lista;
        //return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x))
        // .collect(Collectors.toList());
    }

}
