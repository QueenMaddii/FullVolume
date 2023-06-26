package fullvolume.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInstrumentPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.screens.options.Slider;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.FieldAccess;


public class VolumePatch
{
    @SpirePatch(clz= Slider.class,method="modifyVolume")
    public static class FullVolumeOnEdit
    {
        @SpireInstrumentPatch
        public static ExprEditor MaxVolume()
        {
            return new ExprEditor()
            {
                @Override
                public void edit(FieldAccess f) throws CannotCompileException
                {
                    if (f.getFieldName().equals("volume"))
                    {
                        f.replace("{$_ = 1.0f;}");
                    }
                }
            };
        }
    }
}