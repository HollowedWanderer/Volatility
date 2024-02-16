advancement revoke @s only volatility:has_book/inventory25

data modify storage volatility:item StoredEnchantments set from entity @s Inventory[{Slot:34b}].tag.StoredEnchantments

function volatility:replace_book/common

execute unless score enchantCount volatility matches 0 run item modify entity @s inventory.25 volatility:remove_from_book
execute if score enchantCount volatility matches 0 run item replace entity @s inventory.25 with minecraft:book