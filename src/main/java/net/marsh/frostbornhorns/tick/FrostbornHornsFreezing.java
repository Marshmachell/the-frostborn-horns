package net.marsh.frostbornhorns.tick;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.List;

import static net.marsh.frostbornhorns.gamerule.FrostbornHornsGamerules.FROSTBORN_HORNS_FREEZING;

public class FrostbornHornsFreezing {
    public static void tick(MinecraftServer server) {
        if (server.getGameRules().getBoolean(FROSTBORN_HORNS_FREEZING)) {
            filterFreezingPlayers(server.getPlayerManager().getPlayerList())
                    .forEach(player -> player.sendMessage(Text.of("holodno"), true));
        }
    }

    private static boolean isValidBiome(Biome biome) {
        return biome.getTemperature() < 0.15f && biome.hasPrecipitation();
    }

    private static boolean isSnowstorm(World world) {
        return world.isThundering();
    }

    private static List<ServerPlayerEntity> filterFreezingPlayers(List<ServerPlayerEntity> players) {
        return players.stream()
                .filter(player -> {
                    Biome biome = player.getWorld()
                            .getBiome(BlockPos.ofFloored(player.getPos()))
                            .value();
                    return isValidBiome(biome) && isSnowstorm(player.getWorld());
                })
                .toList();
    }
}
