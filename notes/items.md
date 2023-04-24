# Creating a Mod Item
#### 1. In `ModItems`, create a new `ModItem`:
```java
public static final Item MOD_ITEM_NAME = new ModItem("mod_item_name", new Item.Properties())
```
* "mod_item_name" is how your item is identified by minecraft. _This must be unique_.
* Use `Item.Properties().tab()` to specify a creative tab.
#### 2. In the resources folder in **assets.nordmod.models.item** add a file named `mod_item_name.json` containing:
```json
{
  "parent": "item/generated",
  "textures": {
    "layer0": "nordmod:item/mod_item_name"
  }
}
```
#### 3. Ensure that a texture for the item exists in **assets.nordmod.textures.item** called "mod_item_name.png".
#### 4. In `en_us.json`, add the following:
```
"item.nordmod.mod_item_name": "Whatever name you want"
```

### Notes
* `ModItems` serves as the reference for your mod items, in the same way that `Items` is the reference for Minecraft's vanilla items.
