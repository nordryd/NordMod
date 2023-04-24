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


# Advanced Items
This involves an item that requires its own class.

1. Create a new class for the item:
```java
public class CustomModItem extends ModItem{
    public CustomModItem(final String name, final Properties itemProperties){
        super(name, itemProperties);
    }
}
```

2. Override and implement whatever methods you want. You can click into the `Item` class and `IForgeItem` interface to see a bunch of methods you can override to create the behavior you want. The world is your oyster! Be creative!
3. Register the item in the `ModItems` class:
```java
public static final Item CUSTOM_MOD_ITEM = new CustomModItem("dowsing_rod",new Item.Properties().tab(ModCreativeModeTab.NORDMOD_TAB));
```
* Don't forget to add the model JSON, `en_us.lang` entry, and the texture itself!

# Item Properties
The `Items` class can be accessed to view how every item in minecraft is defined for perspective on basic properties. Clarifications on more confusing properties and their interactions are detailed below.

## Durability
```java
new Item.Properties().durability(x)
```
Defines how much the item can be used. `x` can be thought of as the item's HP.

To damage an item:
```java
ItemStack#hurtAndBreak(damage, entity, onBreak)
```
`damage` is how much damage is done to the item.
`entity` is (idk what this is lmao, usually the player).
`onBreak` is a `Consumer` that is executed upon the item breaking (the durability reacing 0). Typically this is `(player) -> player.broadcastBreakEvent(player.getUsedItemHand())`
