package com.example.tinker;

import android.app.Application;
import android.content.Intent;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.entry.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tinkerpatch.sdk.TinkerPatch;

@DefaultLifeCycle(application = ".CustomApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class CustomApplicationLike extends DefaultApplicationLike {

    public CustomApplicationLike(Application application,
                                 int tinkerFlags,
                                 boolean tinkerLoadVerifyFlag,
                                 long applicationStartElapsedTime,
                                 long applicationStartMillisTime,
                                 Intent tinkerResultIntent) {

        super(application, tinkerFlags,
                tinkerLoadVerifyFlag, applicationStartElapsedTime,
                applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        TinkerManager.installTinker(this);
    }
}
