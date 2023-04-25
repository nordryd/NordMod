# Creating a Mod Block
#### 1. In `ModBlocks`, create a new `ModBlock`:
```java
    public static final Block MOD_BLOCK_NAME = new ModBlock("mod_block_name", CreativeTab,
            BlockBehaviour.Properties);
```
* "mod_block_name" is how your block is identified by minecraft. _This must be unique_.
* `BlockBehaviour.Properties` can be copied from other blocks with `.copy(BlockBehavior)`. Otherwise this works like `Item.Properties`.

#### 2. In the resources folder in **assets.nordmod.blockstates** add a file named `mod_block_name.json` containing:
```json
{
  "variants": {
    "": { "model": "nordmod:block/mod_block_name" }
  }
}
```
* Using `""` means this is the block's permanent state.

3. In the resources folder in **assets.nordmod.models.block** add a file named `mod_block_name.json` containing:
```json
{
  "parent": "block/cube_all",
  "textures": {
    "all": "nordmod:block/mod_block_name"
  }
}
```
* This can be edited later to accomodate different block variants (like wood types and furnace on/off)

#### 3. In the resources folder in **assets.nordmod.models.item** add a file named `mod_block_name.json` containing:
```json
{
  "parent": "nordmod:block/mod_block_name"
}
```
* This must be done because blocks must be registered as blocks for use in the real world, and an item for use in the inventory.
#### 3. Ensure that a texture for the item exists in **assets.nordmod.textures.block** called "mod_block_name.png"
#### 4. In `en_us.json`, add the following:
```
"item.nordmod.mod_block_name": "Whatever name you want"
```

### Notes
* `ModBlocks` serves as the reference for your mod items, in the same way that `Blocks` is the reference for Minecraft's vanilla blocks.

# Advanced Blocks
These involve blocks with their own classes.

1. Create a new class for the item:
```java
public class CustomModBlock extends ModBlock{
    public CustomModBlock(final String name, final Properties itemProperties){
        super(name, itemProperties);
    }
}
```
* It's best practice to end a block's class name with `Block`.
2. Override and implement whatever methods you want. You can click into the `Block` class and `IForgeBlock` interface to see a bunch of methods you can override to create the behavior you want. The world is your oyster! Be creative!
   * If you override a deprecated method, this shouldn't be an issue as long as you don't call `super`. 


# Block Behaviour Properties
The `Blocks` class can be accessed to view how every block in minecraft is defined for perspective on basic properties like material, strength, and sound. Clarifications on more confusing properties and their interactions are detailed below.

## Defining a "correct tool" for drop
```java
BlockBehaviour.Properties#requiresCorrectToolForDrops()
```
A block with this property requires a specific tool and/or minimum tool tier to be successfully mined. See `loot_tables.md` to learn how to define drops from blocks.

#### Defining the correct Tool Type (Pickaxe, Axe, Shovel, Hoe, etc.)
1. In `resources` go to `data.minecraft.tags.blocks.mineable`.
2. Find the JSON file of the tool that should be used to properly mine the block.
3. Add the block to the `"values"` array.
  * _e.g._ To add the Citrine Block, add `"nordmod:citrine_block"`.

#### Defining the minimum Tool Tier (Stone, Iron, Diamond, etc.)
1. In `resources` go to `data.minecraft.tags.blocks`.
2. Find the JSON file titled `needs_<tier>_tool.json` where `<tier>` is the material you want the tool to be made of.
  * _e.g._ Blocks that require diamond tools are in `needs_diamond_tool.json`.
3. Add the block to the `"values"` array.
  * _e.g._ To add the Citrine Block, add `"nordmod:citrine_block"`.

Altogether, _e.g._, to make it so a Citrine Block requires an Iron Pickaxe (or greater):
1. Add `"nordmod:citrine_block"` to `pickaxe.json`.
2. Add `"nordmod:citrine_block"` to `needs_iron_tool.json`.
3. When defining the `BlockBehaviour` for the block, add `.requiresCorrectToolForDrops()`.

# Troubleshooting
* **The block has a texture in the inventory, but not in the real world.**
  * Check your blockstate json, if it exists and is correct.
