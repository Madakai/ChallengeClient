package net.challenge.client.features.modules.impl.challenge

import me.zero.alpine.event.EventPriority
import me.zero.alpine.listener.EventHandler
import me.zero.alpine.listener.EventHook
import me.zero.alpine.listener.Listener
import net.challenge.client.events.Render2DEvent
import net.challenge.client.features.modules.Module
import net.challenge.client.features.modules.ModuleCategory
import net.challenge.client.features.modules.annotations.ModuleInfo
import net.challenge.client.features.teammate.ITeammateHandler
import net.challenge.client.ui.hud.customHud.GuiCustomHud
import net.challenge.client.ui.hud.customHud.renderer.HudRenderer
import net.challenge.client.ui.widget.utils.RenderUtils
import net.challenge.configu.value.VTag
import net.challenge.configu.value.impl.VBool
import net.minecraft.client.gui.ScaledResolution
import java.awt.Color
import java.util.function.Predicate
import kotlin.math.roundToInt

/**
 * All team members must be at the same height,
 * otherwise there is a black screen for everyone.
 */
@ModuleInfo("Same-Height", "All team members must be at the same height, otherwise there is a black screen for everyone.", ModuleCategory.CHALLENGE)
class SameHeightChallenge(

        /**
         * Handler to manage teammates.
         */
        private val teammateHandler: ITeammateHandler

) : Module() {

    @VTag("OnlyVisible", "Only visible players")
    private val onlyVisible = VBool(true)

    @EventHandler
    private val render2DListener: Listener<Render2DEvent> = Listener(
            EventHook {
                val sr = ScaledResolution(mc)
                RenderUtils.drawRect(0.0F, 0.0F, sr.scaledWidth.toFloat(), sr.scaledHeight.toFloat(), Color.BLACK.rgb)
            },

            EventPriority.LOWEST,

            // Filter
            Predicate {
                teammateNotSamePosY()
            }
    )

    private fun teammateNotSamePosY(): Boolean {
        val playerPosY = mc.thePlayer.posY

        teammateHandler.getPlayers().forEach { teammateName ->
            val entity = mc.theWorld.loadedEntityList
                    .firstOrNull { entity -> entity.name.equals(teammateName, true) && (entity.isInvisible.not() || onlyVisible.value.not()) }
                    ?: return@forEach

            if (!entity.name.equals(teammateName, true)) return@forEach
            if (entity.posY.roundToInt() == playerPosY.roundToInt()) return@forEach

            return true
        }

        return false
    }
}