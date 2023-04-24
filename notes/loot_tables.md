# Loot Tables
* Another case where we go to the minecraft vanilla package.
  * This will be especially useful because the loot tables can look a bit intimidating. Just refer to examples to and edit accordingly to create your loot tables.
* _The name of the JSON file must match the block that you want to apply the loot table to._
  * _e.g._ To place a loot table on the Citrine Block, the file must be named `citrine_block.json`.
  
* All tags for loot table JSONs are defined here: https://minecraft.fandom.com/wiki/Loot_table
* You can generate loot table JSONs here (make sure the version is correct): https://misode.github.io/loot-table/

### Defining the "Proper Tool" for a block
#### Defining the proper Tool Type (Pickaxe, Axe, Shovel, Hoe, etc.)
1. In `resources` go to `data.minecraft.tags.blocks.mineable`.
2. Find the JSON file of the tool that should be used to properly mine the block.
3. Add the block to the `"values"` array.
   * _e.g._ To add the Citrine Block, add `"nordmod:citrine_block"`.

#### Defining the proper Tool Tier (Stone, Iron, Diamond, etc.)
1. In `resources` go to `data.minecraft.tags.blocks`.
2. Find the JSON file titled `needs_<tier>_tool.json` where `<tier>` is the material you want the tool to be made of.
   * _e.g._ Blocks that require diamond tools are in `needs_diamond_tool.json`.
3. Add the block to the `"values"` array.
   * _e.g._ To add the Citrine Block, add `"nordmod:citrine_block"`.
  
Altogether, to make it so a Citrine Block requires an Iron Pickaxe (or greater):
1. Add `"nordmod:citrine_block"` to `pickaxe.json`.
2. Add `"nordmod:citrine_block"` to `needs_iron_tool.json`.
3. When defining the `BlockBehaviour` for the block, add `.requiresCorrectToolForDrops()`.
