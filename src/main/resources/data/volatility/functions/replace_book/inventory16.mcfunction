advancement revoke @s only volatility:has_book/inventory16

data modify storage volatility:item StoredEnchantments set from entity @s Inventory[{Slot:25b}].tag.StoredEnchantments

function volatility:replace_book/common

execute unless score enchantCount volatility matches 0 run item modify entity @s inventory.16 volatility:remove_from_book
execute if score enchantCount volatility matches 0 run item replace entity @s inventory.16 with minecraft:book