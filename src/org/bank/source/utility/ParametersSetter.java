package org.bank.source.utility;

import org.bank.source.model.StopWords;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParametersSetter {


    public List<String> splitParams(String query){
        int whereIndex = query.toLowerCase().indexOf("where");
        if(whereIndex != -1) {
            query = query.substring(whereIndex);
            for (StopWords words : StopWords.values()) {
                query = query.replace(words.getStopWord(), "");
            }
            return Arrays.stream(query.split("=?\\?")).map(x -> x.trim().replace("\"", "")).collect(Collectors.toList());

        }
        return null;
    }
}
