advancement revoke @s only volatility:has_book/inventory12

data modify storage volatility:item StoredEnchantments set from entity @s Inventory[{Slot:21b}].tag.StoredEnchantments

function volatility:replace_book/common

execute unless score enchantCount volatility matches 0 run item modify entity @s inventory.12 volatility:remove_from_book
execute if score enchantCount volatility matches 0 run item replace entity @s inventory.12 with minecraft:book