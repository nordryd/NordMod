# Translatable Text
Wherever possible, it's best practice to use the `TranslatableComponent` class with a mapping to the lang files so all your messages are in one place, and you can easily define translations.

In code it'll look like:
```java
new TranslatableComponent("item.nordmod.mod_item_name.message_key")
```

In the lang file, it'll look like:
```json
"item.nordmod.mod_item_name.message_key": "This is the message that'll be displayed"
```

* Dev's TODO: How do we do parameterized translatable text?

# Client Side/Server Side
Some objects have a `Level` object, which has a `.isClientSide()` method. Just check for `true`/`false` for client side/server side things.
