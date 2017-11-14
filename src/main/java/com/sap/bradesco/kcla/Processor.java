package com.sap.bradesco.kcla;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Processor {

    public List<KclaBean> parseToKclaBean(String filename) throws IOException {

        List<KclaBean> kclaFile = new ArrayList<KclaBean>();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.readLine();
        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            kclaFile.add(new KclaBean(currentLine));
        }

        return kclaFile;
    }

    public List<Set<KclaBean>> clearLocks(List<KclaBean> parsedFile) {
        List<Set<KclaBean>> breakdown = new ArrayList<Set<KclaBean>>();
        breakdown.add(new HashSet<KclaBean>());
        for(KclaBean bean: parsedFile){
            addToNotLockingSet(bean, breakdown);
        }

        return breakdown;
    }

    private void addToNotLockingSet(KclaBean bean, List<Set<KclaBean>> breakdown) {
        for(int i = 0; i < (breakdown.size() + 1); i++){
            if(i < breakdown.size()){
                boolean inserted = breakdown.get(i).add(bean);
                if(inserted){
                    break;
                }
            }
            else {
                Set<KclaBean> newSet = new HashSet<KclaBean>();
                newSet.add(bean);
                breakdown.add(newSet);
                break;
            }
        }
    }
}
