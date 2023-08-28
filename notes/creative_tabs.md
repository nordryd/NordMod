# Creating a Mod Creative Tab
#### 1. In `ModCreativeModeTab`, create a new `CreativeModeTab`:
```java
public static final CreativeModeTab MOD_CREATIVE_MODE_TAB = new CreativeModeTab("mod_creative_mode_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack();
        }
    };
```
* "mod_creative_mode_tab" is how your creative mode tab is identified by minecraft. _This must be unique_.
* `makeIcon()` should return the item you want to be the icon of the tab. _e.g._ if you want the tab's icon to be a diamond:
```java
public ItemStack makeIcon() {
    return new ItemStack(Items.DIAMOND);
}
```

#### 2. In `en_us.json`, add the following:
```
"itemGroup.mod_creative_mode_tab": "Whatever name you want"
```

### Notes
* `ModCreativeModeTab` serves as the reference for your mod items, in the same way that `CreativeModeTab` is the reference for Minecraft's vanilla creative mode tabs.
