package com.honestme.animetasteex;

import java.util.List;

/**
 * Created by zhangconglin on 2016/1/12.
 */
public class ATEApiTest {

    public void createTestMain(int type, int page){
        List<ATEListItem> list = ATEApiUtil.getDataFromUriMain(type,page);
        for(int i = 0;i<list.size();++i){
            LogUtil.d("TEST",list.get(i).toString());
        }
    }
    public void createTestAMZ(int type, int page){
        List<AMZListItem> listAMZ = ATEApiUtil.getDataFromUriAMZ(type,page);
        for(int i = 0;i<listAMZ.size();++i){
            LogUtil.d("TEST",listAMZ.get(i).toString());
        }
    }

}
