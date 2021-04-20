package com.ericapp.scheduledemo;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AffairLab {
    private static AffairLab sAffairLab;

    private List<Affair> mAffairs;

    public static AffairLab get(Context context){
        if (sAffairLab == null) {
            sAffairLab = new AffairLab(context);
        }
        return sAffairLab;
    }

    // 构造方法
    private AffairLab(Context context) {
        mAffairs = new ArrayList<>();
        // 生成100个crime
        for (int i=0; i < 100; i++) {
            Affair affair = new Affair();
            affair.setTitle("Affair #" + i);
            affair.setSolved(i%2==0);// every other one
            mAffairs.add(affair);
        }
    }

    public List<Affair> getAffairs() {
        return mAffairs;
    }

    public Affair getCrime(UUID id) {
        for (Affair affair : mAffairs) {
            if (affair.getId().equals(id)) {
                return affair;
            }
        }

        return null;
    }
}
