package com.baidu.mobad.video;

import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import java.util.ArrayList;
import java.util.HashMap;

public class XAdSlotManager {
    /* renamed from: a */
    private HashMap<String, IXAdProd> f278a = new HashMap();

    public void addAdSlot(IXAdProd iXAdProd) {
        this.f278a.put(iXAdProd.getId(), iXAdProd);
    }

    public Boolean containsAdSlot(String str) {
        return Boolean.valueOf(this.f278a.containsKey(str));
    }

    public IXAdProd retrieve1stAdSlotByType(SlotType slotType) {
        ArrayList retrieveAdSlotsByType = retrieveAdSlotsByType(slotType);
        return retrieveAdSlotsByType.size() > 0 ? (IXAdProd) retrieveAdSlotsByType.get(0) : null;
    }

    public IXAdProd retrieveAdSlotById(String str) {
        return (IXAdProd) this.f278a.get(str);
    }

    public ArrayList<IXAdProd> retrieveAdSlotsByType(SlotType slotType) {
        ArrayList<IXAdProd> arrayList = new ArrayList();
        for (Object obj : this.f278a.keySet()) {
            IXAdProd iXAdProd = (IXAdProd) this.f278a.get(obj);
            if (iXAdProd.getType() == slotType) {
                arrayList.add(iXAdProd);
            }
        }
        return arrayList;
    }

    public IXAdProd retrievePauseAdSlot() {
        return retrieve1stAdSlotByType(SlotType.SLOT_TYPE_PAUSE_ROLL);
    }

    public IXLinearAdSlot retrievePostAdSlot() {
        return (IXLinearAdSlot) retrieve1stAdSlotByType(SlotType.SLOT_TYPE_POSTROLL);
    }

    public IXLinearAdSlot retrievePrerollAdSlot() {
        return (IXLinearAdSlot) retrieve1stAdSlotByType(SlotType.SLOT_TYPE_PREROLL);
    }
}
