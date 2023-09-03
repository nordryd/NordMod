package net.nordryd.nordmod.datagen.providers;

import java.util.List;
import java.util.function.Consumer;

import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.nordryd.nordmod.NordMod;
import net.nordryd.nordmod.block.ModBlocks;
import net.nordryd.nordmod.item.ModItems;
import net.nordryd.nordmod.util.ModNamespaceFactory;
import org.jetbrains.annotations.NotNull;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    private static final List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
            ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
            ModBlocks.NETHERRACK_ALEXANDRITE_ORE.get(), ModBlocks.ENDSTONE_ALEXANDRITE_ORE.get());

    public ModRecipeProvider(final PackOutput pPackOutput) {
        super(pPackOutput);
    }

    @Override
    protected void buildRecipes(@NotNull final Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy(AdvancementTriggers.HAS_ALEXANDRITE.getTriggerId(),
                        AdvancementTriggers.HAS_ALEXANDRITE.getTriggers())
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy(AdvancementTriggers.HAS_ALEXANDRITE_BLOCK.getTriggerId(),
                        AdvancementTriggers.HAS_ALEXANDRITE_BLOCK.getTriggers())
                .save(pWriter);

        // This does exactly what the explicitly defined stuff does for the big blocks above
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), RecipeCategory.MISC,
                ModBlocks.RAW_ALEXANDRITE_BLOCK.get(), NordMod.MOD_ID + ":raw_alexandrite", "alexandrite",
                NordMod.MOD_ID + ":raw_alexandrite_block", "alexandrite");

        stairBuilder(ModBlocks.ALEXANDRITE_STAIRS.get(), Ingredient.of(ModBlocks.ALEXANDRITE_BLOCK.get())).unlockedBy(
                        AdvancementTriggers.HAS_ALEXANDRITE_BLOCK.getTriggerId(),
                        AdvancementTriggers.HAS_ALEXANDRITE_BLOCK.getTriggers())
                .save(pWriter);
        stonecutterResultFromBase(pWriter, RecipeCategory.MISC, ModBlocks.ALEXANDRITE_STAIRS.get(),
                ModBlocks.ALEXANDRITE_BLOCK.get());

        slabBuilder(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_SLAB.get(),
                Ingredient.of(ModBlocks.ALEXANDRITE_BLOCK.get())).unlockedBy(
                        AdvancementTriggers.HAS_ALEXANDRITE_BLOCK.getTriggerId(),
                        AdvancementTriggers.HAS_ALEXANDRITE_BLOCK.getTriggers())
                .save(pWriter);
        stonecutterResultFromBase(pWriter, RecipeCategory.MISC, ModBlocks.ALEXANDRITE_SLAB.get(),
                ModBlocks.ALEXANDRITE_BLOCK.get(), 2);

        pressurePlateBuilder(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(),
                Ingredient.of(ModBlocks.ALEXANDRITE_BLOCK.get())).unlockedBy(
                        AdvancementTriggers.HAS_ALEXANDRITE_BLOCK.getTriggerId(),
                        AdvancementTriggers.HAS_ALEXANDRITE_BLOCK.getTriggers())
                .save(pWriter);
        buttonBuilder(ModBlocks.ALEXANDRITE_BUTTON.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).unlockedBy(
                        AdvancementTriggers.HAS_ALEXANDRITE.getTriggerId(), AdvancementTriggers.HAS_ALEXANDRITE.getTriggers())
                .save(pWriter);

        oreSmelting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200,
                "alexandrite");
        oreBlasting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100,
                "alexandrite");
    }

    protected static void oreSmelting(final Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            final List<ItemLike> pIngredients, final RecipeCategory pCategory, final ItemLike pResult,
            final float pExperience, final int pCookingTIme, final String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_smelting");
    }

    protected static void oreBlasting(final Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            final List<ItemLike> pIngredients, final RecipeCategory pCategory, final ItemLike pResult,
            final float pExperience, final int pCookingTime, final String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_blasting");
    }

    protected static void oreCooking(final Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            final RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
            final List<ItemLike> pIngredients, final RecipeCategory pCategory, final ItemLike pResult,
            final float pExperience, final int pCookingTime, final String pGroup, final String pRecipeName) {
        for (final ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pCookingSerializer)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,
                            ModNamespaceFactory.getModNamespace() + getItemName(pResult) + pRecipeName + "_" +
                                    getItemName(itemlike));
        }
    }

    protected static void stonecutterResultFromBase(final Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            final RecipeCategory pCategory, final ItemLike pResult, final ItemLike pMaterial) {
        stonecutterResultFromBase(pFinishedRecipeConsumer, pCategory, pResult, pMaterial, 1);
    }

    protected static void stonecutterResultFromBase(final Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            final RecipeCategory pCategory, final ItemLike pResult, final ItemLike pMaterial, final int pResultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(pMaterial), pCategory, pResult, pResultCount)
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(pFinishedRecipeConsumer,
                        ModNamespaceFactory.getModNamespace() + getConversionRecipeName(pResult, pMaterial) +
                                "_stonecutting");
    }

    private enum AdvancementTriggers
    {
        HAS_ALEXANDRITE("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                .of(ModItems.ALEXANDRITE.get())
                .build())),
        HAS_ALEXANDRITE_BLOCK("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item()
                .of(ModBlocks.ALEXANDRITE_BLOCK.get())
                .build()));

        private final String triggerId;
        private final CriterionTriggerInstance triggers;

        AdvancementTriggers(final String triggerId, final CriterionTriggerInstance triggers) {
            this.triggerId = triggerId;
            this.triggers = triggers;
        }

        private String getTriggerId() {
            return triggerId;
        }

        private CriterionTriggerInstance getTriggers() {
            return triggers;
        }
    }
}
