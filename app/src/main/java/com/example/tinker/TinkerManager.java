package com.example.tinker;

import android.content.Context;

import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tinkerpatch.sdk.TinkerPatch;

public class TinkerManager {

    public static boolean isInstalled = false;

    private static ApplicationLike mApplicationLike;

    public static void installTinker(ApplicationLike applicationLike) {
        mApplicationLike = applicationLike;

        if (isInstalled) {
            return;
        }

        TinkerPatch.init(applicationLike)
                .reflectPatchLibrary()
                .setPatchRollbackOnScreenOff(true)
                .setPatchRestartOnSrceenOff(true)
                .setFetchPatchIntervalByHours(3);

        // 每隔3个小时（通过setFetchPatchIntervalByHours设置）去访问后台时候有更新,通过handler实现轮训的效果
        TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();
    }

    public static void loadPatch(String patch) {
        if (isInstalled) {
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), patch);
        }
    }

    public static Context getApplicationContext() {
        if (mApplicationLike != null) {
            return mApplicationLike.getApplication().getApplicationContext();
        }
        return null;
    }
}
