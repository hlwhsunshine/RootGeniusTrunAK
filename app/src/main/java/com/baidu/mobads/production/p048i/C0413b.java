package com.baidu.mobads.production.p048i;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.ActivityState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VideoState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VisitorAction;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdInternalConstants;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.p020d.C0232b;
import com.baidu.mobads.openad.p037e.C0368a;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p040vo.C0378d;
import com.baidu.mobads.production.C0375a;
import com.baidu.mobads.production.C0426t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.baidu.mobads.production.i.b */
public class C0413b extends C0375a implements IXLinearAdSlot, IOAdEventDispatcher {
    /* renamed from: w */
    private C0412a f940w;

    public C0413b(Context context, String str) {
        super(context);
        setId(str);
        this.f825p = SlotType.SLOT_TYPE_PREROLL;
    }

    /* renamed from: a */
    private void m875a(Set<String> set) {
        C0368a c0368a = new C0368a();
        for (String c0371d : set) {
            C0371d c0371d2 = new C0371d(c0371d, "");
            c0371d2.f798e = 1;
            c0368a.mo5118a(c0371d2, Boolean.valueOf(true));
        }
    }

    /* renamed from: a */
    protected void mo5145a(C0371d c0371d, C0426t c0426t, int i) {
        String str = (String) getParameter().get(IXAdInternalConstants.PARAMETER_KEY_OF_AD_REQUESTING_TIMEOUT);
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (Exception e) {
            }
        }
        c0426t.mo5117a(c0371d, (double) i);
    }

    /* renamed from: c */
    public void mo5154c() {
        this.f828s.mo4931i("XPrerollAdSlot", "afterAdContainerInit()");
        dispatchEvent(new C0232b(C0232b.COMPLETE));
    }

    /* renamed from: c */
    protected void mo5155c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        if (iXAdContainer.getAdContainerContext().getAdInstanceInfo().getCreativeType() == CreativeType.STATIC_IMAGE || iXAdContainer.getAdContainerContext().getAdInstanceInfo().getCreativeType() == CreativeType.GIF) {
            start();
        }
    }

    /* renamed from: d */
    protected void mo5157d() {
        this.f823n = 8000;
    }

    /* renamed from: d */
    protected void mo5158d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        Set hashSet = new HashSet();
        hashSet.addAll(iXAdContainer.getAdContainerContext().getAdInstanceInfo().getStartTrackers());
        m875a(hashSet);
    }

    /* renamed from: e */
    protected void mo5160e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.mo5160e(iXAdContainer, hashMap);
        this.f822m = SlotState.COMPLETED;
    }

    public int getDuration() {
        return this.f817h == null ? super.getDuration() : (int) this.f817h.getDuration();
    }

    public Object getParameter(String str) {
        return null;
    }

    public int getPlayheadTime() {
        return this.f817h == null ? super.getPlayheadTime() : (int) this.f817h.getPlayheadTime();
    }

    public void load() {
        this.f827r.set(true);
        super.load();
    }

    /* renamed from: m */
    public C0378d getAdRequestInfo() {
        return this.f940w;
    }

    public void notifyVisitorAction(VisitorAction visitorAction) {
    }

    public void pause() {
        this.f828s.mo4931i("XPrerollAdSlot", "pause()" + getSlotState().getValue());
        if (getSlotState() == SlotState.PLAYING) {
            super.pause();
        }
    }

    public void request() {
        int parseInt;
        int parseInt2;
        this.f940w = new C0412a(getApplicationContext(), getActivity(), this.f825p, this);
        this.f940w.mo5181d(getId());
        HashMap parameter = getParameter();
        String str = (String) parameter.get(IXAdInternalConstants.PARAMETER_KEY_OF_BASE_WIDTH);
        String str2 = (String) parameter.get(IXAdInternalConstants.PARAMETER_KEY_OF_BASE_HEIGHT);
        if (str != null) {
            try {
                parseInt = Integer.parseInt(str);
            } catch (Exception e) {
                parseInt = 0;
            }
        } else {
            parseInt = 0;
        }
        if (str2 != null) {
            try {
                parseInt2 = Integer.parseInt(str2);
            } catch (Exception e2) {
                parseInt2 = 0;
            }
        } else {
            parseInt2 = 0;
        }
        this.f940w.mo5171a(parseInt);
        this.f940w.mo5175b(parseInt2);
        super.mo5149a(this.f940w);
    }

    public void resume() {
        this.f828s.mo4931i("XPrerollAdSlot", "resume()" + getSlotState().getValue());
        if (getSlotState() == SlotState.PAUSED) {
            super.resume();
        }
    }

    public void setActivityState(ActivityState activityState) {
    }

    public void setContentVideoAssetCurrentTimePosition(double d) {
    }

    public void setMaxAdNum(int i) {
    }

    public void setMaxDuration(int i) {
    }

    public void setParameter(String str, Object obj) {
    }

    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.f814e = relativeLayout;
    }

    public void setVideoState(VideoState videoState) {
    }

    public void start() {
        if (this.f827r.get()) {
            super.start();
        } else {
            load();
        }
    }

    public void stop() {
        this.f828s.mo4931i("XPrerollAdSlot", "stop()" + getSlotState().getValue());
        super.stop();
    }
}
