## Creating a Mod Block
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

### Troubleshooting
* **The block has a texture in the inventory, but not in the real world.**
  * Check your blockstate json, if it exists and is correct.
