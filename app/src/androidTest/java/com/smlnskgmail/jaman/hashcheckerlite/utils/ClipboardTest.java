package com.smlnskgmail.jaman.hashcheckerlite.utils;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.smlnskgmail.jaman.hashcheckerlite.MainActivity;
import com.smlnskgmail.jaman.hashcheckerlite.logic.support.Clipboard;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClipboardTest {

    @Rule
    public final ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(
            MainActivity.class
    );

    @Test
    public void validateClipboardTest() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync(() -> {
            Activity activity = activityTestRule.getActivity();

            String text = "Test text";
            new Clipboard(
                    activity,
                    text
            ).copy();

            ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService(
                    Context.CLIPBOARD_SERVICE
            );

            assertEquals(
                    clipboardManager.getPrimaryClip().getItemAt(0).coerceToText(
                            activity
                    ),
                    text
            );
        });

    }

}
