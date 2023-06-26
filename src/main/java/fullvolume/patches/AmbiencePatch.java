package fullvolume.patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.screens.options.ToggleButton;

public class AmbiencePatch
{
    @SpirePatch(clz= ToggleButton.class,method="toggle")
    public static class ToggleButtonPatch
    {
        public static void Postfix(ToggleButton __instance)
        {
            Settings.soundPref.putBoolean("Ambience On", true);
            Settings.soundPref.putBoolean("Mute in Bg", false);
            Settings.AMBIANCE_ON = true;
            CardCrawlGame.MUTE_IF_BG = false;
            Settings.soundPref.flush();
        }
    }
}
