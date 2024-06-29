package com.zergatul.cheatutils.wrappers;

import net.fabricmc.loader.api.FabricLoader;

import java.util.HashMap;
import java.util.Map;

public class ClassRemapper {

    private static final boolean enabled = !FabricLoader.getInstance().getMappingResolver().getCurrentRuntimeNamespace().equals("named");
    private static final Map<String, String> obfToNorm = new HashMap<>();
    private static final Map<String, String> normToObf = new HashMap<>();

    private static String[] mappings = new String[] {
            // entities
            "net.minecraft.class_1265:net.minecraft.world.ContainerListener",
            "net.minecraft.class_1296:net.minecraft.world.entity.AgeableMob",
            "net.minecraft.class_1295:net.minecraft.world.entity.AreaEffectCloud",
            "net.minecraft.class_8149:net.minecraft.world.entity.Attackable",
            "net.minecraft.class_8113:net.minecraft.world.entity.Display",
            "net.minecraft.class_8113$class_8115:net.minecraft.world.entity.Display$BlockDisplay",
            "net.minecraft.class_8113$class_8122:net.minecraft.world.entity.Display$ItemDisplay",
            "net.minecraft.class_8113$class_8123:net.minecraft.world.entity.Display$TextDisplay",
            "net.minecraft.class_1297:net.minecraft.world.entity.Entity",
            "net.minecraft.class_9460:net.minecraft.world.entity.EquipmentUser",
            "net.minecraft.class_1303:net.minecraft.world.entity.ExperienceOrb",
            "net.minecraft.class_1307:net.minecraft.world.entity.FlyingMob",
            "net.minecraft.class_5776:net.minecraft.world.entity.GlowSquid",
            "net.minecraft.class_7248:net.minecraft.world.entity.HasCustomInventoryScreen",
            "net.minecraft.class_8150:net.minecraft.world.entity.Interaction",
            "net.minecraft.class_4981:net.minecraft.world.entity.ItemSteerable",
            "net.minecraft.class_9817:net.minecraft.world.entity.Leashable",
            "net.minecraft.class_6375:net.minecraft.world.entity.LerpingModel",
            "net.minecraft.class_1538:net.minecraft.world.entity.LightningBolt",
            "net.minecraft.class_1309:net.minecraft.world.entity.LivingEntity",
            "net.minecraft.class_6335:net.minecraft.world.entity.Marker",
            "net.minecraft.class_1308:net.minecraft.world.entity.Mob",
            "net.minecraft.class_5354:net.minecraft.world.entity.NeutralMob",
            "net.minecraft.class_9461:net.minecraft.world.entity.OminousItemSpawner",
            "net.minecraft.class_6025:net.minecraft.world.entity.OwnableEntity",
            "net.minecraft.class_1314:net.minecraft.world.entity.PathfinderMob",
            "net.minecraft.class_1316:net.minecraft.world.entity.PlayerRideableJumping",
            "net.minecraft.class_4582:net.minecraft.world.entity.PowerableMob",
            "net.minecraft.class_4094:net.minecraft.world.entity.ReputationEventHandler",
            "net.minecraft.class_5146:net.minecraft.world.entity.Saddleable",
            "net.minecraft.class_5147:net.minecraft.world.entity.Shearable",
            "net.minecraft.class_1321:net.minecraft.world.entity.TamableAnimal",
            "net.minecraft.class_8152:net.minecraft.world.entity.Targeting",
            "net.minecraft.class_8046:net.minecraft.world.entity.TraceableEntity",
            "net.minecraft.class_7988:net.minecraft.world.entity.VariantHolder",
            "net.minecraft.class_1421:net.minecraft.world.entity.ambient.AmbientCreature",
            "net.minecraft.class_1420:net.minecraft.world.entity.ambient.Bat",
            "net.minecraft.class_1422:net.minecraft.world.entity.animal.AbstractFish",
            "net.minecraft.class_1427:net.minecraft.world.entity.animal.AbstractGolem",
            "net.minecraft.class_1425:net.minecraft.world.entity.animal.AbstractSchoolingFish",
            "net.minecraft.class_1429:net.minecraft.world.entity.animal.Animal",
            "net.minecraft.class_4466:net.minecraft.world.entity.animal.Bee",
            "net.minecraft.class_5761:net.minecraft.world.entity.animal.Bucketable",
            "net.minecraft.class_1451:net.minecraft.world.entity.animal.Cat",
            "net.minecraft.class_1428:net.minecraft.world.entity.animal.Chicken",
            "net.minecraft.class_1431:net.minecraft.world.entity.animal.Cod",
            "net.minecraft.class_1430:net.minecraft.world.entity.animal.Cow",
            "net.minecraft.class_1433:net.minecraft.world.entity.animal.Dolphin",
            "net.minecraft.class_1432:net.minecraft.world.entity.animal.FlyingAnimal",
            "net.minecraft.class_4019:net.minecraft.world.entity.animal.Fox",
            "net.minecraft.class_1439:net.minecraft.world.entity.animal.IronGolem",
            "net.minecraft.class_1438:net.minecraft.world.entity.animal.MushroomCow",
            "net.minecraft.class_3701:net.minecraft.world.entity.animal.Ocelot",
            "net.minecraft.class_1440:net.minecraft.world.entity.animal.Panda",
            "net.minecraft.class_1453:net.minecraft.world.entity.animal.Parrot",
            "net.minecraft.class_1452:net.minecraft.world.entity.animal.Pig",
            "net.minecraft.class_1456:net.minecraft.world.entity.animal.PolarBear",
            "net.minecraft.class_1454:net.minecraft.world.entity.animal.Pufferfish",
            "net.minecraft.class_1463:net.minecraft.world.entity.animal.Rabbit",
            "net.minecraft.class_1462:net.minecraft.world.entity.animal.Salmon",
            "net.minecraft.class_1472:net.minecraft.world.entity.animal.Sheep",
            "net.minecraft.class_1471:net.minecraft.world.entity.animal.ShoulderRidingEntity",
            "net.minecraft.class_1473:net.minecraft.world.entity.animal.SnowGolem",
            "net.minecraft.class_1477:net.minecraft.world.entity.animal.Squid",
            "net.minecraft.class_1474:net.minecraft.world.entity.animal.TropicalFish",
            "net.minecraft.class_1481:net.minecraft.world.entity.animal.Turtle",
            "net.minecraft.class_1480:net.minecraft.world.entity.animal.WaterAnimal",
            "net.minecraft.class_1493:net.minecraft.world.entity.animal.Wolf",
            "net.minecraft.class_7298:net.minecraft.world.entity.animal.allay.Allay",
            "net.minecraft.class_9069:net.minecraft.world.entity.animal.armadillo.Armadillo",
            "net.minecraft.class_5762:net.minecraft.world.entity.animal.axolotl.Axolotl",
            "net.minecraft.class_7689:net.minecraft.world.entity.animal.camel.Camel",
            "net.minecraft.class_7102:net.minecraft.world.entity.animal.frog.Frog",
            "net.minecraft.class_7110:net.minecraft.world.entity.animal.frog.Tadpole",
            "net.minecraft.class_6053:net.minecraft.world.entity.animal.goat.Goat",
            "net.minecraft.class_1492:net.minecraft.world.entity.animal.horse.AbstractChestedHorse",
            "net.minecraft.class_1496:net.minecraft.world.entity.animal.horse.AbstractHorse",
            "net.minecraft.class_1495:net.minecraft.world.entity.animal.horse.Donkey",
            "net.minecraft.class_1498:net.minecraft.world.entity.animal.horse.Horse",
            "net.minecraft.class_1501:net.minecraft.world.entity.animal.horse.Llama",
            "net.minecraft.class_1500:net.minecraft.world.entity.animal.horse.Mule",
            "net.minecraft.class_1506:net.minecraft.world.entity.animal.horse.SkeletonHorse",
            "net.minecraft.class_3986:net.minecraft.world.entity.animal.horse.TraderLlama",
            "net.minecraft.class_1507:net.minecraft.world.entity.animal.horse.ZombieHorse",
            "net.minecraft.class_8153:net.minecraft.world.entity.animal.sniffer.Sniffer",
            "net.minecraft.class_1511:net.minecraft.world.entity.boss.enderdragon.EndCrystal",
            "net.minecraft.class_1510:net.minecraft.world.entity.boss.enderdragon.EnderDragon",
            "net.minecraft.class_1528:net.minecraft.world.entity.boss.wither.WitherBoss",
            "net.minecraft.class_1531:net.minecraft.world.entity.decoration.ArmorStand",
            "net.minecraft.class_9691:net.minecraft.world.entity.decoration.BlockAttachedEntity",
            "net.minecraft.class_5915:net.minecraft.world.entity.decoration.GlowItemFrame",
            "net.minecraft.class_1530:net.minecraft.world.entity.decoration.HangingEntity",
            "net.minecraft.class_1533:net.minecraft.world.entity.decoration.ItemFrame",
            "net.minecraft.class_1532:net.minecraft.world.entity.decoration.LeashFenceKnotEntity",
            "net.minecraft.class_1534:net.minecraft.world.entity.decoration.Painting",
            "net.minecraft.class_1540:net.minecraft.world.entity.item.FallingBlockEntity",
            "net.minecraft.class_1542:net.minecraft.world.entity.item.ItemEntity",
            "net.minecraft.class_1541:net.minecraft.world.entity.item.PrimedTnt",
            "net.minecraft.class_1543:net.minecraft.world.entity.monster.AbstractIllager",
            "net.minecraft.class_1547:net.minecraft.world.entity.monster.AbstractSkeleton",
            "net.minecraft.class_1545:net.minecraft.world.entity.monster.Blaze",
            "net.minecraft.class_9254:net.minecraft.world.entity.monster.Bogged",
            "net.minecraft.class_1549:net.minecraft.world.entity.monster.CaveSpider",
            "net.minecraft.class_1548:net.minecraft.world.entity.monster.Creeper",
            "net.minecraft.class_3745:net.minecraft.world.entity.monster.CrossbowAttackMob",
            "net.minecraft.class_1551:net.minecraft.world.entity.monster.Drowned",
            "net.minecraft.class_1550:net.minecraft.world.entity.monster.ElderGuardian",
            "net.minecraft.class_1560:net.minecraft.world.entity.monster.EnderMan",
            "net.minecraft.class_1559:net.minecraft.world.entity.monster.Endermite",
            "net.minecraft.class_1569:net.minecraft.world.entity.monster.Enemy",
            "net.minecraft.class_1564:net.minecraft.world.entity.monster.Evoker",
            "net.minecraft.class_1571:net.minecraft.world.entity.monster.Ghast",
            "net.minecraft.class_1570:net.minecraft.world.entity.monster.Giant",
            "net.minecraft.class_1577:net.minecraft.world.entity.monster.Guardian",
            "net.minecraft.class_1576:net.minecraft.world.entity.monster.Husk",
            "net.minecraft.class_1581:net.minecraft.world.entity.monster.Illusioner",
            "net.minecraft.class_1589:net.minecraft.world.entity.monster.MagmaCube",
            "net.minecraft.class_1588:net.minecraft.world.entity.monster.Monster",
            "net.minecraft.class_3732:net.minecraft.world.entity.monster.PatrollingMonster",
            "net.minecraft.class_1593:net.minecraft.world.entity.monster.Phantom",
            "net.minecraft.class_1604:net.minecraft.world.entity.monster.Pillager",
            "net.minecraft.class_1603:net.minecraft.world.entity.monster.RangedAttackMob",
            "net.minecraft.class_1584:net.minecraft.world.entity.monster.Ravager",
            "net.minecraft.class_1606:net.minecraft.world.entity.monster.Shulker",
            "net.minecraft.class_1614:net.minecraft.world.entity.monster.Silverfish",
            "net.minecraft.class_1613:net.minecraft.world.entity.monster.Skeleton",
            "net.minecraft.class_1621:net.minecraft.world.entity.monster.Slime",
            "net.minecraft.class_1617:net.minecraft.world.entity.monster.SpellcasterIllager",
            "net.minecraft.class_1628:net.minecraft.world.entity.monster.Spider",
            "net.minecraft.class_1627:net.minecraft.world.entity.monster.Stray",
            "net.minecraft.class_4985:net.minecraft.world.entity.monster.Strider",
            "net.minecraft.class_1634:net.minecraft.world.entity.monster.Vex",
            "net.minecraft.class_1632:net.minecraft.world.entity.monster.Vindicator",
            "net.minecraft.class_1640:net.minecraft.world.entity.monster.Witch",
            "net.minecraft.class_1639:net.minecraft.world.entity.monster.WitherSkeleton",
            "net.minecraft.class_5136:net.minecraft.world.entity.monster.Zoglin",
            "net.minecraft.class_1642:net.minecraft.world.entity.monster.Zombie",
            "net.minecraft.class_1641:net.minecraft.world.entity.monster.ZombieVillager",
            "net.minecraft.class_1590:net.minecraft.world.entity.monster.ZombifiedPiglin",
            "net.minecraft.class_8949:net.minecraft.world.entity.monster.breeze.Breeze",
            "net.minecraft.class_4760:net.minecraft.world.entity.monster.hoglin.Hoglin",
            "net.minecraft.class_5137:net.minecraft.world.entity.monster.hoglin.HoglinBase",
            "net.minecraft.class_5418:net.minecraft.world.entity.monster.piglin.AbstractPiglin",
            "net.minecraft.class_4836:net.minecraft.world.entity.monster.piglin.Piglin",
            "net.minecraft.class_5419:net.minecraft.world.entity.monster.piglin.PiglinBrute",
            "net.minecraft.class_7260:net.minecraft.world.entity.monster.warden.Warden",
            "net.minecraft.class_3988:net.minecraft.world.entity.npc.AbstractVillager",
            "net.minecraft.class_6067:net.minecraft.world.entity.npc.InventoryCarrier",
            "net.minecraft.class_1655:net.minecraft.world.entity.npc.Npc",
            "net.minecraft.class_1646:net.minecraft.world.entity.npc.Villager",
            "net.minecraft.class_3851:net.minecraft.world.entity.npc.VillagerDataHolder",
            "net.minecraft.class_3989:net.minecraft.world.entity.npc.WanderingTrader",
            "net.minecraft.class_1657:net.minecraft.world.entity.player.Player",
            "net.minecraft.class_1665:net.minecraft.world.entity.projectile.AbstractArrow",
            "net.minecraft.class_1668:net.minecraft.world.entity.projectile.AbstractHurtingProjectile",
            "net.minecraft.class_1667:net.minecraft.world.entity.projectile.Arrow",
            "net.minecraft.class_1670:net.minecraft.world.entity.projectile.DragonFireball",
            "net.minecraft.class_1669:net.minecraft.world.entity.projectile.EvokerFangs",
            "net.minecraft.class_1672:net.minecraft.world.entity.projectile.EyeOfEnder",
            "net.minecraft.class_3855:net.minecraft.world.entity.projectile.Fireball",
            "net.minecraft.class_1671:net.minecraft.world.entity.projectile.FireworkRocketEntity",
            "net.minecraft.class_1536:net.minecraft.world.entity.projectile.FishingHook",
            "net.minecraft.class_3856:net.minecraft.world.entity.projectile.ItemSupplier",
            "net.minecraft.class_1674:net.minecraft.world.entity.projectile.LargeFireball",
            "net.minecraft.class_1673:net.minecraft.world.entity.projectile.LlamaSpit",
            "net.minecraft.class_1676:net.minecraft.world.entity.projectile.Projectile",
            "net.minecraft.class_1678:net.minecraft.world.entity.projectile.ShulkerBullet",
            "net.minecraft.class_1677:net.minecraft.world.entity.projectile.SmallFireball",
            "net.minecraft.class_1680:net.minecraft.world.entity.projectile.Snowball",
            "net.minecraft.class_1679:net.minecraft.world.entity.projectile.SpectralArrow",
            "net.minecraft.class_3857:net.minecraft.world.entity.projectile.ThrowableItemProjectile",
            "net.minecraft.class_1682:net.minecraft.world.entity.projectile.ThrowableProjectile",
            "net.minecraft.class_1681:net.minecraft.world.entity.projectile.ThrownEgg",
            "net.minecraft.class_1684:net.minecraft.world.entity.projectile.ThrownEnderpearl",
            "net.minecraft.class_1683:net.minecraft.world.entity.projectile.ThrownExperienceBottle",
            "net.minecraft.class_1686:net.minecraft.world.entity.projectile.ThrownPotion",
            "net.minecraft.class_1685:net.minecraft.world.entity.projectile.ThrownTrident",
            "net.minecraft.class_1687:net.minecraft.world.entity.projectile.WitherSkull",
            "net.minecraft.class_9236:net.minecraft.world.entity.projectile.windcharge.AbstractWindCharge",
            "net.minecraft.class_9238:net.minecraft.world.entity.projectile.windcharge.BreezeWindCharge",
            "net.minecraft.class_8956:net.minecraft.world.entity.projectile.windcharge.WindCharge",
            "net.minecraft.class_3763:net.minecraft.world.entity.raid.Raider",
            "net.minecraft.class_1688:net.minecraft.world.entity.vehicle.AbstractMinecart",
            "net.minecraft.class_1693:net.minecraft.world.entity.vehicle.AbstractMinecartContainer",
            "net.minecraft.class_1690:net.minecraft.world.entity.vehicle.Boat",
            "net.minecraft.class_7264:net.minecraft.world.entity.vehicle.ChestBoat",
            "net.minecraft.class_7265:net.minecraft.world.entity.vehicle.ContainerEntity",
            "net.minecraft.class_1695:net.minecraft.world.entity.vehicle.Minecart",
            "net.minecraft.class_1694:net.minecraft.world.entity.vehicle.MinecartChest",
            "net.minecraft.class_1697:net.minecraft.world.entity.vehicle.MinecartCommandBlock",
            "net.minecraft.class_1696:net.minecraft.world.entity.vehicle.MinecartFurnace",
            "net.minecraft.class_1700:net.minecraft.world.entity.vehicle.MinecartHopper",
            "net.minecraft.class_1699:net.minecraft.world.entity.vehicle.MinecartSpawner",
            "net.minecraft.class_1701:net.minecraft.world.entity.vehicle.MinecartTNT",
            "net.minecraft.class_8836:net.minecraft.world.entity.vehicle.VehicleEntity",
            "net.minecraft.class_1915:net.minecraft.world.item.trading.Merchant",
            "net.minecraft.class_2615:net.minecraft.world.level.block.entity.Hopper",
            "net.minecraft.class_8514:net.minecraft.world.level.gameevent.vibrations.VibrationSystem",
            "net.minecraft.class_742:net.minecraft.client.player.AbstractClientPlayer",
            "net.minecraft.class_746:net.minecraft.client.player.LocalPlayer",
            "net.minecraft.class_745:net.minecraft.client.player.RemotePlayer",

            // menus
            "net.minecraft.class_1720:net.minecraft.world.inventory.AbstractFurnaceMenu",
            "net.minecraft.class_1706:net.minecraft.world.inventory.AnvilMenu",
            "net.minecraft.class_1704:net.minecraft.world.inventory.BeaconMenu",
            "net.minecraft.class_3705:net.minecraft.world.inventory.BlastFurnaceMenu",
            "net.minecraft.class_1708:net.minecraft.world.inventory.BrewingStandMenu",
            "net.minecraft.class_3910:net.minecraft.world.inventory.CartographyTableMenu",
            "net.minecraft.class_1707:net.minecraft.world.inventory.ChestMenu",
            "net.minecraft.class_8881:net.minecraft.world.inventory.CrafterMenu",
            "net.minecraft.class_1714:net.minecraft.world.inventory.CraftingMenu",
            "net.minecraft.class_1716:net.minecraft.world.inventory.DispenserMenu",
            "net.minecraft.class_1718:net.minecraft.world.inventory.EnchantmentMenu",
            "net.minecraft.class_3858:net.minecraft.world.inventory.FurnaceMenu",
            "net.minecraft.class_3803:net.minecraft.world.inventory.GrindstoneMenu",
            "net.minecraft.class_1722:net.minecraft.world.inventory.HopperMenu",
            "net.minecraft.class_1724:net.minecraft.world.inventory.HorseInventoryMenu",
            "net.minecraft.class_1723:net.minecraft.world.inventory.InventoryMenu",
            "net.minecraft.class_4861:net.minecraft.world.inventory.ItemCombinerMenu",
            "net.minecraft.class_3916:net.minecraft.world.inventory.LecternMenu",
            "net.minecraft.class_1726:net.minecraft.world.inventory.LoomMenu",
            "net.minecraft.class_1728:net.minecraft.world.inventory.MerchantMenu",
            "net.minecraft.class_1729:net.minecraft.world.inventory.RecipeBookMenu",
            "net.minecraft.class_1733:net.minecraft.world.inventory.ShulkerBoxMenu",
            "net.minecraft.class_4862:net.minecraft.world.inventory.SmithingMenu",
            "net.minecraft.class_3706:net.minecraft.world.inventory.SmokerMenu",
            "net.minecraft.class_3971:net.minecraft.world.inventory.StonecutterMenu",
            "net.minecraft.class_481$class_483:net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen$ItemPickerMenu",
    };

    public static boolean isEnabled() {
        return enabled;
    }

    public static String fromObf(String className) {
        if (!enabled) {
            return className;
        }
        return obfToNorm.getOrDefault(className, className);
    }

    public static String toObf(String className) {
        if (!enabled) {
            return className;
        }
        return normToObf.getOrDefault(className, className);
    }

    static {
        for (String c: mappings) {
            String[] parts = c.split(":");
            String obf = parts[0];
            String norm = parts[1];
            obfToNorm.put(obf, norm);
            normToObf.put(norm, obf);
        }
    }
}